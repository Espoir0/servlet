package alone.aa.dao;

import alone.aa.domain.Hero;

import java.sql.SQLException;
import java.util.List;

public interface HeroDao {
    List<Hero> findAll() throws  Exception;
}
