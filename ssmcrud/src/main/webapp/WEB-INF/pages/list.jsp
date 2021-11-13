<%--
  Created by IntelliJ IDEA.
  User: kk
  Date: 2021/9/18
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    
    pageContext.setAttribute("APP_PATH", request.getContextPath());

%>
<html>
<head>
    <title>Title</title>
    <%--<base href="<%=basePath%>">--%>
    <script type="text/javascript" src="${APP_PATH }/static/bootstrap-3.4.1-dist/js/jquery-2.1.0.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" >
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap-3.4.1-dist/js/bootstrap.js"></script>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>SSM-crud</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary">新增</button>
            <button class="btn btn-danger">删除</button>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptname</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="emp">
                    <tr>
                        <th>${emp.id}</th>
                        <th>${emp.empname}</th>
                        <th>${emp.gender=="M"?"男":"女"}</th>
                        <th>${emp.email}</th>
                        <th>${emp.department.deptName}</th>
                        <th>
                            <button class="btn btn-primary">编辑</button>
                            <button class="btn btn-danger">删除</button>
                        </th>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
    <%--显示分页信息--%>
    <div class="row">
        <div class="col-md-6">
            当前是第${ pageInfo.pageNum}页，总共是${pageInfo.pages}页，总记录数是${pageInfo.total}条
        </div>
    </div>
    <div class="row">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="${APP_PATH}/getEmploee?pn=1" aria-label="Previous">
                       首页
                    </a>
                </li>
                <li>
                    <a href="${APP_PATH}/getEmploee?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach items="${pageInfo.navigatepageNums}" var="pageNums">
                    <c:if test="${pageNums==pageInfo.pageNum}"> <li class="active"><a href="#">${pageNums}</a></li></c:if>
                    <c:if test="${pageNums!=pageInfo.pageNum}"> <li><a href="${APP_PATH}/getEmploee?pn=${pageNums}">${pageNums}</a></li></c:if>


                </c:forEach>

                <li>
                    <a href="${APP_PATH}/getEmploee?pn=${pageInfo.pageNum+1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <li>
                    <a href="${APP_PATH}/getEmploee?pn=${pageInfo.pages}" aria-label="Previous">
                        尾页
                    </a>
                </li>
            </ul>
        </nav>
    </div>


</div>


</body>
</html>
