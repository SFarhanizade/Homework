package manager;

import dao.BaseDao;
import entity.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Set;

public class BaseManager<T extends BaseEntity<ID>, ID> {
    protected EntityManager entityManager;

    public BaseManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected BaseDao baseDao;

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    public void save(T entity) {
        baseDao.save(entity);
    }

    public void update(T entity) {
        baseDao.update(entity);
    }

    public void delete(T entity) {
        baseDao.delete(entity);
    }

    public void deleteAll() {
        baseDao.deleteAll();
    }

    public T loadById(ID id) {
        return (T) baseDao.loadById(id);
    }

    public Set<T> loadAll() {
        return baseDao.loadAll();
    }

}
