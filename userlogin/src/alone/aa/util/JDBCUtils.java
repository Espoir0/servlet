package alone.aa.util;

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
 * JDBC工具类，使用Durid连接池
 */
public class JDBCUtils {
    static DataSource ds;
    //加载连接池只需要一次，所以在静态代码块中加载数据库连接池对象，连接池就是多个连接对象
    static {
        //1.使用Properties加载配置文件
        Properties pro = new Properties();
        //2.通过类加载器，获取流
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        //3.pro.load();读取文件到pro对象
        try {
            pro.load(is);
            //获取连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }

    //定义从连接池里面获取连接对象的方法
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //释放资源的两个重载方法
    public void close(Statement stmt,Connection conc){
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conc!=null){
            try {
                conc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(ResultSet rs, Statement stmt, Connection conc){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(stmt,conc);
    }


}
