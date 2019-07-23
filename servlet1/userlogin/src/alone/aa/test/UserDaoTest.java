package alone.aa.test;

import alone.aa.dao.UserDao;
import alone.aa.modle.PO.User;
import org.junit.Test;

/**
 * userDao测试类，
 */
public class UserDaoTest {
    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("李白");
        loginUser.setPassword("9999");
        UserDao userDao=new UserDao();
        User user = userDao.login(loginUser);
        System.out.println(user);
    }

}
