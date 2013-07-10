package org.brewmaster

import org.springframework.dao.DataIntegrityViolationException

import grails.converters.JSON
import grails.converters.XML

class StyleStatisticsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def all = StyleStatistics.list(params);
        withFormat {
            html {
                [styleStatisticsInstanceList: all, styleStatisticsInstanceTotal: StyleStatistics.count()]
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
        [styleStatisticsInstance: new StyleStatistics(params)]
    }

    def save() {
        def styleStatisticsInstance = new StyleStatistics(params)
        if (!styleStatisticsInstance.save(flush: true)) {
            render(view: "create", model: [styleStatisticsInstance: styleStatisticsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'styleStatistics.label', default: 'StyleStatistics'), styleStatisticsInstance.id])
        redirect(action: "show", id: styleStatisticsInstance.id)
    }

    def show(Long id) {
        def styleStatisticsInstance = StyleStatistics.get(id)
        if (!styleStatisticsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'styleStatistics.label', default: 'StyleStatistics'), id])
            redirect(action: "list")
            return
        }

        [styleStatisticsInstance: styleStatisticsInstance]
    }

    def edit(Long id) {
        def styleStatisticsInstance = StyleStatistics.get(id)
        if (!styleStatisticsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'styleStatistics.label', default: 'StyleStatistics'), id])
            redirect(action: "list")
            return
        }

        [styleStatisticsInstance: styleStatisticsInstance]
    }

    def update(Long id, Long version) {
        def styleStatisticsInstance = StyleStatistics.get(id)
        if (!styleStatisticsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'styleStatistics.label', default: 'StyleStatistics'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (styleStatisticsInstance.version > version) {
                styleStatisticsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'styleStatistics.label', default: 'StyleStatistics')] as Object[],
                          "Another user has updated this StyleStatistics while you were editing")
                render(view: "edit", model: [styleStatisticsInstance: styleStatisticsInstance])
                return
            }
        }

        styleStatisticsInstance.properties = params

        if (!styleStatisticsInstance.save(flush: true)) {
            render(view: "edit", model: [styleStatisticsInstance: styleStatisticsInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'styleStatistics.label', default: 'StyleStatistics'), styleStatisticsInstance.id])
        redirect(action: "show", id: styleStatisticsInstance.id)
    }

    def delete(Long id) {
        def styleStatisticsInstance = StyleStatistics.get(id)
        if (!styleStatisticsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'styleStatistics.label', default: 'StyleStatistics'), id])
            redirect(action: "list")
            return
        }

        try {
            styleStatisticsInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'styleStatistics.label', default: 'StyleStatistics'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'styleStatistics.label', default: 'StyleStatistics'), id])
            redirect(action: "show", id: id)
        }
    }
}
