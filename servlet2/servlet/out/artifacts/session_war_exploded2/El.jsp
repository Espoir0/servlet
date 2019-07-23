<%@ page import="alone.aa.sessiondemo.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = new User();
    user.setName("李白");
    user.setAge(21);
    //存储到域中
    request.setAttribute("u",user);
%>
${requestScope.u}
<%--
    通过对象的属性来获取，
    seter,geter,方法，去掉get,set，将首字母变小写
    setName() -> Name -> name  // name就是属性，属性不一定是成员变量
--%>
<h1>获取值</h1>
${requestScope.u.name}
${u.age}
${u.birStr}


</body>
</html>
