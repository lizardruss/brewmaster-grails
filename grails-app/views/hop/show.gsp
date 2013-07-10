<%@ page import="org.brewmaster.Hop" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'hop.label', default: 'Hop')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-hop" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                          default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-hop" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list hop">

        <g:if test="${hopInstance?.name}">
            <li class="fieldcontain">
                <span id="name-label" class="property-label"><g:message code="hop.name.label" default="Name"/></span>

                <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${hopInstance}"
                                                                                        field="name"/></span>

            </li>
        </g:if>

        <g:if test="${hopInstance?.description}">
            <li class="fieldcontain">
                <span id="description-label" class="property-label"><g:message code="hop.description.label"
                                                                               default="Description"/></span>

                <span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${hopInstance}"
                                                                                               field="description"/></span>

            </li>
        </g:if>

        <g:if test="${hopInstance?.alphaAcidRange}">
            <li class="fieldcontain">
                <span id="alphaAcidRange-label" class="property-label"><g:message code="hop.alphaAcidRange.label"
                                                                                  default="Alpha Acid Range"/></span>

                <span class="property-value" aria-labelledby="alphaAcidRange-label"><g:fieldValue bean="${hopInstance}"
                                                                                                  field="alphaAcidRange"/></span>

            </li>
        </g:if>

        <g:if test="${hopInstance?.aroma}">
            <li class="fieldcontain">
                <span id="aroma-label" class="property-label"><g:message code="hop.aroma.label" default="Aroma"/></span>

                <span class="property-value" aria-labelledby="aroma-label"><g:fieldValue bean="${hopInstance}"
                                                                                         field="aroma"/></span>

            </li>
        </g:if>

        <g:if test="${hopInstance?.origin}">
            <li class="fieldcontain">
                <span id="origin-label" class="property-label"><g:message code="hop.origin.label"
                                                                          default="Origin"/></span>

                <span class="property-value" aria-labelledby="origin-label"><g:fieldValue bean="${hopInstance}"
                                                                                          field="origin"/></span>

            </li>
        </g:if>

        <g:if test="${hopInstance?.substitutes}">
            <li class="fieldcontain">
                <span id="substitutes-label" class="property-label"><g:message code="hop.substitutes.label"
                                                                               default="Substitutes"/></span>

                <g:each in="${hopInstance.substitutes}" var="s">
                    <span class="property-value" aria-labelledby="substitutes-label"><g:link controller="hop"
                                                                                             action="show"
                                                                                             id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
                </g:each>

            </li>
        </g:if>

        <g:if test="${hopInstance?.uses}">
            <li class="fieldcontain">
                <span id="uses-label" class="property-label"><g:message code="hop.uses.label" default="Uses"/></span>

                <g:each in="${hopInstance.uses}" var="u">
                    <span class="property-value" aria-labelledby="uses-label"><g:link controller="hopUsage"
                                                                                      action="show"
                                                                                      id="${u.id}">${u?.encodeAsHTML()}</g:link></span>
                </g:each>

            </li>
        </g:if>

    </ol>
    <g:form>
        <fieldset class="buttons">
            <g:hiddenField name="id" value="${hopInstance?.id}"/>
            <g:link class="edit" action="edit" id="${hopInstance?.id}"><g:message code="default.button.edit.label"
                                                                                  default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
