package ClassObject;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * * 案例：   反射机制，框架的基础
 * 	* 需求：写一个"框架"，不能改变该类的任何代码的前提下，可以帮我们创建任意类的对象，并且执行其中任意方法
 * 		* 实现：
 * 			1. 配置文件
 * 			2. 反射
 * 		* 步骤：
 * 			1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
 * 			2. 在程序中加载读取配置文件
 * 			3. 使用反射技术来加载类文件进内存
 * 			4. 创建对象
 * 			5. 执行方法
 */
public class Demo5 {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        //1.1 创建Properties对象
        Properties pro = new Properties();

        //1.2加载配置文件，转化为一个集合
        //1.2.1 获取class目录下的配置文件
        ClassLoader loader=Demo5.class.getClassLoader();  //获取该类的类加载器
        InputStream is=loader.getResourceAsStream("pro.properties");//获取资源对应的字节流
        pro.load(is);  //从字节流中读取键值对。加载流

        //2.获取配置文件中的数据
        String className=pro.getProperty("className");
        String methodName=pro.getProperty("methodName");

        //3加载该类进内存
        Class cls=Class.forName(className);

        //4.创建对象
        Object obj=cls.newInstance();
        //5.获取方法对象
        Method method =cls.getDeclaredMethod(methodName);

        //使用方法
        method.invoke(obj);

    }
}
