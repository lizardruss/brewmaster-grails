package org.brewmaster

import org.springframework.dao.DataIntegrityViolationException

import grails.converters.JSON
import grails.converters.XML

class MaltController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def all = Malt.list(params);
        withFormat {
            html {
                [maltInstanceList: all, maltInstanceTotal: Malt.count()]
            }
            xml {
                render all as XML
            }
            json {
                render all as JSON
            }
        }
    }

    def create() {
        [maltInstance: new Malt(params)]
    }

    def save() {
        def maltInstance = new Malt(params)
        if (!maltInstance.save(flush: true)) {
            render(view: "create", model: [maltInstance: maltInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'malt.label', default: 'Malt'), maltInstance.id])
        redirect(action: "show", id: maltInstance.id)
    }

    def show(Long id) {
        def maltInstance = Malt.get(id)
        if (!maltInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'malt.label', default: 'Malt'), id])
            redirect(action: "list")
            return
        }

        [maltInstance: maltInstance]
    }

    def edit(Long id) {
        def maltInstance = Malt.get(id)
        if (!maltInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'malt.label', default: 'Malt'), id])
            redirect(action: "list")
            return
        }

        [maltInstance: maltInstance]
    }

    def update(Long id, Long version) {
        def maltInstance = Malt.get(id)
        if (!maltInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'malt.label', default: 'Malt'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (maltInstance.version > version) {
                maltInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'malt.label', default: 'Malt')] as Object[],
                          "Another user has updated this Malt while you were editing")
                render(view: "edit", model: [maltInstance: maltInstance])
                return
            }
        }

        maltInstance.properties = params

        if (!maltInstance.save(flush: true)) {
            render(view: "edit", model: [maltInstance: maltInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'malt.label', default: 'Malt'), maltInstance.id])
        redirect(action: "show", id: maltInstance.id)
    }

    def delete(Long id) {
        def maltInstance = Malt.get(id)
        if (!maltInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'malt.label', default: 'Malt'), id])
            redirect(action: "list")
            return
        }

        try {
            maltInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'malt.label', default: 'Malt'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'malt.label', default: 'Malt'), id])
            redirect(action: "show", id: id)
        }
    }
}
