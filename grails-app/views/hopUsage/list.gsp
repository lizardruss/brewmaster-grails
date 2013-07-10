<%@ page import="org.brewmaster.HopUsage" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'hopUsage.label', default: 'HopUsage')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-hopUsage" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                               default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-hopUsage" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="name" title="${message(code: 'hopUsage.name.label', default: 'Name')}"/>

            <g:sortableColumn property="description"
                              title="${message(code: 'hopUsage.description.label', default: 'Description')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${hopUsageInstanceList}" status="i" var="hopUsageInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${hopUsageInstance.id}">${fieldValue(bean: hopUsageInstance, field: "name")}</g:link></td>

                <td>${fieldValue(bean: hopUsageInstance, field: "description")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${hopUsageInstanceTotal}"/>
    </div>
</div>
</body>
</html>
