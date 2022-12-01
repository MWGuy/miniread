<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page>
    <body class="bg-light">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="${pageContext.request.contextPath}/">
                        <c:out value="${environment.getProperty('spring.application.name')}"/>
                    </a>
                </li>
                <li class="breadcrumb-item">
                    <a href="${'/manga/'.concat(chapter.getBranch().getManga().getSlug())}">
                        <c:out value="${chapter.getBranch().getManga().getCanonicalName()}"/>
                    </a>
                </li>
                <li class="breadcrumb-item active" aria-current="page">
                    <c:out value="${chapter.getFormattedName()}"/>
                </li>
            </ol>
        </nav>
        <div class="container-lg mt-2">
            <div class="shadow-sm p-3 mb-2 bg-white rounded">
                <c:forEach var="page" items="${chapter.getPages()}">
                    <img alt="chapter page" src="${page.getImage()}" width="100%"/>
                </c:forEach>
            </div>
        </div>
    </body>
</t:page>
