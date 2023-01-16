package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepo extends JpaRepository<Player, Long> {
    List<Player> findByOnlineGamerIsTrue();

    List<Player> findByCreditsGreaterThan(double credit);

    List<Player> getTop2ByLevelGreaterThan(Sort sort, int level);

    List<Player> getByLevelAndCreditsGreaterThan(int level, double credits);

    List<Player> getByLevelLessThanAndCreditsGreaterThan(int level, double credits);

    Player findTopByLevelGreaterThan(int level, Sort sort);

    List<Player> findByNameContaining(String content);

    List<Player> findByNameIs(String name);

    List<Player> getByCreditsGreaterThanEqualOrOnlineGamerIs(double credits, boolean status);

    int countByOnlineGamerIsNot(boolean onlineGamer);
}
