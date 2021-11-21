package dao;

import entity.BaseEntity;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseDao<T extends BaseEntity<ID>, ID> {
    EntityManager entityManager;

    public BaseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public void update(T entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public T loadById(ID id) {
        entityManager.getTransaction().begin();
        T result = entityManager.find(getEntityClass(), id);
        entityManager.getTransaction().commit();
        return result;
    }

    public Set<T> loadAll() {
        entityManager.getTransaction().begin();
        Set<T> result = new HashSet<T>(entityManager.createQuery("From " +
                getEntityClass().getSimpleName()).getResultList());
        entityManager.getTransaction().commit();
        return result;
    }

    public abstract Class<T> getEntityClass();
}
