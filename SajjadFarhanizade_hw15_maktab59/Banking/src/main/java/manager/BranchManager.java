package manager;

import dao.BranchDao;
import entity.Branch;

import javax.persistence.EntityManager;

public class BranchManager extends BaseManager<Branch,Long>{

    public BranchManager(EntityManager entityManager) {
        super(entityManager);
        setBaseDao(new BranchDao(entityManager));
    }
}
