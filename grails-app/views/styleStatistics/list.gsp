<%@ page import="org.brewmaster.StyleStatistics" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'styleStatistics.label', default: 'StyleStatistics')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-styleStatistics" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                      default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-styleStatistics" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="name" title="${message(code: 'styleStatistics.name.label', default: 'Name')}"/>

            <g:sortableColumn property="description"
                              title="${message(code: 'styleStatistics.description.label', default: 'Description')}"/>

            <th><g:message code="styleStatistics.alcoholByVolume.label" default="Alcohol By Volume"/></th>

            <th><g:message code="styleStatistics.bitterness.label" default="Bitterness"/></th>

            <th><g:message code="styleStatistics.color.label" default="Color"/></th>

            <th><g:message code="styleStatistics.finalGravity.label" default="Final Gravity"/></th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${styleStatisticsInstanceList}" status="i" var="styleStatisticsInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${styleStatisticsInstance.id}">${fieldValue(bean: styleStatisticsInstance, field: "name")}</g:link></td>

                <td>${fieldValue(bean: styleStatisticsInstance, field: "description")}</td>

                <td>${fieldValue(bean: styleStatisticsInstance, field: "alcoholByVolume")}</td>

                <td>${fieldValue(bean: styleStatisticsInstance, field: "bitterness")}</td>

                <td>${fieldValue(bean: styleStatisticsInstance, field: "color")}</td>

                <td>${fieldValue(bean: styleStatisticsInstance, field: "finalGravity")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${styleStatisticsInstanceTotal}"/>
    </div>
</div>
</body>
</html>
