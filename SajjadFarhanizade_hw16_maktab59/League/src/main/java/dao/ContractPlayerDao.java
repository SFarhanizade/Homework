package dao;

import entity.ContractPlayer;

import javax.persistence.EntityManager;

public class ContractPlayerDao extends BaseDao<ContractPlayer> {

    public ContractPlayerDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<ContractPlayer> getEntityClass() {
        return ContractPlayer.class;
    }
}
