package org.brewmaster



import org.junit.*
import grails.test.mixin.*

@TestFor(DescribableController)
@Mock(Describable)
class DescribableControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/describable/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.describableInstanceList.size() == 0
        assert model.describableInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.describableInstance != null
    }

    void testSave() {
        controller.save()

        assert model.describableInstance != null
        assert view == '/describable/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/describable/show/1'
        assert controller.flash.message != null
        assert Describable.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/describable/list'

        populateValidParams(params)
        def describable = new Describable(params)

        assert describable.save() != null

        params.id = describable.id

        def model = controller.show()

        assert model.describableInstance == describable
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/describable/list'

        populateValidParams(params)
        def describable = new Describable(params)

        assert describable.save() != null

        params.id = describable.id

        def model = controller.edit()

        assert model.describableInstance == describable
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/describable/list'

        response.reset()

        populateValidParams(params)
        def describable = new Describable(params)

        assert describable.save() != null

        // test invalid parameters in update
        params.id = describable.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/describable/edit"
        assert model.describableInstance != null

        describable.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/describable/show/$describable.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        describable.clearErrors()

        populateValidParams(params)
        params.id = describable.id
        params.version = -1
        controller.update()

        assert view == "/describable/edit"
        assert model.describableInstance != null
        assert model.describableInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/describable/list'

        response.reset()

        populateValidParams(params)
        def describable = new Describable(params)

        assert describable.save() != null
        assert Describable.count() == 1

        params.id = describable.id

        controller.delete()

        assert Describable.count() == 0
        assert Describable.get(describable.id) == null
        assert response.redirectedUrl == '/describable/list'
    }
}
