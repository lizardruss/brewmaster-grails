package org.brewmaster



import org.junit.*
import grails.test.mixin.*

@TestFor(StyleCategoryController)
@Mock(StyleCategory)
class StyleCategoryControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/styleCategory/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.styleCategoryInstanceList.size() == 0
        assert model.styleCategoryInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.styleCategoryInstance != null
    }

    void testSave() {
        controller.save()

        assert model.styleCategoryInstance != null
        assert view == '/styleCategory/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/styleCategory/show/1'
        assert controller.flash.message != null
        assert StyleCategory.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/styleCategory/list'

        populateValidParams(params)
        def styleCategory = new StyleCategory(params)

        assert styleCategory.save() != null

        params.id = styleCategory.id

        def model = controller.show()

        assert model.styleCategoryInstance == styleCategory
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/styleCategory/list'

        populateValidParams(params)
        def styleCategory = new StyleCategory(params)

        assert styleCategory.save() != null

        params.id = styleCategory.id

        def model = controller.edit()

        assert model.styleCategoryInstance == styleCategory
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/styleCategory/list'

        response.reset()

        populateValidParams(params)
        def styleCategory = new StyleCategory(params)

        assert styleCategory.save() != null

        // test invalid parameters in update
        params.id = styleCategory.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/styleCategory/edit"
        assert model.styleCategoryInstance != null

        styleCategory.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/styleCategory/show/$styleCategory.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        styleCategory.clearErrors()

        populateValidParams(params)
        params.id = styleCategory.id
        params.version = -1
        controller.update()

        assert view == "/styleCategory/edit"
        assert model.styleCategoryInstance != null
        assert model.styleCategoryInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/styleCategory/list'

        response.reset()

        populateValidParams(params)
        def styleCategory = new StyleCategory(params)

        assert styleCategory.save() != null
        assert StyleCategory.count() == 1

        params.id = styleCategory.id

        controller.delete()

        assert StyleCategory.count() == 0
        assert StyleCategory.get(styleCategory.id) == null
        assert response.redirectedUrl == '/styleCategory/list'
    }
}
