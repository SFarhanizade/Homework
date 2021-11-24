package dao;

import entity.Branch;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BranchDao extends BaseDao<Branch,Long>{
    public BranchDao(EntityManager entityManager) {
        super(entityManager);
    }

    public boolean exists(String name){
        entityManager.getTransaction().begin();
        TypedQuery<Branch> query =
                entityManager.createQuery("From Branch b where b.name=:name", getEntityClass());
        query.setParameter("name", name);
        List<Branch> result = query.getResultList();
        entityManager.getTransaction().commit();
        return result.size()>0;
    }

    @Override
    public Class<Branch> getEntityClass() {
        return Branch.class;
    }
}
