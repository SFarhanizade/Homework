package manager;

import dao.CityDao;
import dao.GameDao;
import entity.Game;

public class GameManager extends BaseManager<Game>{
    public GameManager() {
        baseDao = new GameDao(entityManager);
    }
}
