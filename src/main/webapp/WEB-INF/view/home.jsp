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
            <a class="navbar-brand" href="#" style="color: blue;">Космос</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/admin">Басты бет <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/admin/small-planets">Үлкен планеталар</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/admin/big-planets">Кіші планеталар</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/admin/calculate">Есептеу</a>
                    </li>
                </ul>
                <div class="user-info" style="color: white; margin-right: 15px">
                    <strong>
                        <c:out value="${requestScope.user.firstName}"/>
                    </strong>
                    <strong>
                        <c:out value="${requestScope.user.lastName}"/>
                    </strong>
                </div>
                <div class="logout">
                    <a href="${pageContext.request.contextPath}/admin/logout" class="btn btn-primary" role="button">Выйти</a>
                </div>
            </div>
        </div>
    </nav>

    <main>
        <div class="container-fluid">
            <h1 style="text-align:center; margin-bottom: 20px; margin-top: 30px">Планеталар</h1>
            <hr>
            <section class="planets" style="margin-bottom: 40px; margin-top: 30px;">
                <div class="row">
                    <c:forEach var="planet" items="${requestScope.planets}">
                    <div class="col-3">
                        <div class="card" style="width: 18rem; margin: 0 auto; overflow: hidden;">
                            <div class="card-body" style="padding: 0;">
                                <div style="min-height: 300px; display:flex; flex-direction: column; justify-content: space-between;">
                                    <img class="card-img-top" style="object-fit:cover; display: block;" src="${pageContext.request.contextPath}/images/${planet.image}" alt="${planet.name}">
                                    <div style="padding: 20px;">
                                        <h5 class="card-title"><c:out value="${planet.name}"/></h5>
                                        <c:if test="${planet.big == true}">
                                            <p class="card-text">Үлкен планета</p>
                                        </c:if>
                                        <c:if test="${planet.small == true}">
                                            <p class="card-text">Кіші планета</p>
                                        </c:if>
                                    </div>
                                </div>
                                <button type="button" class="btn btn-success" data-toggle="collapse" href="#collapse${planet.ID}" role="button" style="width: 100%; border-radius: 0;" aria-expanded="false" aria-controls="collapse1">Толығырақ</button>
                                <div class="collapse" id="collapse${planet.ID}" style="padding-bottom: 10px;">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item ">Планета: <c:out value="${planet.name}" /></li>
                                        <li class="list-group-item ">Масса: <c:out value="${planet.mass}"/></li>
                                        <li class="list-group-item ">Бетінің ауданы: <c:out value="${planet.area}"/> км²</li>
                                        <li class="list-group-item ">Күннен қашықтық: <c:out value="${planet.distance}"/> км</li>
                                        <li class="list-group-item ">Айналу уақыты: <c:out value="${planet.periodCircle}"/> күн</li>
                                        <li class="list-group-item ">Радиус: <c:out value="${planet.radius}"/> км</li>
                                        <li class="list-group-item ">Еркін құлау жылдамдығы: <c:out value="${planet.gravity}"/> м/с²</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
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
