package dao;

import entity.Game;

import javax.persistence.EntityManager;

public class GameDao extends BaseDao<Game>{
    public GameDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Game> getEntityClass() {
        return Game.class;
    }
}
