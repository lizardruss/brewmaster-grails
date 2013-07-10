<%@ page import="org.brewmaster.Style" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'style.label', default: 'Style')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-style" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                            default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-style" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="name" title="${message(code: 'style.name.label', default: 'Name')}"/>

            <g:sortableColumn property="description"
                              title="${message(code: 'style.description.label', default: 'Description')}"/>

            <g:sortableColumn property="appearance"
                              title="${message(code: 'style.appearance.label', default: 'Appearance')}"/>

            <g:sortableColumn property="aroma" title="${message(code: 'style.aroma.label', default: 'Aroma')}"/>

            <g:sortableColumn property="comments"
                              title="${message(code: 'style.comments.label', default: 'Comments')}"/>

            <g:sortableColumn property="flavor" title="${message(code: 'style.flavor.label', default: 'Flavor')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${styleInstanceList}" status="i" var="styleInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${styleInstance.id}">${fieldValue(bean: styleInstance, field: "name")}</g:link></td>

                <td>${fieldValue(bean: styleInstance, field: "description")}</td>

                <td>${fieldValue(bean: styleInstance, field: "appearance")}</td>

                <td>${fieldValue(bean: styleInstance, field: "aroma")}</td>

                <td>${fieldValue(bean: styleInstance, field: "comments")}</td>

                <td>${fieldValue(bean: styleInstance, field: "flavor")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${styleInstanceTotal}"/>
    </div>
</div>
</body>
</html>
