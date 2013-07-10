package org.brewmaster

import org.springframework.dao.DataIntegrityViolationException

import grails.converters.JSON
import grails.converters.XML

class RecipeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def all = Recipe.list(params);
        withFormat {
            html {
                [recipeInstanceList: all, recipeInstanceTotal: Recipe.count()]
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
        [recipeInstance: new Recipe(params)]
    }

    def save() {
        def recipeInstance = new Recipe(params)
        if (!recipeInstance.save(flush: true)) {
            render(view: "create", model: [recipeInstance: recipeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'recipe.label', default: 'Recipe'), recipeInstance.id])
        redirect(action: "show", id: recipeInstance.id)
    }

    def show(Long id) {
        def recipeInstance = Recipe.get(id)
        if (!recipeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'recipe.label', default: 'Recipe'), id])
            redirect(action: "list")
            return
        }

        [recipeInstance: recipeInstance]
    }

    def edit(Long id) {
        def recipeInstance = Recipe.get(id)
        if (!recipeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'recipe.label', default: 'Recipe'), id])
            redirect(action: "list")
            return
        }

        [recipeInstance: recipeInstance]
    }

    def update(Long id, Long version) {
        def recipeInstance = Recipe.get(id)
        if (!recipeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'recipe.label', default: 'Recipe'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (recipeInstance.version > version) {
                recipeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'recipe.label', default: 'Recipe')] as Object[],
                          "Another user has updated this Recipe while you were editing")
                render(view: "edit", model: [recipeInstance: recipeInstance])
                return
            }
        }

        recipeInstance.properties = params

        if (!recipeInstance.save(flush: true)) {
            render(view: "edit", model: [recipeInstance: recipeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'recipe.label', default: 'Recipe'), recipeInstance.id])
        redirect(action: "show", id: recipeInstance.id)
    }

    def delete(Long id) {
        def recipeInstance = Recipe.get(id)
        if (!recipeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'recipe.label', default: 'Recipe'), id])
            redirect(action: "list")
            return
        }

        try {
            recipeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'recipe.label', default: 'Recipe'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'recipe.label', default: 'Recipe'), id])
            redirect(action: "show", id: id)
        }
    }
}
