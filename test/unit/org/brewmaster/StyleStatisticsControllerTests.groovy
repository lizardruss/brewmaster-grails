package org.brewmaster



import org.junit.*
import grails.test.mixin.*

@TestFor(StyleStatisticsController)
@Mock(StyleStatistics)
class StyleStatisticsControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/styleStatistics/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.styleStatisticsInstanceList.size() == 0
        assert model.styleStatisticsInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.styleStatisticsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.styleStatisticsInstance != null
        assert view == '/styleStatistics/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/styleStatistics/show/1'
        assert controller.flash.message != null
        assert StyleStatistics.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/styleStatistics/list'

        populateValidParams(params)
        def styleStatistics = new StyleStatistics(params)

        assert styleStatistics.save() != null

        params.id = styleStatistics.id

        def model = controller.show()

        assert model.styleStatisticsInstance == styleStatistics
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/styleStatistics/list'

        populateValidParams(params)
        def styleStatistics = new StyleStatistics(params)

        assert styleStatistics.save() != null

        params.id = styleStatistics.id

        def model = controller.edit()

        assert model.styleStatisticsInstance == styleStatistics
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/styleStatistics/list'

        response.reset()

        populateValidParams(params)
        def styleStatistics = new StyleStatistics(params)

        assert styleStatistics.save() != null

        // test invalid parameters in update
        params.id = styleStatistics.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/styleStatistics/edit"
        assert model.styleStatisticsInstance != null

        styleStatistics.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/styleStatistics/show/$styleStatistics.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        styleStatistics.clearErrors()

        populateValidParams(params)
        params.id = styleStatistics.id
        params.version = -1
        controller.update()

        assert view == "/styleStatistics/edit"
        assert model.styleStatisticsInstance != null
        assert model.styleStatisticsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/styleStatistics/list'

        response.reset()

        populateValidParams(params)
        def styleStatistics = new StyleStatistics(params)

        assert styleStatistics.save() != null
        assert StyleStatistics.count() == 1

        params.id = styleStatistics.id

        controller.delete()

        assert StyleStatistics.count() == 0
        assert StyleStatistics.get(styleStatistics.id) == null
        assert response.redirectedUrl == '/styleStatistics/list'
    }
}
