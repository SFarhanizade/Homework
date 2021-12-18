package ir.farhanizade.busticket.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BaseService<T extends BaseEntity> {
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("jpa-busTicket");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private BaseDao<T> baseDao = new BaseDao<>(entityManager);

    public void saveOrUpdate(T entity){
        baseDao.saveOrUpdate(entity);
    }

    public T loadById(Integer id) {
        T result = baseDao.loadById(id);
        return result;
    }

    public List<T> loadAll() {
        List<T> resultList = baseDao.loadAll();
        return resultList;
    }
}
