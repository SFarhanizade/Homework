package dao;

import entity.Player;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PlayerDao extends BaseDao<Player> {
    public PlayerDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Player> getEntityClass() {
        return Player.class;
    }

    public List<Player> loadFreePlayers() {
        TypedQuery<Player> query =
                entityManager.createQuery("From Player p where p.team is null",
                        getEntityClass());
        return query.getResultList();
    }
}
