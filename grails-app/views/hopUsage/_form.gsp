<%@ page import="org.brewmaster.HopUsage" %>



<div class="fieldcontain ${hasErrors(bean: hopUsageInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="hopUsage.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${hopUsageInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hopUsageInstance, field: 'description', 'error')} required">
    <label for="description">
        <g:message code="hopUsage.description.label" default="Description"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textArea name="description" cols="40" rows="5" maxlength="1024" required=""
                value="${hopUsageInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hopUsageInstance, field: 'instructions', 'error')} ">
    <label for="instructions">
        <g:message code="hopUsage.instructions.label" default="Instructions"/>

    </label>

</div>

