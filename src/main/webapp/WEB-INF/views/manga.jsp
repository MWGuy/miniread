<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base>
    <div class="media shadow-sm p-3 mb-2 bg-white rounded">
        <img alt="Постер" src="${manga.getPoster()}" width="150px" class="align-self-start mr-3 rounded">
        <div class="media-body">
            <h6 class="font-monospace">
                <c:out value="${manga.getAlternativeNames()}"/>
            </h6>
            <h4 class="fw-bold">
                <c:out value="${manga.getCanonicalName()}"/>
            </h4>
            <p>
                <c:out value="${manga.getDescription()}" default="Нет описания"/>
            </p>
        </div>
    </div>
    <c:choose>
        <c:when test="${manga.getBranches().size() > 0}">
            <div class="shadow-sm mb-2 bg-white rounded">
                <c:if test="${manga.getBranches().size() == 0}">
                    <ul class="p-3 nav nav-pills" id="branches-tab" role="tablist">
                        <c:forEach var="branch" items="${manga.getBranches()}" varStatus="loop">
                            <li class="nav-item" role="presentation">
                                <a class="${'nav-link '.concat(loop.first ? 'active' : '')}"
                                   id="${'branch-tab-'.concat(branch.getId().toString())}"
                                   data-toggle="pill"
                                   role="tab"
                                   href="${'#branch-content-'.concat(branch.getId().toString())}"
                                   aria-controls="${branch.getId().toString()}"
                                   aria-selected="true"
                                >
                                    <c:out value="${branch.getTeamNames()}"/>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>
                <div class="tab-content" id="branches-content">
                    <c:forEach var="branch" varStatus="loop" items="${manga.getBranches()}">
                        <div class="${'tab-pane fade '.concat(loop.first ? 'show active' : '')}"
                             id="${'branch-content-'.concat(branch.getId().toString())}"
                             aria-labelledby="${'branch-tab-'.concat(branch.getId().toString())}"
                             role="tabpanel"
                        >
                            <c:choose>
                                <c:when test="${branch.getChapters().size() > 0}">
                                    <c:forEach var="chapter" items="${branch.getChapters()}">
                                        <li class="list-group-item d-flex justify-content-between">
                                            <a href="${'/chapter/'.concat(chapter.getId().toString())}">
                                                <c:out value="${chapter.getFormattedName()}"/>
                                            </a>
                                            <div>
                                                <c:out value="${dateService.formatDate(chapter.getCreatedAt())}"/>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <div class="text-center p-1 pb-4">
                                        Нет глав...
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <div class="p-1 shadow-sm bg-white rounded text-center">
                Веток нет...
            </div>
        </c:otherwise>
    </c:choose>
</t:base>
