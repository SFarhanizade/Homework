package ir.maktab.jdbc.service;

import ir.maktab.jdbc.dao.core.BaseDao;
import ir.maktab.jdbc.entity.base.BaseEntity;

import java.util.List;

public class AbstractCrudService<T extends BaseEntity<ID>, ID extends Number> {
    private BaseDao<T, ID> baseDao;

    public void saveOrUpdate(T entity) {
        if (entity.getId() == null) {
            baseDao.save(entity);
        } else {
            baseDao.update(entity.getId(), entity);
        }
    }

    public T getById(ID id){
        return baseDao.loadById(id);
    }

    public List<T> getAll(){
        return baseDao.loadAll();
    }

    public void delete(T entity){
        baseDao.delete(entity.getId());
    }

    public void setBaseDao(BaseDao<T, ID> baseDao) {
        this.baseDao = baseDao;
    }

    public BaseDao<T, ID> getBaseDao() {
        return baseDao;
    }
}
