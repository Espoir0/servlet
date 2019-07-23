package bb;

import bb.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 练习 利用JDBCUtil向表中添加数据
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conc=null;
        PreparedStatement pstmt= null;
        try {
            String sql="insert into meinv4 (name,xw) values(?,?)";
            conc= JDBCUtil.getConnection();  //获取连接
            pstmt = conc.prepareStatement(sql); //获取数据库执行对象

            //设置sql数据
            pstmt.setString(1,"小小");
            pstmt.setInt(2,99);

            pstmt.executeUpdate();  //执行
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(pstmt,conc);
        }
    }
}
