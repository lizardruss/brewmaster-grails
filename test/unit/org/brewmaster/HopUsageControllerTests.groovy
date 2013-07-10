package org.brewmaster



import org.junit.*
import grails.test.mixin.*

@TestFor(HopUsageController)
@Mock(HopUsage)
class HopUsageControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/hopUsage/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.hopUsageInstanceList.size() == 0
        assert model.hopUsageInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.hopUsageInstance != null
    }

    void testSave() {
        controller.save()

        assert model.hopUsageInstance != null
        assert view == '/hopUsage/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/hopUsage/show/1'
        assert controller.flash.message != null
        assert HopUsage.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/hopUsage/list'

        populateValidParams(params)
        def hopUsage = new HopUsage(params)

        assert hopUsage.save() != null

        params.id = hopUsage.id

        def model = controller.show()

        assert model.hopUsageInstance == hopUsage
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/hopUsage/list'

        populateValidParams(params)
        def hopUsage = new HopUsage(params)

        assert hopUsage.save() != null

        params.id = hopUsage.id

        def model = controller.edit()

        assert model.hopUsageInstance == hopUsage
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/hopUsage/list'

        response.reset()

        populateValidParams(params)
        def hopUsage = new HopUsage(params)

        assert hopUsage.save() != null

        // test invalid parameters in update
        params.id = hopUsage.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/hopUsage/edit"
        assert model.hopUsageInstance != null

        hopUsage.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/hopUsage/show/$hopUsage.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        hopUsage.clearErrors()

        populateValidParams(params)
        params.id = hopUsage.id
        params.version = -1
        controller.update()

        assert view == "/hopUsage/edit"
        assert model.hopUsageInstance != null
        assert model.hopUsageInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/hopUsage/list'

        response.reset()

        populateValidParams(params)
        def hopUsage = new HopUsage(params)

        assert hopUsage.save() != null
        assert HopUsage.count() == 1

        params.id = hopUsage.id

        controller.delete()

        assert HopUsage.count() == 0
        assert HopUsage.get(hopUsage.id) == null
        assert response.redirectedUrl == '/hopUsage/list'
    }
}
