package alone.aa.jedis;

import alone.aa.util.JedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Jedis连接池工具类的使用
 */

public class JedisTest5 {
    @Test
    public void test1(){


        Jedis jedis = JedisUtils.getJedisResource();
        jedis.set("hero","李白");
        String hero = jedis.get("hero");
        System.out.println(hero);
        jedis.close();

    }
}
