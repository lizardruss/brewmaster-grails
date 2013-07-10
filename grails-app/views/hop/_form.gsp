<%@ page import="org.brewmaster.Hop" %>



<div class="fieldcontain ${hasErrors(bean: hopInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="hop.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${hopInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hopInstance, field: 'description', 'error')} required">
    <label for="description">
        <g:message code="hop.description.label" default="Description"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textArea name="description" cols="40" rows="5" maxlength="1024" required="" value="${hopInstance?.description}"/>
</div>
<fieldset class="embedded"><legend><g:message code="hop.alphaAcidRange.label" default="Alpha Acid Range"/></legend>

    <div class="fieldcontain ${hasErrors(bean: hopInstance, field: 'alphaAcidRange.from', 'error')} required">
        <label for="alphaAcidRange.from">
            <g:message code="hop.alphaAcidRange.from.label" default="From"/>
            <span class="required-indicator">*</span>
        </label>
        <g:field name="alphaAcidRange.from" value="${fieldValue(bean: hopInstance, field: 'alphaAcidRange.from')}" required=""/>
    </div>

    <div class="fieldcontain ${hasErrors(bean: hopInstance, field: 'alphaAcidRange.to', 'error')} required">
        <label for="alphaAcidRange.to">
            <g:message code="hop.alphaAcidRange.to.label" default="To"/>
            <span class="required-indicator">*</span>
        </label>
        <g:field name="alphaAcidRange.to" value="${fieldValue(bean: hopInstance, field: 'alphaAcidRange.to')}" required=""/>
    </div>
</fieldset>

<div class="fieldcontain ${hasErrors(bean: hopInstance, field: 'aroma', 'error')} ">
    <label for="aroma">
        <g:message code="hop.aroma.label" default="Aroma"/>

    </label>
    <g:textField name="aroma" value="${hopInstance?.aroma}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hopInstance, field: 'origin', 'error')} ">
    <label for="origin">
        <g:message code="hop.origin.label" default="Origin"/>

    </label>
    <g:textField name="origin" value="${hopInstance?.origin}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hopInstance, field: 'substitutes', 'error')} ">
    <label for="substitutes">
        <g:message code="hop.substitutes.label" default="Substitutes"/>

    </label>
    <g:select name="substitutes" from="${org.brewmaster.Hop.list()}" multiple="multiple" optionKey="id" size="5"
              value="${hopInstance?.substitutes*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hopInstance, field: 'uses', 'error')} ">
    <label for="uses">
        <g:message code="hop.uses.label" default="Uses"/>

    </label>
    <g:select name="uses" from="${org.brewmaster.HopUsage.list()}" multiple="multiple" optionKey="id" size="5"
              value="${hopInstance?.uses*.id}" class="many-to-many"/>
</div>

