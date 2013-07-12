package org.brewmaster



import org.springframework.dao.DataIntegrityViolationException

import grails.converters.JSON
import grails.converters.XML
import grails.plugins.springsecurity.Secured

class BrewerController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    @Secured(['ROLE_USER'])
    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def all = Brewer.list(params);
        withFormat {
            html {
                [brewerInstanceList: all, brewerInstanceTotal: Brewer.count()]
            }
            xml {
                render all as XML
            }
            json {
                render all as JSON
            }
        }
    }

    @Secured(['ROLE_USER', 'IS_AUTHENTICATED_FULLY'])
    def create() {
        [brewerInstance: new Brewer(params)]
    }

    @Secured(['ROLE_USER', 'IS_AUTHENTICATED_FULLY'])
    def save() {
        def brewerInstance = new Brewer(params)
        if (!brewerInstance.save(flush: true)) {
            render(view: "create", model: [brewerInstance: brewerInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'brewer.label', default: 'Brewer'), brewerInstance.id])
        redirect(action: "show", id: brewerInstance.id)
    }

    @Secured(['ROLE_USER'])
    def show(Long id) {
        def brewerInstance = Brewer.get(id)
        if (!brewerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'brewer.label', default: 'Brewer'), id])
            redirect(action: "list")
            return
        }

        [brewerInstance: brewerInstance]
    }

    @Secured(['ROLE_USER', 'IS_AUTHENTICATED_FULLY'])
    def edit(Long id) {
        def brewerInstance = Brewer.get(id)
        if (!brewerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'brewer.label', default: 'Brewer'), id])
            redirect(action: "list")
            return
        }

        [brewerInstance: brewerInstance]
    }

    @Secured(['ROLE_USER', 'IS_AUTHENTICATED_FULLY'])
    def update(Long id, Long version) {
        def brewerInstance = Brewer.get(id)
        if (!brewerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'brewer.label', default: 'Brewer'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (brewerInstance.version > version) {
                brewerInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'brewer.label', default: 'Brewer')] as Object[],
                          "Another user has updated this Brewer while you were editing")
                render(view: "edit", model: [brewerInstance: brewerInstance])
                return
            }
        }

        brewerInstance.properties = params

        if (!brewerInstance.save(flush: true)) {
            render(view: "edit", model: [brewerInstance: brewerInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'brewer.label', default: 'Brewer'), brewerInstance.id])
        redirect(action: "show", id: brewerInstance.id)
    }

    @Secured(['ROLE_USER', 'IS_AUTHENTICATED_FULLY'])
    def delete(Long id) {
        def brewerInstance = Brewer.get(id)
        if (!brewerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'brewer.label', default: 'Brewer'), id])
            redirect(action: "list")
            return
        }

        try {
            brewerInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'brewer.label', default: 'Brewer'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'brewer.label', default: 'Brewer'), id])
            redirect(action: "show", id: id)
        }
    }
}
