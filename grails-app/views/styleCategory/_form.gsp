<%@ page import="org.brewmaster.StyleCategory" %>



<div class="fieldcontain ${hasErrors(bean: styleCategoryInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="styleCategory.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${styleCategoryInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: styleCategoryInstance, field: 'description', 'error')} required">
    <label for="description">
        <g:message code="styleCategory.description.label" default="Description"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textArea name="description" cols="40" rows="5" maxlength="1024" required=""
                value="${styleCategoryInstance?.description}"/>
</div>

