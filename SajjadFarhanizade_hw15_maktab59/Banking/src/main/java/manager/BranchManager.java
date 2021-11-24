package manager;

import dao.BranchDao;
import entity.Account;
import entity.Branch;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BranchManager extends BaseManager<Branch,Long>{

    public BranchManager(EntityManager entityManager) {
        super(entityManager);
        setBaseDao(new BranchDao(entityManager));
    }

    public Branch loadByName(String name){
        TypedQuery<Branch> query = entityManager.createQuery("From Branch where name=:name", Branch.class);
        query.setParameter("name",name);
        return query.getSingleResult();
    }

    public boolean exists(String name){
        return new BranchDao(entityManager).exists(name);
    }
}
