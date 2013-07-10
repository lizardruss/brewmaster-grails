<%@ page import="org.brewmaster.HopUsage" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'hopUsage.label', default: 'HopUsage')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-hopUsage" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                               default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-hopUsage" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list hopUsage">

        <g:if test="${hopUsageInstance?.name}">
            <li class="fieldcontain">
                <span id="name-label" class="property-label"><g:message code="hopUsage.name.label"
                                                                        default="Name"/></span>

                <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${hopUsageInstance}"
                                                                                        field="name"/></span>

            </li>
        </g:if>

        <g:if test="${hopUsageInstance?.description}">
            <li class="fieldcontain">
                <span id="description-label" class="property-label"><g:message code="hopUsage.description.label"
                                                                               default="Description"/></span>

                <span class="property-value" aria-labelledby="description-label"><g:fieldValue
                        bean="${hopUsageInstance}" field="description"/></span>

            </li>
        </g:if>

        <g:if test="${hopUsageInstance?.instructions}">
            <li class="fieldcontain">
                <span id="instructions-label" class="property-label"><g:message code="hopUsage.instructions.label"
                                                                                default="Instructions"/></span>

                <span class="property-value" aria-labelledby="instructions-label"><g:fieldValue
                        bean="${hopUsageInstance}" field="instructions"/></span>

            </li>
        </g:if>

    </ol>
    <g:form>
        <fieldset class="buttons">
            <g:hiddenField name="id" value="${hopUsageInstance?.id}"/>
            <g:link class="edit" action="edit" id="${hopUsageInstance?.id}"><g:message code="default.button.edit.label"
                                                                                       default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
