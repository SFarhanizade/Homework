package manager;

import dao.BaseDao;
import entity.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BaseManager<T extends BaseEntity> {
    static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("jpa-league");
    public static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    BaseDao<T> baseDao;

    public void save(T entity) {
        entityManager.getTransaction().begin();
        baseDao.save(entity);
        entityManager.getTransaction().commit();
    }

    public void update(T entity) {
        entityManager.getTransaction().begin();
        baseDao.update(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(T entity) {
        entityManager.getTransaction().begin();
        baseDao.delete(entity);
        entityManager.getTransaction().commit();
    }

    public T loadById(Long id) {
        return baseDao.loadById(id);
    }

    public List<T> loadAll() {
        return baseDao.loadAll();
    }

}
