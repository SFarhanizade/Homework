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

    public  void save(T entity){
        entityManager.persist(entity);
    }
    public  void update(T entity){
        entityManager.merge(entity);
    }
    public  void delete(T entity){
        entityManager.remove(entity);
    }
    public T loadById(ID id){
        return entityManager.find(getEntityClass(),id);
    }

    public Set<T> loadAll(){
        return new HashSet<T>((Collection<? extends T>) entityManager.createQuery("From "+ getEntityClass().getSimpleName()));
    }
    public abstract Class<T> getEntityClass();
}
