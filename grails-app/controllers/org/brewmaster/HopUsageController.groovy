package org.brewmaster

import org.springframework.dao.DataIntegrityViolationException

import grails.converters.JSON
import grails.converters.XML

class HopUsageController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def all = HopUsage.list(params);
        withFormat {
            html {
                [hopUsageInstanceList: all, hopUsageInstanceTotal: HopUsage.count()]
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
        [hopUsageInstance: new HopUsage(params)]
    }

    def save() {
        def hopUsageInstance = new HopUsage(params)
        if (!hopUsageInstance.save(flush: true)) {
            render(view: "create", model: [hopUsageInstance: hopUsageInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'hopUsage.label', default: 'HopUsage'), hopUsageInstance.id])
        redirect(action: "show", id: hopUsageInstance.id)
    }

    def show(Long id) {
        def hopUsageInstance = HopUsage.get(id)
        if (!hopUsageInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hopUsage.label', default: 'HopUsage'), id])
            redirect(action: "list")
            return
        }

        [hopUsageInstance: hopUsageInstance]
    }

    def edit(Long id) {
        def hopUsageInstance = HopUsage.get(id)
        if (!hopUsageInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hopUsage.label', default: 'HopUsage'), id])
            redirect(action: "list")
            return
        }

        [hopUsageInstance: hopUsageInstance]
    }

    def update(Long id, Long version) {
        def hopUsageInstance = HopUsage.get(id)
        if (!hopUsageInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hopUsage.label', default: 'HopUsage'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (hopUsageInstance.version > version) {
                hopUsageInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'hopUsage.label', default: 'HopUsage')] as Object[],
                          "Another user has updated this HopUsage while you were editing")
                render(view: "edit", model: [hopUsageInstance: hopUsageInstance])
                return
            }
        }

        hopUsageInstance.properties = params

        if (!hopUsageInstance.save(flush: true)) {
            render(view: "edit", model: [hopUsageInstance: hopUsageInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'hopUsage.label', default: 'HopUsage'), hopUsageInstance.id])
        redirect(action: "show", id: hopUsageInstance.id)
    }

    def delete(Long id) {
        def hopUsageInstance = HopUsage.get(id)
        if (!hopUsageInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hopUsage.label', default: 'HopUsage'), id])
            redirect(action: "list")
            return
        }

        try {
            hopUsageInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'hopUsage.label', default: 'HopUsage'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'hopUsage.label', default: 'HopUsage'), id])
            redirect(action: "show", id: id)
        }
    }
}
