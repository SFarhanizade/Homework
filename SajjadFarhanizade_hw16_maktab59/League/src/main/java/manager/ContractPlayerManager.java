package manager;

import dao.ContractPlayerDao;
import entity.ContractPlayer;

import java.util.List;

public class ContractPlayerManager extends BaseManager<ContractPlayer> {
    public ContractPlayerManager() {
        baseDao = new ContractPlayerDao(entityManager);
    }

    public List<ContractPlayer> getMostExpensive() {
        return ((ContractPlayerDao)baseDao).getMostExpensive();
    }
}
