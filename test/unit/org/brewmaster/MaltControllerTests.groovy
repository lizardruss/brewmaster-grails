package org.brewmaster



import org.junit.*
import grails.test.mixin.*

@TestFor(MaltController)
@Mock(Malt)
class MaltControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/malt/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.maltInstanceList.size() == 0
        assert model.maltInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.maltInstance != null
    }

    void testSave() {
        controller.save()

        assert model.maltInstance != null
        assert view == '/malt/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/malt/show/1'
        assert controller.flash.message != null
        assert Malt.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/malt/list'

        populateValidParams(params)
        def malt = new Malt(params)

        assert malt.save() != null

        params.id = malt.id

        def model = controller.show()

        assert model.maltInstance == malt
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/malt/list'

        populateValidParams(params)
        def malt = new Malt(params)

        assert malt.save() != null

        params.id = malt.id

        def model = controller.edit()

        assert model.maltInstance == malt
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/malt/list'

        response.reset()

        populateValidParams(params)
        def malt = new Malt(params)

        assert malt.save() != null

        // test invalid parameters in update
        params.id = malt.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/malt/edit"
        assert model.maltInstance != null

        malt.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/malt/show/$malt.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        malt.clearErrors()

        populateValidParams(params)
        params.id = malt.id
        params.version = -1
        controller.update()

        assert view == "/malt/edit"
        assert model.maltInstance != null
        assert model.maltInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/malt/list'

        response.reset()

        populateValidParams(params)
        def malt = new Malt(params)

        assert malt.save() != null
        assert Malt.count() == 1

        params.id = malt.id

        controller.delete()

        assert Malt.count() == 0
        assert Malt.get(malt.id) == null
        assert response.redirectedUrl == '/malt/list'
    }
}
