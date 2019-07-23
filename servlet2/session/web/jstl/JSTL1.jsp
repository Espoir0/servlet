<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //判断request域中的list 是否为空，如果不为null则遍历集合
    ArrayList<String> list = new ArrayList<>();
    list.add("aa");
    request.setAttribute("list",list);
    request.setAttribute("number",3);
%>
<c:if test="${not empty list}">
    遍历集合
</c:if>
<c:if test="${number%2 =!0}">
    number为奇数
</c:if>

</body>
</html>
