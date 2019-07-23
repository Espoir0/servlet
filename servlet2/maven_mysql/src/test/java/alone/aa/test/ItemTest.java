package alone.aa.test;

import alone.aa.dao.impl.HeroDaoImpl;
import alone.aa.domain.Hero;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ItemTest {
    @Test
    public void findAll() throws SQLException {
        HeroDaoImpl heroDao = new HeroDaoImpl();
        List<Hero> list  = heroDao.findAll();
        for (Hero hero : list) {
            System.out.println(hero);
        }
    }
}
