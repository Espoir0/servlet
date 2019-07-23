package aa.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {
    public static void main(String[] args) {
        Connection conc = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");    //注册驱动
            //String sql ="insert into meinv4 (name,xw) values('cc',39)";    //sql语句
            //String sql="update meinv4 set xw=55 where id=5";
            //String sql="delete from meinv4 where id=6";
            String sql="create table stu (id int,name varchar(20))";   //也可以创建表但不常用

            //获取connection 对象

            conc = DriverManager.getConnection("jdbc:mysql:///aa_db","root","root");
            //获取执行sql对象

            stmt = conc.createStatement();
            //执行sql
            int count=stmt.executeUpdate(sql);

            //输出执行结果
            System.out.println(count);
            if(count>0){
                System.out.println("执行成功");
            }else {
                System.out.println("执行失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (null != stmt){
                try {

                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != stmt){
                try {

                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }if (null != conc){
                try {

                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
