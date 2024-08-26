<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>课程信息显示</title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>
    <body>
        <!-- 顶栏 -->
        <jsp:include page="top.jsp"></jsp:include>
        <!-- 中间主体 -->
        <div class="container-fluid id=" content="">
        <div class="row">
            <jsp:include page="menu.jsp"></jsp:include>
            <div class="col-md-10">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row">
                            <h1 class="col-md-5">课程管理</h1>
                            <form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;"
                                  action="#" id="form1" method="post">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="请输入课程名称" name="findByName">
                                    <span class="input-group-addon btn" id="sub">搜索</span>
                                </div>
                            </form>
                            <button class="btn btn-default col-md-2" style="margin-top: 20px"
                                    onClick="location.href='/admin/addCourse'">
                                添加课程信息
                                <sapn class="glyphicon glyphicon-plus"/>
                            </button>

                        </div>
                    </div>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>课程号</th>
                            <th>课程名称</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>数据库</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info">修改</button>
                                <button class="btn btn-default btn-xs btn-danger btn-primary">删除</button>
                                <!--弹出框-->
                            </td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>java</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info">修改</button>
                                <button class="btn btn-default btn-xs btn-danger btn-primary">删除</button>
                                <!--弹出框-->
                            </td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>python</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info">修改</button>
                                <button class="btn btn-default btn-xs btn-danger btn-primary">删除</button>
                                <!--弹出框-->
                            </td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>数据结构</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info">修改</button>
                                <button class="btn btn-default btn-xs btn-danger btn-primary">删除</button>
                                <!--弹出框-->
                            </td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>人工智能</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info">修改</button>
                                <button class="btn btn-default btn-xs btn-danger btn-primary">删除</button>
                                <!--弹出框-->
                            </td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>离散数学</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info">修改</button>
                                <button class="btn btn-default btn-xs btn-danger btn-primary">删除</button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
					<div class="panel-footer text-right">
						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-end">
								<li class="page-item disabled">
									<a class="page-link" href="#" tabindex="-1">上一页</a>
								</li>
								<li class="page-item active"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item">
									<a class="page-link" href="#">下一页</a>
								</li>
							</ul>
						</nav>
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
</html>