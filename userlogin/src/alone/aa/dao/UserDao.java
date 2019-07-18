package alone.aa.dao;

import alone.aa.modle.PO.User;
import alone.aa.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中user的类
 */
public class UserDao {
    //声明JDBCTemplate对象共用,通过工具类创建template对象，通过template对象完成对数据库的CRUD
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 传进来的用户名和密码
     * @return 用户的所有信息,如果没有查询到，返回null
     */
    public User login(User loginUser){

        try {
            //sql
            String sql="select * from user where username=? and password=?";
            //使用quety查询,new BeanPropertyRowMapper<>(User.class)
            //表示将结果封装为User对象
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;//将查询到的结果返回
        } catch (DataAccessException e) {
            return null;
        }
    }

    //然后先进行测试，代码是否正确
}
