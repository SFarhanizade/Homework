package manager;

import dao.BaseDao;
import entity.BaseEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class BaseManager<T extends BaseEntity>{
    private EntityManager entityManager;
    BaseDao<T> baseDao;
    public void save(T entity){
        baseDao.save(entity);
    }
    public void update(T entity){
        baseDao.update(entity);
    }
    public void delete(T entity){
        baseDao.delete(entity);
    }
    public T loadById(Long id){
        return baseDao.loadById(id);
    }
    public List<T> loadAll() {
        return baseDao.loadAll();
    }

}
