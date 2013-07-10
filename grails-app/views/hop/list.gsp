<%@ page import="org.brewmaster.Hop" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'hop.label', default: 'Hop')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-hop" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                          default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-hop" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="name" title="${message(code: 'hop.name.label', default: 'Name')}"/>

            <g:sortableColumn property="description"
                              title="${message(code: 'hop.description.label', default: 'Description')}"/>

            <th><g:message code="hop.alphaAcidRange.label" default="Alpha Acid Range"/></th>

            <g:sortableColumn property="aroma" title="${message(code: 'hop.aroma.label', default: 'Aroma')}"/>

            <g:sortableColumn property="origin" title="${message(code: 'hop.origin.label', default: 'Origin')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${hopInstanceList}" status="i" var="hopInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${hopInstance.id}">${fieldValue(bean: hopInstance, field: "name")}</g:link></td>

                <td>${fieldValue(bean: hopInstance, field: "description")}</td>

                <td>${fieldValue(bean: hopInstance, field: "alphaAcidRange")}</td>

                <td>${fieldValue(bean: hopInstance, field: "aroma")}</td>

                <td>${fieldValue(bean: hopInstance, field: "origin")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${hopInstanceTotal}"/>
    </div>
</div>
</body>
</html>
