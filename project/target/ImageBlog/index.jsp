<%@ page import="po.Album" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="po.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>LogIn</title>
	<link rel="stylesheet" href="./css/init.css">
	<link rel="stylesheet" href="./css/Index_css.css">
</head>
<body>
	<div id="header" class="clearfix">
		<a href="${pageContext.request.contextPath}/ImagesServlet?method=findall&location=0" class="index">
			<img src="imageSources/blogLogo.jpg" alt="">
			<span>主站</span>
		</a>
		<c:if test="${sessionScope.userInfo == null}">
			<a href="${pageContext.request.contextPath}/Registor.jsp" class="registor before_login">
				<span>注册</span>
			</a>
			<a href="${pageContext.request.contextPath}/LogIn.jsp" class="login before_login">
				<img src="imageSources/before_login.jpg" alt="">
				<span>登陆</span>
			</a>
		</c:if>
		<c:if test="${sessionScope.userInfo != null}">
			<a href="${pageContext.request.contextPath}/UserServlet?method=logout" class="logout after_login">
				<span>注销</span>
			</a>
			<a href="${pageContext.request.contextPath}/PersonalIndex.jsp" class="info after_login">
				<img src="imageSources/after_login.jpg" alt="">
				<span>个人主页</span>
			</a>
		</c:if>

	</div>
	<div id="container">
		<div class="background"></div>
		<div class="body">
			<div class="arrow_box left_arrow_box">
				<div class="left_arrow" id="left_arrow"></div>
			</div>
			<div class="arrow_box right_arrow_box">
				<div class="right_arrow" id="right_arrow"></div>
			</div>
			<div class="recent_display">
				<div class="title">
					<h2>随便看看</h2>
				</div>
				<%--模块--%>
				<%
					ArrayList<Album> albumArrayList = new ArrayList<>();
					if(session.getAttribute("albumArrayList") != null) {
					    albumArrayList = (ArrayList<Album>) session.getAttribute("albumArrayList");
					    int pageNumber = 0;
					}
				%>
				<c:forEach var="location" begin="0" end="<%=albumArrayList.size()-1%>" step="1">
					<%
						Album album = albumArrayList.get(Integer.parseInt(String.valueOf(pageContext.getAttribute("location"))));
						ArrayList<Comment> commentArrayList = album.getComments();
					%>
					<div class="content clearfix">
						<div class="left">
							<div class="img">
								<img src="imageSources/after_login.jpg" alt="">
							</div>
							<div class="name"><span><%=album.getUserName()%></span></div>
						</div>
						<div class="right">
							<div class="img_title">
								<h3><%=album.getName()%></h3>
								<span class="time"><%=album.getUserName()%></span>
							</div>
							<div class="img_content clearfix">
								<div class="img_content_left">
									<img src="${pageContext.request.contextPath}/ImagesServlet?method=findbylocation&location=${location}" alt="">
								</div>
							</div>
							<div class="good_bad">
								<a href="" class="good">
									<img src="imageSources/good_pre.png" alt="">
									<span>10</span>
								</a>
								<a href="" class="you_bad_bad">
									<img src="imageSources/you_bad_bad_pre.png" alt="">
									<span>You bad bad</span>
								</a>
							</div>
							<div class="comment">
								<div class="comment_title">
									<span>评论区</span>
								</div>
								<div class="comment_form clearfix">
									<form action="">
										<textarea name="input_comment" class="input_comment" cols="90" rows="5" class="line" placeholder="留下你的足迹"></textarea>
										<input type="submit" class="line submit" value="评论">
									</form>
								</div>
								<div class="other_comment">
									<div class="comment_title">
										<span>别人在说</span>
									</div>
									<%--评论--%>
									<c:forEach var="location_comments" begin="0" end="<%=commentArrayList.size() - 1%>" step="1">
										<%
											Comment comment = commentArrayList.get(Integer.parseInt(String.valueOf(pageContext.getAttribute("location_comments"))));
										%>
										<div class="comment_sel clearfix">
											<div class="other_pic">
												<img src="imageSources/log_change.gif" alt="">
											</div>
											<div class="other_comment_content">
												<div class="other_name"><%=comment.getUserName()%></div>
												<div class="other_comment_para">
													<p><%=comment.getComment()%></p>
												</div>
											</div>
											<div class="good_bad">
												<a href="" class="good">
													<img src="imageSources/good_pre.png" alt="">
													<span>20</span>
												</a>
												<a href="" class="you_bad_bad">
													<img src="imageSources/you_bad_bad_pre.png" alt="">
													<span>You bad bad</span>
												</a>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				<%--单个模块截至--%>
			</div>
		</div>
	</div>
</body>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/Index_js.js"></script>
</html>
