package alone.aa.dao;

import alone.aa.domain.User;
import java.util.List;
import java.util.Map;

/**
 * 用户操作的Dao
 */
public interface UserDao {
    public abstract List<User> findAll();
    public abstract User findUserByUserNameAndPassword(String username,String password);
    public abstract void addUser(User user);
    public abstract void delUser(int id);
    public abstract User findUserById(int id);

    public abstract void updateUser(User user);

    //查询总记录数
    int findTotalCount(Map<String, String[]> condition);

    //分页查询每页的记录
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
