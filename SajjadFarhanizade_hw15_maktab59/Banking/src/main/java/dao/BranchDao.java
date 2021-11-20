package dao;

import entity.Branch;

import javax.persistence.EntityManager;

public class BranchDao extends BaseDao<Branch,Long>{
    public BranchDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Branch> getEntityClass() {
        return Branch.class;
    }
}
