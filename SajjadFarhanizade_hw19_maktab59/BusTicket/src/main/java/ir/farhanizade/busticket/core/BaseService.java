package ir.farhanizade.busticket.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BaseService<T extends BaseEntity> {
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("jpa-busTicket");
    protected static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    protected BaseDao<T> baseDao;

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

    public void remove(T entity) {
        baseDao.remove(entity);
    }

    public void remove(Integer id){
        baseDao.remove(id);
    }
}
