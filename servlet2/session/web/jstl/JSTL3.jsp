<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
       for 循环的时候
        begin： 开始值
        end  : 结束值
        var :  临时变量
        step: 步长
        varStatus : 循环状态对象
            Index:容器中元素的索引，从0开始
            count:,循环的次数，从1开始

        相当与foreach的时候：
            items:容器对象
            varStatus:循环状态的对象
                index : 容器中元素的索引
                count : 循环次数从 1 开始


--%>
<%
    //判断request域中的list 是否为空，如果不为null则遍历集合
    ArrayList<String> list = new ArrayList<>();
    list.add("aa");
    list.add("bb");
    list.add("cc");
    request.setAttribute("list",list);
%>
<c:forEach begin="1" end="10" var="i" step="2" varStatus="s" >
    ${i}${s.index}${s.count}
</c:forEach>

<c:forEach items="${list}" var="str" varStatus="s">
    ${s.index} ${s.count} ${str}
</c:forEach>

</body>
</html>
