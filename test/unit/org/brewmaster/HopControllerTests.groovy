package org.brewmaster



import org.junit.*
import grails.test.mixin.*

@TestFor(HopController)
@Mock(Hop)
class HopControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/hop/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.hopInstanceList.size() == 0
        assert model.hopInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.hopInstance != null
    }

    void testSave() {
        controller.save()

        assert model.hopInstance != null
        assert view == '/hop/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/hop/show/1'
        assert controller.flash.message != null
        assert Hop.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/hop/list'

        populateValidParams(params)
        def hop = new Hop(params)

        assert hop.save() != null

        params.id = hop.id

        def model = controller.show()

        assert model.hopInstance == hop
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/hop/list'

        populateValidParams(params)
        def hop = new Hop(params)

        assert hop.save() != null

        params.id = hop.id

        def model = controller.edit()

        assert model.hopInstance == hop
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/hop/list'

        response.reset()

        populateValidParams(params)
        def hop = new Hop(params)

        assert hop.save() != null

        // test invalid parameters in update
        params.id = hop.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/hop/edit"
        assert model.hopInstance != null

        hop.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/hop/show/$hop.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        hop.clearErrors()

        populateValidParams(params)
        params.id = hop.id
        params.version = -1
        controller.update()

        assert view == "/hop/edit"
        assert model.hopInstance != null
        assert model.hopInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/hop/list'

        response.reset()

        populateValidParams(params)
        def hop = new Hop(params)

        assert hop.save() != null
        assert Hop.count() == 1

        params.id = hop.id

        controller.delete()

        assert Hop.count() == 0
        assert Hop.get(hop.id) == null
        assert response.redirectedUrl == '/hop/list'
    }
}
