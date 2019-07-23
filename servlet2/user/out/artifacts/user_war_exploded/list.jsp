<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <title>用户信息管理系统</title>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
        .div1{
            float:left;
        }
        .div2{
             float:right;
             margin:5px;
        }

    </style>
    <script>
        function delUser(id) {
            //安全提示
            if(confirm("你确定要删除吗")){
                location.href="${pageContext.request.contextPath}/delUserServlet?id="+id;
            }
        }

        window.onload=function () {
            //给删除选中的按钮添加单击事件
            document.getElementById("delSelected").onclick=function () {
                if (confirm("你确定要提交表单吗")){
                    var flag=false;//判断是否有选中的项
                    var cbs=document.getElementsByName("uid");
                    //遍历
                    for(var i=0;i<cbs.length;i++){
                        if(cbs[i].checked){
                            //有一个被选中了
                            flag=true;
                            break;
                        }
                    }
                    if(flag){
                        document.getElementById("uform").submit();//表单提交
                    }
                }
            }

            //获取第一个cb
            document.getElementById("firstCb").onclick=function () {
                //获取下边列表中所有的cb
                var cbs=document.getElementsByName("uid");
                //遍历
                for(var i=0;i<cbs.length;i++){
                    //设置这些ch[i]的checked状态=firstCb.checked
                    cbs[i].checked=this.checked;
                }
            }
        }

    </script>

</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div class="div1"><%--bootstrap 表单--%>
        <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName2" placeholder="aa">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">地址</label>
                <input type="text" name="address" value="${condition.address[0]}" class="form-control" id="exampleInputName3" placeholder="aa">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">Email</label>
                <%--这里的邮箱 type写做text，方便用户查询，不用校验--%>
                <input type="text"  name="email" value="${condition.email[0]}" class="form-control" id="exampleInputEmail2" placeholder="aa@alone.com">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div class="div2">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
    </div>
    <form id="uform" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>地址</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${pb.list}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="uid" value="${user.id}"></td>

                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:delUser(${user.id});">删除</a></td>
                </tr>

            </c:forEach>
        </table>
    </form>
    <div><%--boot strap分页--%>
        <nav aria-label="Page navigation">
            <ul class="pagination">

                <%--设置分页栏的第一项为禁用状态，提示用户不可以点击--%>
                    <li>
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage-1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>

                    <%--设置分页按钮的激活状态--%>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage==i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                    </c:if>
                    <c:if test="${pb.currentPage!=i}">
                        <li><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                    </c:if>

                </c:forEach>
                    <%--设置分页栏的最后一项为禁用状态，提示用户不可以点击--%>
                <li>
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage+1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size:25px;margin-left: 5px">共${pb.totalCount}条记录，共${pb.totalPage}页</span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
