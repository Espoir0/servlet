<%@ page import="java.util.ArrayList" %>
<%@ page import="alone.aa.sessiondemo.user.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    //判断request域中的list 是否为空，如果不为null则遍历集合
    ArrayList<User> list = new ArrayList<>();
    list.add(new User("李白",21,new Date()));
    list.add(new User("关羽",21,new Date()));
    list.add(new User("雅典娜",21,new Date()));
    request.setAttribute("list",list);
%>
<table border="1px red  " width="500" align="center">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>
    <%--数据行,隔一行换一种颜色--%>
    <c:forEach items="${list}" var="user" varStatus="s">
        <c:if test="${s.count%2==0}">
            <tr bgcolor="aqua">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>

        </c:if>
        <c:if test="${s.count%2!=0}">
            <tr bgcolor="#7fff00">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>

        </c:if>

    </c:forEach>
</table>


</body>
</html>
