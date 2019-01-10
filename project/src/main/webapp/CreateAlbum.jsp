<%@ page import="po.User" %><%--
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
    <a href="${pageContext.request.contextPath}/ImagesServlet?method=findallbyusername&username=<%=((User)(session.getAttribute("userInfo"))).getUserName()%>" class="login">
        <span>个人主页</span>
    </a>
</div>
<div id="container">
    <div class="body clearfix">
        <div class="form">
            <form action="${pageContext.request.contextPath}/AlbumServlet?method=create" method="post" id="form">
                <div class="opt">
                    <input id="username" type="text" name="albumName" class="username input" placeholder="请输入相册名">
                    <div class="username_tip sel">
                        <div class="pic"></div>
                        <span>请输入6-10长度的相册名</span>
                    </div>
                </div>
                <input type="submit" class="submit" value="创建相册">
            </form>
        </div>
    </div>
</div>
</body>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/Registor_js.js"></script>
</html>
