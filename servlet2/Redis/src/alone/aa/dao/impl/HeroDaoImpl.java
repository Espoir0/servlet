package alone.aa.dao.impl;

import alone.aa.dao.HeroDao;
import alone.aa.domain.Hero;
import alone.aa.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class HeroDaoImpl implements HeroDao{
    //声明成员变量
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Hero> findAll() {
        String sql="select * from hero";
        List<Hero> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Hero.class));
        return list;
    }
}
