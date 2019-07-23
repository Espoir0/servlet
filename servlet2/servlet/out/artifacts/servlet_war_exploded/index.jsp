<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/15 0015
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

  </head>
  <body>
      <%
        System.out.println("hello jsp");
        out.write(request.getContextPath());
        response.getWriter().write("哈喽");
      %>
  <h1>ha哈哈哈</h1>
  </body>
</html>
