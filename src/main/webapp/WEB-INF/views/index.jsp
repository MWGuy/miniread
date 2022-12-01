<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base>
    <c:if test="${latestManga.size() > 0}">
        <div class="mt-2">
            <div class="shadow-sm mb-2 bg-white rounded flex-box">
                <h4 class="p-3 mb-0">Новая манга</h4>
                <ul class="list-group list-group-flush border-top">
                    <c:forEach var="manga" items="${latestManga}">
                        <li class="list-group-item">
                            <a href="${'/manga/'.concat(manga.getSlug())}">
                                <c:out value="${manga.getCanonicalName()}"/>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </c:if>
    <c:if test="${latestChapters.size() > 0}">
        <div class="mt-2">
            <div class="shadow-sm mb-2 bg-white rounded flex-box">
                <h4 class="p-3 mb-0">Новые главы</h4>
                <ul class="list-group list-group-flush border-top">
                    <c:forEach var="chapter" items="${latestChapters}">
                        <li class="list-group-item d-flex justify-content-between">
                            <div>
                                <div>
                                    <a href="${'/chapter/'.concat(chapter.getId())}">
                                        <c:out value="${chapter.getFormattedName()}"/>
                                    </a>
                                </div>
                                <div>
                                    <a href="${'/manga/'.concat(chapter.getBranch().getManga().getSlug())}">
                                        <c:out value="${chapter.getBranch().getManga().getCanonicalName()}"/>
                                    </a>
                                </div>
                            </div>
                            <div class="text-right">
                                <c:out value="${dateService.formatDate(chapter.getCreatedAt())}"/>
                                <div class="pl-1">
                                    <c:out value="${chapter.getBranch().getTeamNames()}"/>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </c:if>
</t:base>
