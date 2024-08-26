<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    function clickActive() {
        var children = document.getElementById("nav").children;
        for (var i = 0; i < children.length; i++) {
             var aEle = children[i].children[0];
            if (aEle.getAttribute("href") == location.pathname) {
                children[i].setAttribute("class", "active");
            } else {
                children[i].removeAttribute("class");
            }
        }
    }
    $(function () {
       clickActive();
    })
</script>
<div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">
        <li id="course"><a href="${pageContext.request.contextPath}/showCourse.jsp" onclick="clickActive()">课程管理</a></li>
            <%--主页显示所有的数据--%>
<%--        <li class="active"><a href="${pageContext.request.contextPath}/AllStudentsServlet" onclick="clickActive()">学生管理</a></li>--%>

            <%--主页数据分页展示,默认展示第一页的数据 /StudentPageServlet?currentPage=1--%>
        <li class="active"><a href="${pageContext.request.contextPath}/StudentPageServlet" onclick="clickActive()">学生管理</a></li>
        <li><a href="${pageContext.request.contextPath}/userPasswordRest.jsp" onclick="clickActive()">账号密码重置</a></li>
        <li><a href="${pageContext.request.contextPath}/passwordRest.jsp" onclick="clickActive()">修改密码</a></li>
        <li><a href="${pageContext.request.contextPath}/logout.jsp" onclick="clickActive()">退出系统</a></li>
    </ul>
</div>