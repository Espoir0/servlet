package cc;

import aa.jdbc1.Meinv;
import bb.utils.JDBCUtil;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Demo1 {
    //Junit 单元测试
    //获取对象
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());
    /**
     * 修改记录
     */
    @Test
    public void test(){

        String sql="update meinv4 set xw=1 where id=1";
        int count =jdbcTemplate.update(sql);//执行sql
        System.out.println(count);
    }

    /**
     * 添加记录
     */
    @Test
    public void test2(){
        String sql="insert into meinv4 (name,xw) values ('dd',11)";
        int count =jdbcTemplate.update(sql);
        System.out.println(count);
    }

    /**
     * 删除记录
     */
    @Test
    public void test3(){
        String sql="delete from meinv4 where id=?";
        int count =jdbcTemplate.update(sql,7);  //sql注入问题，不直接写
        System.out.println(count);
    }

    /**
     * 查询id为1的记录，将记录封装为Map
     */
    @Test
    public void test4(){
        String sql="select * from meinv4 where id=?";
        Map<String,Object> map=jdbcTemplate.queryForMap(sql,1);
        System.out.println(map);
        //{id=1, name=刘岩, xw=1, height=175, other_id=7, date=2019-07-09 17:02:51.0}
        //只能查询一条记录，将结果封装为map.结果集为一条记录

    }

    /**
     * 查询所有结果将其封装为List
     * queryForList
     */
    @Test
    public void test5(){
        String sql="select * from meinv";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        //将结果集的单条记录封装为Map,然后将所有记录封装为List
        System.out.println(list);
    }

    /**
     * 将结果集封装为Meinv对象的List集合
     */
    @Test
    public void test6(){
        String sql="select * from meinv";
        //由于可能存在null,所以将Meinv对象的属性都设置为引用类型
        List<Meinv1> list =jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Meinv1.class));
        System.out.println(list);
    }

    //旧式写法
    @Test
    public void test6_2(){
        String sql="select * from meinv";
        //由于可能存在null,所以将Meinv对象的属性都设置为引用类型
        List<Meinv1> list = jdbcTemplate.query(sql, new RowMapper<Meinv1>() {
            @Override
            public Meinv1 mapRow(ResultSet rs, int i) throws SQLException {
                Meinv1 mm=new Meinv1();
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int xw=rs.getInt("xw");

                mm.setId(id);
                mm.setName(name);
                mm.setXw(xw);
                return  mm;
            }
        });

        System.out.println(list);
    }

    /**
     * 查询总记录数
     */
    @Test
    public void test7(){
        String sql="select count(id) from meinv4";
        Long total=jdbcTemplate.queryForObject(sql,long.class);

        System.out.println(total);

    }
}
