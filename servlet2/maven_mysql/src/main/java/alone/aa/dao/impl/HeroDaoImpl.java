package alone.aa.dao.impl;

import alone.aa.dao.HeroDao;
import alone.aa.domain.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDaoImpl implements HeroDao {
    public List<Hero> findAll() throws SQLException {
        List<Hero> list=new ArrayList<Hero>();
        Connection conc =null;
        PreparedStatement pstmt =null;
        ResultSet rs =null;
        //注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取Connection对象
            conc=DriverManager.getConnection("jdbc:mysql:///day17", "root", "root");
            ////获取真正操作数据的对象
            pstmt=conc.prepareStatement("select * from user");
            //进行数据库的查询
            rs=pstmt.executeQuery();
            while (rs.next()){
                Hero hero = new Hero();
                hero.setId(rs.getInt("id"));
                hero.setName(rs.getString("name"));
                list.add(hero);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conc.close();
            pstmt.close();
            rs.close();
        }

        return list;
    }
}
