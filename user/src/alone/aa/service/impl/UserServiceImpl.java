package alone.aa.service.impl;

import alone.aa.dao.UserDao;
import alone.aa.dao.impl.UserDaoImpl;
import alone.aa.domain.PageBean;
import alone.aa.domain.User;
import alone.aa.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao  userDao=new UserDaoImpl();

    /**
     * 查找所有用户
     * @return
     */
    @Override
    public List<User> findAll() {
        //调用userDao完成查询
        List<User> users = userDao.findAll();
        return users;
    }

    /**
     * 根据用户输入的 username和 password查找用户是否存在
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.findUserByUserNameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void delUser(String id) {
        userDao.delUser(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if (ids!=null && ids.length>0){
            //1.遍历数组
            for (String id : ids) {
                userDao.delUser(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String page, String _rows, Map<String, String[]> condition) {
        int currentPage=Integer.parseInt(page);
        int rows=Integer.parseInt(_rows);


        //1.创建空的pageBean对象
        PageBean<User> pageBean = new PageBean<>();


        //3.调用dao查询总的记录数
        int totalCount=userDao.findTotalCount(condition);


        //4调用dao查询list集合
        //4.1计算开始的记录索引
        int start=(currentPage-1)*rows;
        List<User> list=userDao.findByPage(start,rows,condition);


        //5.计算总页码
        int totalPage=(totalCount%rows) ==0 ? (totalCount/rows) : (totalCount/rows) +1 ;
        System.out.println();
        if(currentPage>totalPage){
            currentPage=totalPage;
        }
        //2.设置参数

        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        pageBean.setList(list);
        pageBean.setTotalPage(totalPage);
        return pageBean;

    }

}
