package alone.aa.service.impl;

import alone.aa.dao.HeroDao;
import alone.aa.dao.impl.HeroDaoImpl;
import alone.aa.domain.Hero;
import alone.aa.service.HeroService;
import alone.aa.util.JedisUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class HeroServiceImpl implements HeroService{
    //声明dao
    private HeroDao heroDao =new HeroDaoImpl();
    @Override
    public List<Hero> findAll() {
        return heroDao.findAll();
    }

    /*
     * 使用缓存redis
     */
    @Override
    public String findAllJson() {
        //1.先从redis中查询数据
        //2.获取redis客户端连接
        Jedis jedis = JedisUtils.getJedisResource();
        String hero_json =jedis.get("heros");
        System.out.println(hero_json);

        //判断 hero_json 数据是否为null
        if(hero_json==null ||hero_json.length()==0){
            //redis中没有数据
            System.out.println("redis中没有数据，查询数据库");
            //2.1从数据库中查询
            List<Hero> list = heroDao.findAll();
            //2.2将list 序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                hero_json = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //2.3将json数据存入 redis
            jedis.set("heros",hero_json);

            //2.4归还连接
            jedis.close();
        }else{
            System.out.println("redis中有数据");
        }
        return hero_json;
    }
}
