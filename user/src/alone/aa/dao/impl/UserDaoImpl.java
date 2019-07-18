package alone.aa.dao.impl;

import alone.aa.dao.UserDao;
import alone.aa.domain.User;
import alone.aa.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    //私有化template对象
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSourse());

    /**
     *
     * @return 查询到的所有用户
     */
    @Override
    public List<User> findAll() {
        //使用jdbc操作数据库
        //1. 定义sql
        String sql="select * from user";
        List<User> users = template.query(sql,new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    //根据 username和password查找用户
    @Override
    public User findUserByUserNameAndPassword(String username, String password) {
        try {
            String sql="select * from admin where admin=? and password=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),username,password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        String sql="insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),
                user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void delUser(int id) {
        String sql="delete from user where id=?";
        template.update(sql,id);
    }

    @Override
    public User findUserById(int id) {
        String sql="select * from user where id=?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql="update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),
                user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义模板初始化sql
        String sql="select count(*) from user where 1 = 1 ";
        StringBuilder sb=new StringBuilder(sql);

        //遍历map
        Set<String> keys = condition.keySet();
        ArrayList<Object> params = new ArrayList<>();
        for (String key : keys) {
            System.out.println(key);
            //排除分页的条件参数
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value!=null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//加参数 ？条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);
        System.out.println(sql);


        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql="select * from user where 1 = 1 ";

        StringBuilder sb=new StringBuilder(sql);

        //遍历map
        Set<String> keys = condition.keySet();
        ArrayList<Object> params = new ArrayList<>();
        for (String key : keys) {
            System.out.println(key);
            //排除分页的条件参数
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value!=null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//加参数 ？条件的值
            }
        }

        //添加分页查询
        sb.append(" limit ? , ? ");
        params.add(start);
        params.add(rows);

        System.out.println(sb.toString());
        System.out.println(params);
        System.out.println(sql);
        sql=sb.toString();

        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}
