package aa.jdbc1;

import aa.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 用户登录练习，创建user表，用户登录时查询该用户是否存在
 * 使用prepareStatement

 */
public class Demo7 {
    public static void main(String[] args) {
        System.out.println("请输入用户名：");
        Scanner sc=new Scanner(System.in);
        String username=sc.nextLine();
        System.out.println("请输入密码：");
        String password=sc.nextLine();
        boolean result =login(username,password);
        if (result){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

    }
    public static boolean login(String username,String password){
        if(null==username || password==null){
            return false;
        }

        Connection conc=null;
        PreparedStatement pstmt=null;
        ResultSet resultSet=null;

        try {
            //创建数据库连接对象
            conc = JDBCUtils.getConnection();

            //sql语句
            String sql="select * from user where username= ? and  password=?";

            //获取执行sql对象
            pstmt = conc.prepareStatement(sql);

            //给 ？ 赋值
            pstmt.setString(1,username);
            pstmt.setString(2,password);

            resultSet = pstmt.executeQuery();
           /* if(resultSet.next()){      垃圾代码
                return true;
            }else {
                return false;
            }*/

           return resultSet.next();   //next()本来就是一个boolean值

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet,pstmt,conc);
        }
        return false;
    }
}
