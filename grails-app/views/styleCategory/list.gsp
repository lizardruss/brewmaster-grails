<%@ page import="org.brewmaster.StyleCategory" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'styleCategory.label', default: 'StyleCategory')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-styleCategory" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                    default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-styleCategory" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="name" title="${message(code: 'styleCategory.name.label', default: 'Name')}"/>

            <g:sortableColumn property="description"
                              title="${message(code: 'styleCategory.description.label', default: 'Description')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${styleCategoryInstanceList}" status="i" var="styleCategoryInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${styleCategoryInstance.id}">${fieldValue(bean: styleCategoryInstance, field: "name")}</g:link></td>

                <td>${fieldValue(bean: styleCategoryInstance, field: "description")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${styleCategoryInstanceTotal}"/>
    </div>
</div>
</body>
</html>
