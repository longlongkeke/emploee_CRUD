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
<!-- add Modal -->
<div class="modal fade" id="addempsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加员工</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="empname" placeholder="姓名" name="empname">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="inlineRadio1" value="M" > 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="inlineRadio2" value="W"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="email" placeholder="Password" name="email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">部门</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="dId">

                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>
<!--  edit Modal -->
<div class="modal fade" id="editempsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="ModalLabel">更新员工</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="pname" placeholder="姓名" name="empname">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="lineRadio1" value="M" > 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="lineRadio2" value="W"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="mail" placeholder="Password" name="email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">部门</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="dId">

                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>SSM-crud</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary" id="add">新增</button>
            <button class="btn btn-danger">删除</button>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptname</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>

                </tbody>



            </table>
        </div>
    </div>
    <%--显示分页信息--%>
    <div class="row" >
        <div class="col-md-6" style="float: left" id="pages_info_area">

        </div>
        <div id="pages_nav" style="float: right">

        </div>
    </div>
    <%--<div class="row" id="pages_nav"--%>
        <%--&lt;%&ndash;<nav aria-label="Page navigation">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<ul class="pagination">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<a href="${APP_PATH}/getEmploee?pn=1" aria-label="Previous">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;首页&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<a href="${APP_PATH}/getEmploee?pn=${pageInfo.pageNum-1}" aria-label="Previous">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<span aria-hidden="true">&laquo;</span>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</li>&ndash;%&gt;--%>


                <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<a href="${APP_PATH}/getEmploee?pn=${pageInfo.pageNum+1}" aria-label="Next">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<span aria-hidden="true">&raquo;</span>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<a href="${APP_PATH}/getEmploee?pn=${pageInfo.pages}" aria-label="Previous">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;尾页&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</nav>&ndash;%&gt;--%>
    <%--</div>--%>


</div>
<script>
    var total,currentpage;
