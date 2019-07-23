package alone.aa.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Jedis连接池
 */

public class JedisTest4 {
    @Test
    public void test1(){
        JedisPool jedisPool = new JedisPool();

        Jedis jedis = jedisPool.getResource();
            jedis.set("hero","李白");
            String hero = jedis.get("hero");
            System.out.println(hero);
        jedis.close();

    }
}
