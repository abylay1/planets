<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%--  Tag libs  --%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

    <title>Регистрация</title>

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
                <form class="form-horizontal" action="${pageContext.request.contextPath}/admin/register" method="post">
                    <span class="heading">Регистрация</span>
                    <div class="form-group ">
                        <input type="text" class="form-control" id="userFirstName" name="userFirstName" placeholder="Имя" required>
                    </div>
                    <div class="form-group ">
                        <input type="text" class="form-control" id="userLastName" name="userLastName" placeholder="Фамилия" required>
                    </div>
                    <div class="form-group ">
                        <input type="email" class="form-control" id="userEmail" name="userEmail" placeholder="Почта" required>
                    </div>
                    <div class="form-group ">
                        <input type="text" class="form-control" id="userLogin" name="userLogin" placeholder="Логин" required>
                    </div>
                    <div class="form-group help">
                        <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="Пароль" required>
                        <i class="fa fa-lock"></i>
                    </div>
                    <c:if test="${requestScope.isLoginExist == true}">
                        <div class="alert alert-danger" role="alert">
                            Такой логин уже существует!
                        </div>
                    </c:if>
                    <c:if test="${requestScope.isSuccessRegister == true}">
                        <div class="alert alert-success" role="alert">
                            Вы успешно зарегистрированы! <a href="${pageContext.request.contextPath}/admin/login">войти в аккаунт</a>
                        </div>
                    </c:if>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default">Регистрация</button>
                    </div>
                </form>
            </div>
        </div><!-- /.row -->
    </div><!-- /.container -->
</body>
</html>
