<%@ page import="org.brewmaster.Recipe" %>



<div class="fieldcontain ${hasErrors(bean: recipeInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="recipe.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${recipeInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recipeInstance, field: 'description', 'error')} required">
    <label for="description">
        <g:message code="recipe.description.label" default="Description"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textArea name="description" cols="40" rows="5" maxlength="1024" required=""
                value="${recipeInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recipeInstance, field: 'hops', 'error')} ">
    <label for="hops">
        <g:message code="recipe.hops.label" default="Hops"/>

    </label>
    <g:select name="hops" from="${org.brewmaster.Hop.list()}" multiple="multiple" optionKey="id" size="5"
              value="${recipeInstance?.hops*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recipeInstance, field: 'malts', 'error')} ">
    <label for="malts">
        <g:message code="recipe.malts.label" default="Malts"/>

    </label>
    <g:select name="malts" from="${org.brewmaster.Malt.list()}" multiple="multiple" optionKey="id" size="5"
              value="${recipeInstance?.malts*.id}" class="many-to-many"/>
</div>

