<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
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
                 <img src="/servlet/checkCodeServlet" alt="checkCode">
            </td>
        </tr>
        <tr>
             <td colspan="2">
                <input type="submit" name="submit" value="登录">
            </td>
        </tr>
    </table>
</form>
</body>
</html>