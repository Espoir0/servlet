package alone.aa.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Jedis测试类
 */

public class JedisTest {
    @Test
    public void test1(){
        //1.获取连接
        Jedis jedis=new Jedis("localhost",6379);
        //2.操作
        jedis.set("heroname","libai");
        //3.关闭连接
        jedis.close();

    }
}
