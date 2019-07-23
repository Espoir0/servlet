
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="true" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  <%
    pageContext.setAttribute("msg","hello");
    request.setAttribute("name","李白");
    session.setAttribute("name","关羽");
  %>

  <%
    pageContext.getAttribute("msg");
  %>
  ${requestScope.name}
  ${sessionScope.name}

  </body>
</html>
