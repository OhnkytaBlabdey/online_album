<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/12/25
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registor</title>
    <link rel="stylesheet" href="./css/init.css">
    <link rel="stylesheet" href="./css/Registor_css.css">
</head>
<body>
    <div id="header" class="clearfix">
        <a href="${pageContext.request.contextPath}/index.jsp" class="index">
            <img src="imageSources/blogLogo.jpg" alt="">
            <span>主站</span>
        </a>
        <a href="${pageContext.request.contextPath}/LogIn.jsp" class="login">
            <span>登陆</span>
        </a>
    </div>
    <div id="container">
        <div class="body clearfix">
            <div class="form">
                <form action="${pageContext.request.contextPath}/UserServlet?method=register" method="post" id="form">
                    <div class="opt">
                        <input id="username" type="text" name="username" class="username input" placeholder="请输入要注册的用户名">
                        <div class="username_tip sel">
                            <div class="pic"></div>
                            <span>请输入长度为6-10的用户名</span>
                        </div>
                    </div>
                    <div class="opt">
                        <input id="password" type="password" name="password" class="password input" placeholder="请输入密码">
                        <div class="password_tip sel">
                            <div class="pic"></div>
                            <span>请输入长度为6-10的密码</span>
                        </div>
                    </div>
                    <div class="opt">
                        <input type="password" id="password_repeat" name="password_repeat" class="password_repeat input" placeholder="确认密码">
                        <div class="password_repeat_tip sel">
                            <div class="pic"></div>
                            <span>请确认一遍您的密码</span>
                        </div>
                    </div>
                    <div class="opt">
                        <input type="text" class="nickname input" id="nickname" name="nickname" placeholder="请输入昵称">
                        <div class="nickname sel">
                            <div class="pic"></div>
                            <span>请输入一个长度为4-10的英文昵称</span>
                        </div>
                    </div>
                    <input type="submit" class="submit" value="注册">
                </form>
            </div>
        </div>
    </div>
</body>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/Registor_js.js"></script>
</html>
