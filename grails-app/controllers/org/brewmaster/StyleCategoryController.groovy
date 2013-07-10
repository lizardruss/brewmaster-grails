package org.brewmaster

import org.springframework.dao.DataIntegrityViolationException

import grails.converters.JSON
import grails.converters.XML

class StyleCategoryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def all = StyleCategory.list(params);
        withFormat {
            html {
                [styleCategoryInstanceList: all, styleCategoryInstanceTotal: StyleCategory.count()]
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
        [styleCategoryInstance: new StyleCategory(params)]
    }

    def save() {
        def styleCategoryInstance = new StyleCategory(params)
        if (!styleCategoryInstance.save(flush: true)) {
            render(view: "create", model: [styleCategoryInstance: styleCategoryInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'styleCategory.label', default: 'StyleCategory'), styleCategoryInstance.id])
        redirect(action: "show", id: styleCategoryInstance.id)
    }

    def show(Long id) {
        def styleCategoryInstance = StyleCategory.get(id)
        if (!styleCategoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'styleCategory.label', default: 'StyleCategory'), id])
            redirect(action: "list")
            return
        }

        [styleCategoryInstance: styleCategoryInstance]
    }

    def edit(Long id) {
        def styleCategoryInstance = StyleCategory.get(id)
        if (!styleCategoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'styleCategory.label', default: 'StyleCategory'), id])
            redirect(action: "list")
            return
        }

        [styleCategoryInstance: styleCategoryInstance]
    }

    def update(Long id, Long version) {
        def styleCategoryInstance = StyleCategory.get(id)
        if (!styleCategoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'styleCategory.label', default: 'StyleCategory'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (styleCategoryInstance.version > version) {
                styleCategoryInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'styleCategory.label', default: 'StyleCategory')] as Object[],
                          "Another user has updated this StyleCategory while you were editing")
                render(view: "edit", model: [styleCategoryInstance: styleCategoryInstance])
                return
            }
        }

        styleCategoryInstance.properties = params

        if (!styleCategoryInstance.save(flush: true)) {
            render(view: "edit", model: [styleCategoryInstance: styleCategoryInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'styleCategory.label', default: 'StyleCategory'), styleCategoryInstance.id])
        redirect(action: "show", id: styleCategoryInstance.id)
    }

    def delete(Long id) {
        def styleCategoryInstance = StyleCategory.get(id)
        if (!styleCategoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'styleCategory.label', default: 'StyleCategory'), id])
            redirect(action: "list")
            return
        }

        try {
            styleCategoryInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'styleCategory.label', default: 'StyleCategory'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'styleCategory.label', default: 'StyleCategory'), id])
            redirect(action: "show", id: id)
        }
    }
}
