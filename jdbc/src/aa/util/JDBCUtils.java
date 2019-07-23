package aa.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver ;

    /**
     * 获取步骤麻烦数据库连接对象，而且每次调用都要获取数据库连接对象
     * 没必要，考虑使用静态代码块，只会随着类的加载只加载一次
     * 使用配置文件的形式就不必手动写代码，修改配置文件即可，配置文件只读一次
     * 使用Properties集合，
     *
     * 在src目录下新建文件jdbc.properties
     */
    static {
        //使用Properties 集合，读取配置文件
        Properties pro=new Properties();

        //获取src路径下文件的方式，---》ClassLoader  类加载器
        ClassLoader classLoader=JDBCUtils.class.getClassLoader();   //获取类加载器

        URL res=classLoader.getResource("jdbc.properties"); //获取文件的url，只需要填写文件名即可
        String path = res.getPath();

        //注册驱动
        try {
            pro.load(new FileReader(path));  //获取配置文件中的数据

            //赋值
            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url,user,password);
    }


    /**
     *关闭资源的方法
     * @param stmt   执行sql对象
     * @param conc  数据库；连接对象
     */
    public static void close(Statement stmt,Connection conc){
        if(null!=stmt){
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
        }
    }

    /**
     * 关闭资源
     * @param resultSet
     * @param stmt
     * @param conc
     */
    public static void close(ResultSet resultSet,Statement stmt, Connection conc){
        if (null!=resultSet){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null!=stmt){
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
        }
    }
}
