package alone.aa.service;

import alone.aa.domain.Hero;

import java.util.List;

public interface HeroService {
    List<Hero> findAll();
    String findAllJson();
}
