package org.brewmaster



import org.junit.*
import grails.test.mixin.*

@TestFor(BrewerController)
@Mock(Brewer)
class BrewerControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/brewer/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.brewerInstanceList.size() == 0
        assert model.brewerInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.brewerInstance != null
    }

    void testSave() {
        controller.save()

        assert model.brewerInstance != null
        assert view == '/brewer/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/brewer/show/1'
        assert controller.flash.message != null
        assert Brewer.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/brewer/list'

        populateValidParams(params)
        def brewer = new Brewer(params)

        assert brewer.save() != null

        params.id = brewer.id

        def model = controller.show()

        assert model.brewerInstance == brewer
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/brewer/list'

        populateValidParams(params)
        def brewer = new Brewer(params)

        assert brewer.save() != null

        params.id = brewer.id

        def model = controller.edit()

        assert model.brewerInstance == brewer
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/brewer/list'

        response.reset()

        populateValidParams(params)
        def brewer = new Brewer(params)

        assert brewer.save() != null

        // test invalid parameters in update
        params.id = brewer.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/brewer/edit"
        assert model.brewerInstance != null

        brewer.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/brewer/show/$brewer.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        brewer.clearErrors()

        populateValidParams(params)
        params.id = brewer.id
        params.version = -1
        controller.update()

        assert view == "/brewer/edit"
        assert model.brewerInstance != null
        assert model.brewerInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/brewer/list'

        response.reset()

        populateValidParams(params)
        def brewer = new Brewer(params)

        assert brewer.save(failOnError: true) != null
        assert Brewer.count() == 1

        params.id = brewer.id

        controller.delete()

        assert Brewer.count() == 0
        assert Brewer.get(brewer.id) == null
        assert response.redirectedUrl == '/brewer/list'
    }
}
