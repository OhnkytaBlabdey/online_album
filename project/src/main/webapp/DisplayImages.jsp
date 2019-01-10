<%@ page import="po.Album" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="po.Comment" %>
<%@ page import="po.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Display</title>
    <link rel="stylesheet" href="./css/init.css">
    <link rel="stylesheet" href="./css/Index_css.css">
</head>
<body>
<div id="header" class="clearfix">
    <a href="${pageContext.request.contextPath}/ImagesServlet?method=findall&pageNumber=0" class="index">
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
            <span>新建相册</span>
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
            <%
                Album album = (Album) session.getAttribute("album");
            %>
            <div class="title">
                <h2>相册：<%=album.getName()%></h2>
            </div>
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
                                <c:if test="${sessionScope.userInfo != null}">
                                    <%
                                        User user = (User) session.getAttribute("userInfo");
                                    %>
                                    <c:if test="<%=user.getUserName().equals(album.getUserName())%>">
                                        <%--删除--%>
                                        <div id="delete">
                                            <a href="${pageContext.request.contextPath}/ImagesServlet?method=deleteAlbumById&albumId=<%=album.getId()%>">
                                                <img src="imageSources/delete.png" alt="">
                                            </a>
                                        </div>
                                        <%--删除--%>
                                        <%--添加--%>
                                        <div id="add">
                                            <a href="${pageContext.request.contextPath}/ImagesServlet?method=addImages">
                                                <img src="imageSources/add.png" alt="">
                                            </a>
                                        </div>
                                        <%--添加--%>
                                    </c:if>
                                </c:if>
                            </div>
                            <c:if test="<%=!album.getPhotos().isEmpty()%>">
                                <c:forEach var="location" begin="0" end="<%=album.getPhotos().size() - 1%>" step="1">
                                    <div class="img_content clearfix">
                                        <div class="img_content_left">
                                            <img src="${pageContext.request.contextPath}/ImagesServlet?method=showImageByLocation&location=${location}" alt="">
                                        </div>
                                    </div>
                                </c:forEach>
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
                            </c:if>
                        </div>
                    </div>
            <%--单个模块截至--%>
        </div>
    </div>
</div>
</body>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/Index_js.js"></script>
</html>
