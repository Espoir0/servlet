<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script>
        //绑定事件
        window.onload=function () {
            //点击图片切换验证码
            document.getElementById("img").onclick=function () {
                //防止验证码重复加上时间
                this.src="/servlet/checkCodeServlet?time="+new Date().getTime();
            }
        }
    </script>
    <style>
        div{
            coler:red;
        }
    </style>
</head>
<body>
<form action="/servlet/loginServlet">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" ></td>
        </tr>
        <tr>
            <td>密码</td>
             <td>
                <input type="password" name="password" >
            </td>
        </tr>
        <tr>
            <td>验证码</td>
             <td>
                <input type="text" name="checkCode" >
            </td>
        </tr>
        <tr>
             <td colspan="2">
                 <img src="/servlet/checkCodeServlet" id="img" alt="checkCode">
            </td>
        </tr>
        <tr>
             <td colspan="2">
                <input type="submit" name="submit" value="登录">
            </td>
        </tr>
    </table>
</form>
<%--${requestScope.cc_error}-              使用EL表达式简化--%>
<div><%=request.getAttribute("cc_error") ==null ? "" :request.getAttribute("cc_error") %></div>
<div><%=request.getAttribute("login_error") ==null ? "" : request.getAttribute("login_error") %></div>
<div></div>
</body>
</html>
