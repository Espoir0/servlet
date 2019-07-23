package aa.jdbc1;

import aa.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo8 {
    public static void main(String[] args) {
        Connection conc=null;
        PreparedStatement pstmt1=null;
        PreparedStatement pstmt2=null;


        try {

            //获取数据库连接对象
            conc = JDBCUtils.getConnection();

            conc.setAutoCommit(false);

            //问号是个占位符
            String sql1="update meinv4 set xw=xw-? where id = ?";
            String sql2="update meinv4 set xw=xw+? where id = ?";

            pstmt1 = conc.prepareStatement(sql1);  //获取执行对象
            pstmt2 = conc.prepareStatement(sql2);  //获取执行对象

            //设置参数
            pstmt1.setInt(1,500);
            pstmt1.setInt(2,1);  //给？赋值
            pstmt2.setInt(1,500);
            pstmt2.setInt(2,2);

            //执行
            pstmt1.executeUpdate();

            pstmt2.executeUpdate();
            conc.commit();   //所有sql执行完提交
        } catch (SQLException e) {
            if (null!=conc){
                try {
                    conc.rollback();   //在异常里面回滚
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt1,conc);
            JDBCUtils.close(pstmt2,null);
        }

    }
}
