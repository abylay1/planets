<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--  Tag libs  --%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

    <title>Авторизация</title>

    <%-- Import bootstrap css --%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

    <!-- Local CSS -->
    <style>
        <%@ include file="/css/register.css"%>
    </style>
</head>
<body>
    <div class="container" style="margin-top: 150px;">
        <div class="row">
            <div class="col-md-offset-3 col-md-6 ">
                <form class="form-horizontal" action="${pageContext.request.contextPath}/admin/login" method="post">
                    <span class="heading">Авторизация</span>
                    <div class="form-group">
                        <input class="form-control" id="login" name="login" type="text" placeholder="Логин" required>
                        <i class="fa fa-user"></i>
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="inputPassword" name="password" type="password" placeholder="Пароль" required>
                        <i class="fa fa-lock"></i>
                    </div>
                    <c:if test="${requestScope.errorAuthorization == true}">
                        <div class="alert alert-danger" role="alert">
                            Неправильный логин или пароль!
                        </div>
                    </c:if>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default">Войти</button>
                        <div style="text-align: center; margin-top: 10px">
                            <a href="${pageContext.request.contextPath}/admin/register"><small class="form-text text-muted">Регистрация</small></a>
                        </div>
                    </div>
                </form>
            </div>
        </div><!-- /.row -->
    </div><!-- /.container -->
</body>
</html>
