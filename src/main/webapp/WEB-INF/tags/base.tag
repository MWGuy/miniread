<%@ tag pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page>
    <body class="d-flex flex-column vh-100">
        <t:navbar/>
        <div class="container mt-2">
            <jsp:doBody/>
        </div>
    </body>
</t:page>
