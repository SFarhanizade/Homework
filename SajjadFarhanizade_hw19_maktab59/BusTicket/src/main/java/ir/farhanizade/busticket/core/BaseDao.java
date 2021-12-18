package ir.farhanizade.busticket.core;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class BaseDao<T extends BaseEntity> {
    protected final EntityManager entityManager;

    public BaseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveOrUpdate(T entity) {
        entityManager.getTransaction().begin();
        if (entity.getId() == null)
            entityManager.persist(entity);
        else
            entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public T loadById(Integer id) {
        T result = entityManager.find(getEntityClass(), id);
        return result;
    }

    public List<T> loadAll() {
        TypedQuery<T> query = entityManager.createQuery("From " + getEntityClass().getSimpleName(),
                getEntityClass());
        List<T> resultList = query.getResultList();
        return resultList;
    }

    public abstract Class<T> getEntityClass();
}
