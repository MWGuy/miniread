<%@ tag pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="/"><c:out value="${environment.getProperty('spring.application.name')}"/></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/">Главная</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" method="get" action="/search">
                <input class="form-control mr-sm-2" name="query" type="search" placeholder="Что ищем?"
                       aria-label="Search" value="${searchQuery}">
                <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Поиск</button>
            </form>
        </div>
    </div>
</nav>
