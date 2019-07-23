package aa.jdbc1;

import java.sql.*;

public class Demo3 {
    public static void main(String[] args) {

        ResultSet result=null;
        Connection conc =null;
        Statement stmt=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");  //注册驱动
            //获取数据库连接对象

            conc = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa_db","root","root");
            String sql="select * from meinv4";

            //获取执行sql的对象
            stmt = conc.createStatement();

            //获取结// 果集对象，也就是查询到的表
            result = stmt.executeQuery(sql);

            //处理结果 ，刚开始游标在第一行数据的上面，让游标指向第一行result.next();


            while(result.next()){
                int id=result.getInt(1)  ;//获取第一列元素   sql从0开始计数
                String name=result.getString("name")  ;//使用列名称获取元素
                int xw=result.getInt(3);

                System.out.println("id:"+id+"name:"+name+"xw:"+xw);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(null!=result){            //防止空指针异常
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!=stmt) {

                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!=result) {

                try {
                    conc.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
