package manager;

import dao.CityDao;
import dao.PlayerDao;
import entity.Player;

import java.util.List;

public class PlayerManager extends BaseManager<Player> {
    public PlayerManager() {
        baseDao = new PlayerDao(entityManager);
    }

    public List<Player> loadFreePlayers() {
        return ((PlayerDao)baseDao).loadFreePlayers();
    }
}
