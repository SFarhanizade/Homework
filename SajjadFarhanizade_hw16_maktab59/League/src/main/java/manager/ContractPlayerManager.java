package manager;

import dao.ContractPlayerDao;
import entity.ContractPlayer;

public class ContractPlayerManager extends BaseManager<ContractPlayer> {
    public ContractPlayerManager() {
        baseDao = new ContractPlayerDao(entityManager);
    }
}
