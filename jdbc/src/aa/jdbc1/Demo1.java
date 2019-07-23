package aa.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * jdbc快速入门
 *
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        //1.导入驱动包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/aa_db","root","root");
        // 4.定义sql语句
        String sql="update meinv4 set xw=40 where id=1";
        //5.获取执行Sql对象 Statement
        Statement sm=con.createStatement();
        //6执行sql语句
        int count =sm.executeUpdate(sql);
        System.out.println(count);
        sm.close();
        con.close();
    }
}
