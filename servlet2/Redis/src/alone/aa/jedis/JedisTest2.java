package alone.aa.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Jedis测试类
 */

public class JedisTest2 {
    @Test
    public void test1(){
        //1.获取连接
        Jedis jedis=new Jedis("localhost",6379);
        //2.操作
        jedis.set("heroname","libai");
        //20秒后自动删除，可以用来设置验证码
        jedis.setex("heroname",20,"libai");

        String heroname = jedis.get("heroname");
        System.out.println(heroname);
        //3.关闭连接
        jedis.close();
    }
}
