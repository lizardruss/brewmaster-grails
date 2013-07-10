<%@ page import="org.brewmaster.StyleStatistics" %>



<div class="fieldcontain ${hasErrors(bean: styleStatisticsInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="styleStatistics.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${styleStatisticsInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: styleStatisticsInstance, field: 'description', 'error')} required">
    <label for="description">
        <g:message code="styleStatistics.description.label" default="Description"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textArea name="description" cols="40" rows="5" maxlength="1024" required=""
                value="${styleStatisticsInstance?.description}"/>
</div>
<fieldset class="embedded"><legend><g:message code="styleStatistics.alcoholByVolume.label"
                                              default="Alcohol By Volume"/></legend>

    <div class="fieldcontain ${hasErrors(bean: styleStatisticsInstance, field: 'alcoholByVolume.from', 'error')} required">
        <label for="alcoholByVolume.from">
            <g:message code="styleStatistics.alcoholByVolume.from.label" default="From"/>
            <span class="required-indicator">*</span>
        </label>
        <g:field name="alcoholByVolume.from" value="${fieldValue(bean: styleStatisticsInstance, field: 'alcoholByVolume.from')}" required=""/>
    </div>

    <div class="fieldcontain ${hasErrors(bean: styleStatisticsInstance, field: 'alcoholByVolume.to', 'error')} required">
        <label for="alcoholByVolume.to">
            <g:message code="styleStatistics.alcoholByVolume.to.label" default="To"/>
            <span class="required-indicator">*</span>
        </label>
        <g:field name="alcoholByVolume.to" value="${fieldValue(bean: styleStatisticsInstance, field: 'alcoholByVolume.to')}" required=""/>
    </div>
</fieldset><fieldset class="embedded"><legend><g:message code="styleStatistics.bitterness.label"
                                                         default="Bitterness"/></legend>

    <div class="fieldcontain ${hasErrors(bean: styleStatisticsInstance, field: 'bitterness.from', 'error')} required">
        <label for="bitterness.from">
            <g:message code="styleStatistics.bitterness.from.label" default="From"/>
            <span class="required-indicator">*</span>
        </label>
        <g:field name="bitterness.from" value="${fieldValue(bean: styleStatisticsInstance, field: 'bitterness.from')}" required=""/>
    </div>

    <div class="fieldcontain ${hasErrors(bean: styleStatisticsInstance, field: 'bitterness.to', 'error')} required">
        <label for="bitterness.to">
            <g:message code="styleStatistics.bitterness.to.label" default="To"/>
            <span class="required-indicator">*</span>
        </label>
        <g:field name="bitterness.to" value="${fieldValue(bean: styleStatisticsInstance, field: 'bitterness.to')}" required=""/>
    </div>
</fieldset><fieldset class="embedded"><legend><g:message code="styleStatistics.color.label" default="Color"/></legend>

    <div class="fieldcontain ${hasErrors(bean: styleStatisticsInstance, field: 'color.from', 'error')} required">
        <label for="color.from">
            <g:message code="styleStatistics.color.from.label" default="From"/>
            <span class="required-indicator">*</span>
        </label>
        <g:field name="color.from" value="${fieldValue(bean: styleStatisticsInstance, field: 'color.from')}" required=""/>
    </div>

    <div class="fieldcontain ${hasErrors(bean: styleStatisticsInstance, field: 'color.to', 'error')} required">
        <label for="color.to">
            <g:message code="styleStatistics.color.to.label" default="To"/>
            <span class="required-indicator">*</span>
        </label>
        <g:field name="color.to" value="${fieldValue(bean: styleStatisticsInstance, field: 'color.to')}" required=""/>
    </div>
</fieldset><fieldset class="embedded"><legend><g:message code="styleStatistics.finalGravity.label"
                                                         default="Final Gravity"/></legend>

    <div class="fieldcontain ${hasErrors(bean: styleStatisticsInstance, field: 'finalGravity.from', 'error')} required">
        <label for="finalGravity.from">
            <g:message code="styleStatistics.finalGravity.from.label" default="From"/>
            <span class="required-indicator">*</span>
        </label>
        <g:field name="finalGravity.from" value="${fieldValue(bean: styleStatisticsInstance, field: 'finalGravity.from')}" required=""/>
    </div>

    <div class="fieldcontain ${hasErrors(bean: styleStatisticsInstance, field: 'finalGravity.to', 'error')} required">
        <label for="finalGravity.to">
            <g:message code="styleStatistics.finalGravity.to.label" default="To"/>
            <span class="required-indicator">*</span>
        </label>
        <g:field name="finalGravity.to" value="${fieldValue(bean: styleStatisticsInstance, field: 'finalGravity.to')}" required=""/>
    </div>
</fieldset><fieldset class="embedded"><legend><g:message code="styleStatistics.originalGravity.label"
                                                         default="Original Gravity"/></legend>

    <div class="fieldcontain ${hasErrors(bean: styleStatisticsInstance, field: 'originalGravity.from', 'error')} required">
        <label for="originalGravity.from">
            <g:message code="styleStatistics.originalGravity.from.label" default="From"/>
            <span class="required-indicator">*</span>
        </label>
        <g:field name="originalGravity.from" value="${fieldValue(bean: styleStatisticsInstance, field: 'originalGravity.from')}" required=""/>
    </div>

    <div class="fieldcontain ${hasErrors(bean: styleStatisticsInstance, field: 'originalGravity.to', 'error')} required">
        <label for="originalGravity.to">
            <g:message code="styleStatistics.originalGravity.to.label" default="To"/>
            <span class="required-indicator">*</span>
        </label>
        <g:field name="originalGravity.to" value="${fieldValue(bean: styleStatisticsInstance, field: 'originalGravity.to')}" required=""/>
    </div>
</fieldset>
