package dao;

import entity.ContractCoach;

import javax.persistence.EntityManager;

public class ContractCoachDao extends BaseDao<ContractCoach> {
    public ContractCoachDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<ContractCoach> getEntityClass() {
        return ContractCoach.class;
    }
}
