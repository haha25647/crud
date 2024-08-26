<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                        <h1 style="text-align: center;">修改学生信息</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form"
                          action="${pageContext.request.contextPath}/SaveUpdate" id="editfrom"
                          method="post">
                        <div class="form-group ">
                            <label for="inputEmail3" class="col-sm-2 control-label">学号</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="number" class="form-control" id="inputEmail3"
                                       name="sno" placeholder="请输入学号" value="${student.sno}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputPassword3" name="sname"
                                       placeholder="请输入姓名" value="${student.sname}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <label class="checkbox-inline">
                                    <input type="radio" name="sex" value="男"
                                           <c:if test="${student.sgender=='男'}">checked</c:if>>男
                                </label>
                                <label class="checkbox-inline">
                                    <input type="radio" name="sex" value="女"
                                           <c:if test="${student.sgender=='女'}">checked</c:if>>女
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">出生日期</label>
                            <div class="col-sm-3">
                                <input class="form-control" id="date" data-provide="datepicker"
                                       value="${student.sbirthday}" name="sbirthday">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="grade">可选课程</label>
                            <div class="col-auto my-1">
                                <div class="custom-control custom-checkbox col-sm-10">
                                    <c:if test="${!empty courses}">
                                        <c:forEach items="${courses}" var="course" varStatus="vs">
                                            <input name="selectedCourse" type="checkbox" class="custom-control-input"
                                                   id="course${vs.count}" value="${course.cno}"
                                            <c:forEach items="${student.courses}" var="cou">
                                                    <c:if test="${course.cno==cou.cno}">
                                                    checked
                                            </c:if>
                                            </c:forEach>
                                            >
                                            <label class="custom-control-label"
                                                   for="course${vs.count}">${course.cname}</label>
                                        </c:forEach>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label"
                                   name="grade">所在学院</label>
                            <div class="col-sm-2">
                                <select class="form-control" name="id">
                                    <c:if test="${!empty colleges}">
                                        <c:forEach items="${colleges}" var="college">
                                            <option value="${college.id}"
                                                    <c:if test="${student.college.id==college.id}">selected</c:if>
                                            >${college.name}</option>
                                        </c:forEach>
                                    </c:if>
                                </select>
                            </div>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-default" type="submit">提交</button>
                            <button class="btn btn-default" type="reset" onclick="javascript:history.back(-1)">
                                返回
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container" id="footer">
    <div class="row">
        <div class="col-md-12"></div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $('#date').datepicker({
            format: 'yyyy-mm-dd',
            language: 'zh-CN'
        });
    })
</script>
</html>