<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/12/25
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn</title>
    <link rel="stylesheet" href="./css/LogIn_css.css">
    <link rel="stylesheet" href="./css/init.css">
</head>
<body>
    <div id="header">
        <a href="" class="index">
            <img src="imageSources/blogLogo.jpg" alt="">
            <span>主站</span>
        </a>
    </div>
    <div id="container" style="">
        <div class="body clearfix">
            <div class="left_1"></div>
            <div class="left_2"></div>
            <div class="right sel">
                <div class="content">
                    <div class="right_sel title_part"><span class="title">登陆</span></div>
                    <div class="right_sel form_part">
                        <form action="login" method="post" id="logInForm" onsubmit="return isValid()">
                            <input type="text" name="username" id="username" class="part input" placeholder="请输入用户名">
                            <input type="password" name="password" id="password" class="part input" placeholder="请输入密码">
                            <div class="registor">
                                <a href="#" class="part">点我注册</a>
                            </div>
                            <input type="submit" id="submit" class="part submit" value="登陆">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/LogIn_js.js"></script>
</html>
