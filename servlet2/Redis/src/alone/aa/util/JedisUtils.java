package alone.aa.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Jedis工具类
 *  加载配置文件，配置连接池的参数
 *  提供获取连接的方法
 */
public class JedisUtils {
    private static JedisPool jedisPool;
    /*
        获取连接的方法
     */
    static {
        //加载配置文件
        Properties pro = new Properties();
        InputStream is = JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        try {
            //关联文件
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取数据 ,设置到JedisPoolConfig中
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        poolConfig.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));

        //初始化JedisPool
        jedisPool=new JedisPool(pro.getProperty("host"),Integer.parseInt(pro.getProperty("port")));
    }

    //获取连接池的方法
    public static Jedis getJedisResource(){
        return jedisPool.getResource();
    }
}
