<%@ page import="org.brewmaster.StyleStatistics" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'styleStatistics.label', default: 'StyleStatistics')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-styleStatistics" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                      default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-styleStatistics" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list styleStatistics">

        <g:if test="${styleStatisticsInstance?.name}">
            <li class="fieldcontain">
                <span id="name-label" class="property-label"><g:message code="styleStatistics.name.label"
                                                                        default="Name"/></span>

                <span class="property-value" aria-labelledby="name-label"><g:fieldValue
                        bean="${styleStatisticsInstance}" field="name"/></span>

            </li>
        </g:if>

        <g:if test="${styleStatisticsInstance?.description}">
            <li class="fieldcontain">
                <span id="description-label" class="property-label"><g:message code="styleStatistics.description.label"
                                                                               default="Description"/></span>

                <span class="property-value" aria-labelledby="description-label"><g:fieldValue
                        bean="${styleStatisticsInstance}" field="description"/></span>

            </li>
        </g:if>

        <g:if test="${styleStatisticsInstance?.alcoholByVolume}">
            <li class="fieldcontain">
                <span id="alcoholByVolume-label" class="property-label"><g:message
                        code="styleStatistics.alcoholByVolume.label" default="Alcohol By Volume"/></span>

                <span class="property-value" aria-labelledby="alcoholByVolume-label"><g:fieldValue
                        bean="${styleStatisticsInstance}" field="alcoholByVolume"/></span>

            </li>
        </g:if>

        <g:if test="${styleStatisticsInstance?.bitterness}">
            <li class="fieldcontain">
                <span id="bitterness-label" class="property-label"><g:message code="styleStatistics.bitterness.label"
                                                                              default="Bitterness"/></span>

                <span class="property-value" aria-labelledby="bitterness-label"><g:fieldValue
                        bean="${styleStatisticsInstance}" field="bitterness"/></span>

            </li>
        </g:if>

        <g:if test="${styleStatisticsInstance?.color}">
            <li class="fieldcontain">
                <span id="color-label" class="property-label"><g:message code="styleStatistics.color.label"
                                                                         default="Color"/></span>

                <span class="property-value" aria-labelledby="color-label"><g:fieldValue
                        bean="${styleStatisticsInstance}" field="color"/></span>

            </li>
        </g:if>

        <g:if test="${styleStatisticsInstance?.finalGravity}">
            <li class="fieldcontain">
                <span id="finalGravity-label" class="property-label"><g:message
                        code="styleStatistics.finalGravity.label" default="Final Gravity"/></span>

                <span class="property-value" aria-labelledby="finalGravity-label"><g:fieldValue
                        bean="${styleStatisticsInstance}" field="finalGravity"/></span>

            </li>
        </g:if>

        <g:if test="${styleStatisticsInstance?.originalGravity}">
            <li class="fieldcontain">
                <span id="originalGravity-label" class="property-label"><g:message
                        code="styleStatistics.originalGravity.label" default="Original Gravity"/></span>

                <span class="property-value" aria-labelledby="originalGravity-label"><g:fieldValue
                        bean="${styleStatisticsInstance}" field="originalGravity"/></span>

            </li>
        </g:if>

    </ol>
    <g:form>
        <fieldset class="buttons">
            <g:hiddenField name="id" value="${styleStatisticsInstance?.id}"/>
            <g:link class="edit" action="edit" id="${styleStatisticsInstance?.id}"><g:message
                    code="default.button.edit.label" default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
