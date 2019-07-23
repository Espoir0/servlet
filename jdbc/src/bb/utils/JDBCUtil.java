package bb.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid连接池的工具类
 */
public class JDBCUtil {
    // 1.定义成员变量 DataSource
    private static DataSource ds=null;

    static {
        //1.加载配置文件
        Properties pro = new Properties();
        //获取流
        InputStream is= JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(is);   //读取文件到pro对象

            ds=DruidDataSourceFactory.createDataSource(pro);  //获取连接池
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //释放资源
    public static void close(Statement stmt,Connection conc){
        if (null!=stmt){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null!=conc){
            try {
                conc.close();  //归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    //释放资源
    public static void close(ResultSet rs,Statement stmt, Connection conc){
        if (null!=rs){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(stmt,conc);   //简化
        /*if (null!=stmt){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null!=conc){
            try {
                conc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/

    }

    //获取连接池
    public static DataSource getDataSource(){
        return ds;
    }


}