<%@ page import="org.brewmaster.Style" %>



<div class="fieldcontain ${hasErrors(bean: styleInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="style.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${styleInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: styleInstance, field: 'description', 'error')} required">
    <label for="description">
        <g:message code="style.description.label" default="Description"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textArea name="description" cols="40" rows="5" maxlength="1024" required=""
                value="${styleInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: styleInstance, field: 'appearance', 'error')} ">
    <label for="appearance">
        <g:message code="style.appearance.label" default="Appearance"/>

    </label>
    <g:textField name="appearance" value="${styleInstance?.appearance}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: styleInstance, field: 'aroma', 'error')} ">
    <label for="aroma">
        <g:message code="style.aroma.label" default="Aroma"/>

    </label>
    <g:textField name="aroma" value="${styleInstance?.aroma}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: styleInstance, field: 'comments', 'error')} ">
    <label for="comments">
        <g:message code="style.comments.label" default="Comments"/>

    </label>
    <g:textField name="comments" value="${styleInstance?.comments}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: styleInstance, field: 'flavor', 'error')} ">
    <label for="flavor">
        <g:message code="style.flavor.label" default="Flavor"/>

    </label>
    <g:textField name="flavor" value="${styleInstance?.flavor}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: styleInstance, field: 'history', 'error')} ">
    <label for="history">
        <g:message code="style.history.label" default="History"/>

    </label>
    <g:textField name="history" value="${styleInstance?.history}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: styleInstance, field: 'impression', 'error')} ">
    <label for="impression">
        <g:message code="style.impression.label" default="Impression"/>

    </label>
    <g:textField name="impression" value="${styleInstance?.impression}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: styleInstance, field: 'ingredients', 'error')} ">
    <label for="ingredients">
        <g:message code="style.ingredients.label" default="Ingredients"/>

    </label>
    <g:textField name="ingredients" value="${styleInstance?.ingredients}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: styleInstance, field: 'mouthfeel', 'error')} ">
    <label for="mouthfeel">
        <g:message code="style.mouthfeel.label" default="Mouthfeel"/>

    </label>
    <g:textField name="mouthfeel" value="${styleInstance?.mouthfeel}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: styleInstance, field: 'statistics', 'error')} ">
    <label for="statistics">
        <g:message code="style.statistics.label" default="Statistics"/>

    </label>
    <g:select name="statistics" from="${org.brewmaster.StyleStatistics.list()}" multiple="multiple" optionKey="id"
              size="5" value="${styleInstance?.statistics*.id}" class="many-to-many"/>
</div>

