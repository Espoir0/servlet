package aa.jdbc1;

import aa.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo5 {
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

            //获取数据库连接对象
            conc = JDBCUtils.getConnection();

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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conc);
        }

        return list;
    }
}
