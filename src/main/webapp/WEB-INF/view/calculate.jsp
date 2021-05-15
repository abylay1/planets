<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%--  Tag libs  --%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

    <title>Регистрация</title>

    <%-- Import bootstrap css --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous" />

    <!-- Local CSS -->
    <style>
        <%@ include file="/css/style.css"%>
        .back{
            background-color: blue;
        }
    </style>

    <%--  Jquery  --%>
    <script src="${pageContext.request.contextPath}/scripts/lib/jquery-3.5.1.min.js"></script>
</head>
<body>
<%--  Navigation  --%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/admin" style="color: blue;">Космос</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin">Басты бет</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/big-planets">Үлкен планеталар</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/small-planets">Кіші планеталар</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/calculate">Есептеу</a>
                </li>
            </ul>
            <div class="user-info" style="color: white; margin-right: 15px; position: relative;">
                <a href="${pageContext.request.contextPath}/admin/profile" style="">
                    <i class="bi bi-person-circle"></i>
                    <c:out value="${requestScope.user.firstName}"/>
                    <c:out value="${requestScope.user.lastName}"/>
                </a>
            </div>
            <div class="logout">
                <a href="${pageContext.request.contextPath}/admin/logout" class="btn btn-primary" role="button">Выйти</a>
            </div>
        </div>
    </div>
</nav>

<main>
    <div class="container-fluid">
        <h1 style="text-align:center; margin-bottom: 20px; margin-top: 30px">Есептеу</h1>
        <hr>
        <form action="${pageContext.request.contextPath}/admin/calculate" method="post" style="width: 300px;">
            <select class="form-select mb-3"  name="first-planet-ID" id="planet1">
                <c:forEach var="planet" items="${requestScope.planets}">
                    <option value="${planet.ID}"><c:out value="${planet.name}"/></option>
                </c:forEach>
            </select>
            <select class="form-select mb-3"  name="second-planet-ID" id="planet2">
                <c:forEach var="planet" items="${requestScope.planets}">
                    <option value="${planet.ID}"><c:out value="${planet.name}"/></option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-primary">Есептеу</button>
        </form>
        <section class="result">
            <c:if test="${requestScope.distance != null}">
                <div class="card" style="width: 50%;">
                    <div class="card-body">
                        <em><c:out value="${requestScope.planet1.name}"/></em> дан <em><c:out value="${requestScope.planet2.name}"/>ге</em> дейін ара қашықтық - <strong><c:out value="${requestScope.distance}"/> км</strong>
                    </div>
                </div>
            </c:if>
        </section>
    </div>
    <footer class="footer" style="background-color:#198754; width: 100%; position: absolute; bottom: 0; height: 50px; display:flex; align-items: center; justify-content: center">
        <div style="text-align: center; color: white;">
            Все права защищены 2021 год
        </div>
    </footer>
</main>

<%--  Libs  --%>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