$(function () {
   topages(1);
})
function topages(pn) {
    $.ajax({
        url:"${APP_PATH}/getEmploee",
        data:"pn="+pn,
        type:"get",
        success:function (result) {
            console.log(result);
            build_emps_table(result);
            build_pages_info(result);
            build_pages_nav(result);
        }
    })
}
    function build_emps_table(result) {
        $("#emps_table tbody").empty();
        var emps=result.extend.pageInfo.list;
        $.each(emps,function (index,item) {
            console.log(item.id)
            var empId=$("<td></td>").append(item.id);
            var empName=$("<td></td>").append(item.empname);
            var empgender=$("<td></td>").append(item.gender=="M"?"男":"女");
            var empEmail=$("<td></td>").append(item.email);
            var empDeptName=$("<td></td>").append(item.department.deptName);
            var btn_edit=$("<button class='btn btn-primary edit_btn'>编辑</button>");//遇到一个问题：每次点击按钮属性值都是5（最后一个标签的id）原因：类标签选择器。每次都选择到前面几次循环添加的.edit_btn 和 del_btn
                // <td class='oper_td'>
            btn_edit.attr("edit_id",item.id);
            var btn_del=$("<button class='btn-danger del_btn'>删除</button>");
            btn_del.attr("del_id",item.id);
            var btn_td=$("<td></td>").append(btn_edit).append(" ").append(btn_del);
            $(".del_btn").attr("del_id",item.id);
            $("<tr></tr>").append(empId)
                .append(empName)
                .append(empgender)
                .append(empEmail)
                .append(empDeptName)
                .append(btn_td)
                .appendTo("#emps_table tbody")
        });

        console.log(emps);
        
    }
    function build_pages_info(result) {
        $("#pages_info_area").empty();
        $("#pages_info_area").append("当前是第"+result.extend.pageInfo.pageNum+"页，总共是"+result.extend.pageInfo.pages+"页，总记录数是"+result.extend.pageInfo.total+"条")
    }
    //解析分页条
    function build_pages_nav(result) {
     total=result.extend.pageInfo.total;
     currentpage=result.extend.pageInfo.pageNum;
        $("#pages_nav").empty();
        var ul=$("<ul class='pagination'></ul>");
        var nav=$("<nav class='aria-label=\"Page navigation\"'></nav>")
        var startpages=$("<li></li>").append($("<a ></a>").append("首页"));
        var prepages=$("<li></li>").append($("<a ></a>").append("&laquo;"));
        var nextpages=$("<li></li>").append($("<a ></a>").append("&raquo;"));
        var lastpages=$("<li></li>").append($("<a ></a>").append("尾页"));
        if(result.extend.pageInfo.hasNextPage==false){
            nextpages.addClass("disabled");
            lastpages.addClass("disabled");
        }
        if(result.extend.pageInfo.hasPreviousPage==false){
            startpages.addClass("disabled");
            prepages.addClass("disabled");
        }
        ul.append(startpages).append(prepages);
        $.each(result.extend.pageInfo.navigatepageNums,function (index,item) {
            var numli=$("<li></li>").append($("<a></a>").append(item));
            if(result.extend.pageInfo.pageNum==item){
                numli.addClass("active");
            }
            numli.click(function () {
                topages(item)
            })
            ul.append(numli);

        })
        ul.append(nextpages).append(lastpages);
        nav.append(ul);
        nav.appendTo("#pages_nav");
        startpages.click(function () {
            topages(1);
        })
        prepages.click(function () {
            topages(result.extend.pageInfo.pageNum-1);
        })
        nextpages.click(function () {
            topages(result.extend.pageInfo.pageNum+1);
        })
        lastpages.click(function () {
            topages(result.extend.pageInfo.pages);
        })
        //点击新增按钮 弹出模态框
        $("#add").click(function () {
            //先发送ajax查出所有部门信息
            getAllDept("#addempsModal select");
            $('#addempsModal').modal({
                backdrop:"static"
            })
        })



    }
    function getAllDept(para) {
        console.log("111")
        $(para).empty();
        $.ajax({
            url:"${APP_PATH}/getAllDept",
            type:"get",
            success:function (result) {
                console.log(result);
                $.each(result.extend.depts,function (index,item) {

                    var option=$("<option></option>").append(this.deptName).attr("value",this.deptId);
                    option.appendTo(para);
                });


            },

        })
    }
    $("#emp_save_btn").click(function () {
        console.log("按钮按了")
        // alert($("#addempsModal form").serialize())
        console.log(total);
        $.ajax({

            url:"${APP_PATH}/saveEmp",
            type:"post",
            data:$("#addempsModal form").serialize(),
            success:function (result) {
                console.log("ajax")
                console.log(result);
                if(result.code==200){//添加成功
                    $("#addempsModal").modal("hide");
                    topages(total);
                    //测试
                    //在测试
                }

            },

        })
    })
    $(document).on("click",".edit_btn",function () {

        //获取部门到修改模态框
        getAllDept("#editempsModal select")
      //  alert($(this).attr("edit_id"))
        getEmpInfo($(this).attr("edit_id"));
        $("#emp_update_btn").attr("edit_id",$(this).attr("edit_id"))
        $('#editempsModal').modal({
            backdrop:"static"
        })
    })
    function getEmpInfo(id) {
    console.log("ajax:"+id)
        $.ajax({
            url:"${APP_PATH}/emp/"+id,
            type:"get",
            success:function (res) {
                console.log(res);
                $('#pname').val(res.extend.emp.empname);
                $('#mail').val(res.extend.emp.email);
                $("#editempsModal input[name=gender]").val([res.extend.emp.gender])
                $("#editempsModal select").val([res.extend.emp.dId])

            }
        })
    }

    //更新
    $("#emp_update_btn").click(function () {
        $.ajax({
            url:"${APP_PATH}/editEmp/"+$(this).attr("edit_id"),
            type:"put",
            data:$("#editempsModal form").serialize(),
            success:function (res) {
                console.log(res);
                $("#editempsModal").modal("hide")
                topages(currentpage);


            }
        })
    })

</script>

</body>
</html>
