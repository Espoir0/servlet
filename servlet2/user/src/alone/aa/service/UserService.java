package alone.aa.service;

import alone.aa.domain.PageBean;
import alone.aa.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    //查询所有用户
    public List<User> findAll();
    //用户登录
    public abstract User login(User user);
    //添加用户
    public abstract void addUser(User user);
    //删除用户
    public abstract void delUser(String id);
    //根据id查找用户
    public abstract User findUserById(String id);

    public abstract void updateUser(User user);

    //批量删除
    void delSelectedUser(String[] ids);

    //分页条件查询
    PageBean<User> findUserByPage(String page, String rows, Map<String, String[]> condition);

}
