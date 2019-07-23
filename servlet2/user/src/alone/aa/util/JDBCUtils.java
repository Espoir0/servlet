package alone.aa.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * jdbc工具类，使用druid连接池
 */
public class JDBCUtils {
    private static DataSource ds;
    static {
        //加载配置文件
        Properties pro = new Properties();
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");

        try {
            pro.load(is);
            //获取连接池
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //通过连接池获取Connection对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //获取连接池对象
    public static DataSource getDataSourse(){
        return ds;
    }

}
