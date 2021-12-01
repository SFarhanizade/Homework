package manager;

import dao.ContractCoachDao;
import entity.ContractCoach;

import java.util.List;

public class ContractCoachManager extends BaseManager<ContractCoach>{
    public ContractCoachManager() {
        baseDao = new ContractCoachDao(entityManager);
    }

    public List<ContractCoach> getMostExpensive() {
        return ((ContractCoachDao)baseDao).getMostExpensive();
    }
}
