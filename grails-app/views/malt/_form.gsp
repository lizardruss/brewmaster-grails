<%@ page import="org.brewmaster.Malt" %>



<div class="fieldcontain ${hasErrors(bean: maltInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="malt.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${maltInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: maltInstance, field: 'description', 'error')} required">
    <label for="description">
        <g:message code="malt.description.label" default="Description"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textArea name="description" cols="40" rows="5" maxlength="1024" required=""
                value="${maltInstance?.description}"/>
</div>

