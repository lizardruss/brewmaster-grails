package org.brewmaster

import org.springframework.dao.DataIntegrityViolationException

import grails.converters.JSON
import grails.converters.XML

class HopController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def all = Hop.list(params);
        withFormat {
            html {
                [hopInstanceList: all, hopInstanceTotal: Hop.count()]
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
        [hopInstance: new Hop(params)]
    }

    def save() {
        def hopInstance = new Hop(params)
        if (!hopInstance.save(flush: true)) {
            render(view: "create", model: [hopInstance: hopInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'hop.label', default: 'Hop'), hopInstance.id])
        redirect(action: "show", id: hopInstance.id)
    }

    def show(Long id) {
        def hopInstance = Hop.get(id)
        if (!hopInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hop.label', default: 'Hop'), id])
            redirect(action: "list")
            return
        }

        [hopInstance: hopInstance]
    }

    def edit(Long id) {
        def hopInstance = Hop.get(id)
        if (!hopInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hop.label', default: 'Hop'), id])
            redirect(action: "list")
            return
        }

        [hopInstance: hopInstance]
    }

    def update(Long id, Long version) {
        def hopInstance = Hop.get(id)
        if (!hopInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hop.label', default: 'Hop'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (hopInstance.version > version) {
                hopInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'hop.label', default: 'Hop')] as Object[],
                          "Another user has updated this Hop while you were editing")
                render(view: "edit", model: [hopInstance: hopInstance])
                return
            }
        }

        hopInstance.properties = params

        if (!hopInstance.save(flush: true)) {
            render(view: "edit", model: [hopInstance: hopInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'hop.label', default: 'Hop'), hopInstance.id])
        redirect(action: "show", id: hopInstance.id)
    }

    def delete(Long id) {
        def hopInstance = Hop.get(id)
        if (!hopInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hop.label', default: 'Hop'), id])
            redirect(action: "list")
            return
        }

        try {
            hopInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'hop.label', default: 'Hop'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'hop.label', default: 'Hop'), id])
            redirect(action: "show", id: id)
        }
    }
}
