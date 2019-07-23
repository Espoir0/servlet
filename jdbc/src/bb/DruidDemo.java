package bb;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {

        //导入jar包 ，驱动包
        //定义配置文件
        //加载配置文件
        Properties pro = new Properties(); //使用Properties集合加载文件

        //获取输入流，传给Properties
        InputStream is=DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");

        pro.load(is);   //该对象有文件的各数据

        //获取连接池对象
        DataSource ds= DruidDataSourceFactory.createDataSource(pro);
        System.out.println(ds);
    }
}
