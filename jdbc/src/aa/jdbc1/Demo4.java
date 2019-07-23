package aa.jdbc1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo4 {
    public static void main(String[] args) {
        List<Meinv> list = findALl();
        for (Meinv meinv : list) {
            System.out.println(meinv);
        }

    }

    /**
     * 查询整个表，并封装为Meinv 对象，存入集合
     * @return
     */
    public static List<Meinv> findALl(){
        List<Meinv> list=new ArrayList<>();

        Connection conc=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");   //注册驱动

            conc = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa_db","root","root");
            //获取连接数据库的对象

            //获取执行sql的对象
            stmt = conc.createStatement();
            String sql="select * from meinv4";

            //获取结果集
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name=rs.getString("name");
                int xw=rs.getInt("xw");
                int height=rs.getInt("height");
                int other_id=rs.getInt("other_id");
                Date date=rs.getDate("date");
                Meinv mm=new Meinv(id,name,xw,height,other_id,date);
                list.add(mm);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (null!= rs){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null!= stmt){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null!= conc){
                try {
                    conc.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

        return list;
    }
}
