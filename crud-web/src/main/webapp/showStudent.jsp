<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息显示</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
    <script>
        function submitForm() {
            document.getElementById("submitForm").submit();
        }

        function setHideVal(sno) {
            document.getElementById("hideSno").value = sno;
        }

        function deleteBySno() {
            //1.获取隐藏域中的学号,然后请求servlet删除
            var sno = document.getElementById("hideSno").value;
            //2.重定向到删除servlet
            window.location.href = "${pageContext.request.contextPath}/DeleteStudentServlet?sno=" + sno;
        }
    </script>
</head>
<body>
<!-- 顶栏 -->
<jsp:include page="top.jsp"></jsp:include>
<!-- 中间主体 -->
<div class="container-fluid" id="content">
    <div class="row">
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 class="col-md-5">学生信息管理</h1>
                        <form class="bs-example bs-example-form col-md-5" role="form"
                              style="margin: 20px 0 10px 0;" id="submitForm" method="post"
                              action="${pageContext.request.contextPath}/SeachNameServlet">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="请输入姓名" name="seachName">
                                <span class="input-group-addon btn" id="sub" onclick="submitForm()">搜索</span>
                            </div>
                        </form>
                        <button class="btn btn-default col-md-2" style="margin-top: 20px"
                                onclick="location.href='${pageContext.request.contextPath}/addStudent'">
                            添加学生
                            <sapn class="glyphicon glyphicon-plus"></sapn>
                        </button>

                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>出生日期</th>
                        <th>已选课程</th>
                        <th>所在学院</th>
                    </tr>
                    </thead>

                    <tbody>

                    <%--<c:if test="${!empty students}"> 首页展示所有数据--%>
                    <%--    <c:forEach items="${students}" var="student">--%>
                    <%--        <td>${student.sno}</td>--%>
                    <%--        <td>${student.sname}</td>--%>
                    <%--        <td>${student.sgender}</td>--%>
                    <%--        <td>${student.sbirthday}</td>--%>
                    <%--        <td>--%>
                    <%--            <c:if test="${!empty student.courses}">--%>
                    <%--                <c:forEach items="${student.courses}" var="course">--%>
                    <%--                    ${course.cname}&nbsp;&nbsp;--%>
                    <%--                </c:forEach>--%>
                    <%--            </c:if>--%>
                    <%--        </td>--%>
                    <%--        <td>${student.college.name}</td>--%>
                    <%--        <td>--%>
                    <%--            <button class="btn btn-default btn-xs btn-info"--%>
                    <%--                    onclick="location.href='${pageContext.request.contextPath}/UpdateStudentServlet?sno=${student.sno}'">修改--%>
                    <%--            </button>--%>
                    <%--            <button class="btn btn-default btn-xs btn-danger btn-primary"--%>
                    <%--                    data-toggle="modal" data-target="#deleteModal"--%>
                    <%--                    onclick="setHideVal('${student.sno}')">删除--%>
                    <%--            </button>--%>
                    <%--        </td>--%>
                    <%--        </tr>--%>
                    <%--    </c:forEach>--%>
                    <%--</c:if>--%>
                    <c:if test="${!empty pageBean.list}">
                        <c:forEach items="${pageBean.list}" var="student">
                            <td>${student.sno}</td>
                            <td>${student.sname}</td>
                            <td>${student.sgender}</td>
                            <td>${student.sbirthday}</td>
                            <td>
                                <c:if test="${!empty student.courses}">
                                    <c:forEach items="${student.courses}" var="course">
                                        ${course.cname}&nbsp;&nbsp;
                                    </c:forEach>
                                </c:if>
                            </td>
                            <td>${student.college.name}</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info"
                                        onclick="location.href='${pageContext.request.contextPath}/UpdateStudentServlet?sno=${student.sno}'">
                                    修改
                                </button>
                                <button class="btn btn-default btn-xs btn-danger btn-primary"
                                        data-toggle="modal" data-target="#deleteModal"
                                        onclick="setHideVal('${student.sno}')">删除
                                </button>
                            </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
                <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">提示信息</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                您确定要删除该学生吗?
                            </div>
                            <div class="modal-footer">
                                <input type="hidden" id="hideSno"/> <!--存储当前行学生学号-->
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary" onclick="deleteBySno()">确定
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-footer text-right">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-end">
                            <c:if test="${pageBean.currentPage==1}">
                                <li class="page-item disabled">
                                    <a class="page-link" href="#" tabindex="-1">上一页</a>
                                </li>
                            </c:if>
                            <c:if test="${pageBean.currentPage!=1}">
                                <li class="page-item">
                                    <a class="page-link"
                                       href="${pageContext.request.contextPath}/StudentPageServlet?currentPage=${pageBean.currentPage-1}"
                                       tabindex="-1">上一页</a>
                                </li>
                            </c:if>

                            <%--    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
                            <%--begin:遍历的起始值
                               end:遍历的结束值
                            --%>
                            <c:if test="${!empty pageBean.totalPage}">
                                <c:forEach begin="1" end="${pageBean.totalPage}" var="pageNo">
                                    <c:if test="${pageBean.currentPage==pageNo}">
                                        <li class="page-item active">
                                            <a class="page-link"
                                               href="${pageContext.request.contextPath}/StudentPageServlet?currentPage=${pageNo}">${pageNo}</a>
                                        </li>
                                    </c:if>

                                    <c:if test="${pageBean.currentPage!=pageNo}">
                                        <li class="page-item">
                                            <a class="page-link"
                                               href="${pageContext.request.contextPath}/StudentPageServlet?currentPage=${pageNo}">${pageNo}</a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </c:if>

                            <c:if test="${pageBean.currentPage==pageBean.totalPage}">
                                <li class="page-item disabled">
                                    <a class="page-link" href="#">下一页</a>
                                </li>
                            </c:if>

                            <c:if test="${pageBean.currentPage!=pageBean.totalPage}">
                                <li class="page-item">
                                    <a class="page-link"
                                       href="${pageContext.request.contextPath}/StudentPageServlet?currentPage=${pageBean.currentPage+1}">下一页</a>
                                </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <div class="container" id="footer">
            <div class="row">
                <div class="col-md-12"></div>
            </div>
        </div>
</body>
</html>