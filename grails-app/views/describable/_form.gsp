<%@ page import="org.brewmaster.Describable" %>



<div class="fieldcontain ${hasErrors(bean: describableInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="describable.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${describableInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: describableInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="describable.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="1024" required="" value="${describableInstance?.description}"/>
</div>

