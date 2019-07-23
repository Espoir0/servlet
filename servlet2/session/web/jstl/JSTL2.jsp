<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("number",3);
%>
<c:choose>
    <c:when test="${number=1}">星期一</c:when>
    <c:when test="${number=3}">星期三</c:when>
    <c:otherwise>输入数字有误</c:otherwise>
</c:choose>
</body>
</html>
