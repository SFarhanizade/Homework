package manager;

import dao.ContractCoachDao;
import entity.ContractCoach;

public class ContractCoachManager extends BaseManager<ContractCoach>{
    public ContractCoachManager() {
        baseDao = new ContractCoachDao(entityManager);
    }
}
