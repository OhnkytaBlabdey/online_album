<%@ page import="po.Album" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="po.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" --%>
<html>
<head>
	<title>LogIn</title>
	<link rel="stylesheet" href="./css/init.css">
	<link rel="stylesheet" href="./css/Index_css.css">
</head>
<body>
<%--  
	<div id="header" class="clearfix">
		<a href="${pageContext.request.contextPath}/ImagesServlet?method=findall&location=0" class="index">
			<img src="imageSources/blogLogo.jpg" alt="">
			<span>的个人主页</span>
		</a>
		
			<a href="${pageContext.request.contextPath}/UserServlet?method=logout" class="logout after_login">
				<span>注销</span>
			</a>
			<a href="${pageContext.request.contextPath}/UserServlet?method=logout" class="logout after_login">
				<span>新建相册</span>
			</a>

	</div>
	--%>
	<div class="comment_form clearfix">
									<%--
									提交评论--%>
									<form action="./comment">
										<textarea name="input_comment" class="input_comment" cols="90" rows="5" class="line" placeholder="留下你的足迹111"></textarea>
										<input type="submit" class="line submit" value="评论">
									</form>
								</div>
</body>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/Index_js.js"></script>
</html>
