package dao;

import entity.BaseEntity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class BaseDao<T extends BaseEntity> {
    protected EntityManager entityManager;

    public BaseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public T loadById(Long id) {
        return entityManager.find(getEntityClass(), id);
    }

    public List<T> loadAll(){
        TypedQuery<T> query = entityManager.createQuery("From " + getEntityClass().getSimpleName(),
                getEntityClass());
        return query.getResultList();
    }

    public abstract Class<T> getEntityClass();
}
