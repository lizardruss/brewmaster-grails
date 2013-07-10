<%@ page import="org.brewmaster.Style" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'style.label', default: 'Style')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-style" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                            default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-style" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list style">

        <g:if test="${styleInstance?.name}">
            <li class="fieldcontain">
                <span id="name-label" class="property-label"><g:message code="style.name.label" default="Name"/></span>

                <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${styleInstance}"
                                                                                        field="name"/></span>

            </li>
        </g:if>

        <g:if test="${styleInstance?.description}">
            <li class="fieldcontain">
                <span id="description-label" class="property-label"><g:message code="style.description.label"
                                                                               default="Description"/></span>

                <span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${styleInstance}"
                                                                                               field="description"/></span>

            </li>
        </g:if>

        <g:if test="${styleInstance?.appearance}">
            <li class="fieldcontain">
                <span id="appearance-label" class="property-label"><g:message code="style.appearance.label"
                                                                              default="Appearance"/></span>

                <span class="property-value" aria-labelledby="appearance-label"><g:fieldValue bean="${styleInstance}"
                                                                                              field="appearance"/></span>

            </li>
        </g:if>

        <g:if test="${styleInstance?.aroma}">
            <li class="fieldcontain">
                <span id="aroma-label" class="property-label"><g:message code="style.aroma.label"
                                                                         default="Aroma"/></span>

                <span class="property-value" aria-labelledby="aroma-label"><g:fieldValue bean="${styleInstance}"
                                                                                         field="aroma"/></span>

            </li>
        </g:if>

        <g:if test="${styleInstance?.comments}">
            <li class="fieldcontain">
                <span id="comments-label" class="property-label"><g:message code="style.comments.label"
                                                                            default="Comments"/></span>

                <span class="property-value" aria-labelledby="comments-label"><g:fieldValue bean="${styleInstance}"
                                                                                            field="comments"/></span>

            </li>
        </g:if>

        <g:if test="${styleInstance?.flavor}">
            <li class="fieldcontain">
                <span id="flavor-label" class="property-label"><g:message code="style.flavor.label"
                                                                          default="Flavor"/></span>

                <span class="property-value" aria-labelledby="flavor-label"><g:fieldValue bean="${styleInstance}"
                                                                                          field="flavor"/></span>

            </li>
        </g:if>

        <g:if test="${styleInstance?.history}">
            <li class="fieldcontain">
                <span id="history-label" class="property-label"><g:message code="style.history.label"
                                                                           default="History"/></span>

                <span class="property-value" aria-labelledby="history-label"><g:fieldValue bean="${styleInstance}"
                                                                                           field="history"/></span>

            </li>
        </g:if>

        <g:if test="${styleInstance?.impression}">
            <li class="fieldcontain">
                <span id="impression-label" class="property-label"><g:message code="style.impression.label"
                                                                              default="Impression"/></span>

                <span class="property-value" aria-labelledby="impression-label"><g:fieldValue bean="${styleInstance}"
                                                                                              field="impression"/></span>

            </li>
        </g:if>

        <g:if test="${styleInstance?.ingredients}">
            <li class="fieldcontain">
                <span id="ingredients-label" class="property-label"><g:message code="style.ingredients.label"
                                                                               default="Ingredients"/></span>

                <span class="property-value" aria-labelledby="ingredients-label"><g:fieldValue bean="${styleInstance}"
                                                                                               field="ingredients"/></span>

            </li>
        </g:if>

        <g:if test="${styleInstance?.mouthfeel}">
            <li class="fieldcontain">
                <span id="mouthfeel-label" class="property-label"><g:message code="style.mouthfeel.label"
                                                                             default="Mouthfeel"/></span>

                <span class="property-value" aria-labelledby="mouthfeel-label"><g:fieldValue bean="${styleInstance}"
                                                                                             field="mouthfeel"/></span>

            </li>
        </g:if>

        <g:if test="${styleInstance?.statistics}">
            <li class="fieldcontain">
                <span id="statistics-label" class="property-label"><g:message code="style.statistics.label"
                                                                              default="Statistics"/></span>

                <g:each in="${styleInstance.statistics}" var="s">
                    <span class="property-value" aria-labelledby="statistics-label"><g:link controller="styleStatistics"
                                                                                            action="show"
                                                                                            id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
                </g:each>

            </li>
        </g:if>

    </ol>
    <g:form>
        <fieldset class="buttons">
            <g:hiddenField name="id" value="${styleInstance?.id}"/>
            <g:link class="edit" action="edit" id="${styleInstance?.id}"><g:message code="default.button.edit.label"
                                                                                    default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
