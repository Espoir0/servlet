<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
    <%
        //获取所有Cookie
        Cookie[] cookies = request.getCookies();

        boolean flag=false;//标记cookie中没有lasttime
        if(cookies!=null && cookies.length>0){ //如果Cookie存在
            for (Cookie cookie : cookies) {
                String name = cookie.getName();   //获取cookie名称
                if("lastTime".equals(name)){      //判断名称是否是lastTime
                    //响应数据，获取Cooie的value,时间
                    String time = cookie.getValue();
                    System.out.println("解码前"+time);
                    time = URLDecoder.decode(time, "utf-8");
                    System.out.println("解码后"+time);
                    %>
    <h1>欢迎回来，您上次的访问时间为：<%=time%></h1>
    <%


                    flag=true;  //找到cookie 就flag设置为 true
                    //有该Cookie，说明不是第一次访问,获取当前时间
                    String date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
                    System.out.println("编码前"+date);
                    //URL编码
                    date= URLEncoder.encode(date,"utf-8");
                    System.out.println("编码后"+date);
                    cookie.setValue(date); //将lastTime更新为当前时间
                    cookie.setMaxAge(60*60*24*30);//设置cookie的存活时间为1个月
                    response.addCookie(cookie);

                    break;
                }
            }
        }
        if (cookies==null || cookies.length==0 || flag==false){
            //如果lastTime不存在，则创建Cookie并设置当前时间
            String date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
            date= URLEncoder.encode(date,"utf-8");
            Cookie cookie = new Cookie("lastTime",date);
            response.addCookie(cookie);
            cookie.setMaxAge(60*60*24*30);//设置cookie的存活时间为1个月
    %>
            <h1>欢迎首次访问</h1>
    <%
        }

    %>
        <input type="text">
</body>
</html>
