package ir.maktab.jdbc.service;

import ir.maktab.jdbc.dao.MajorDao;
import ir.maktab.jdbc.dao.core.BaseDao;
import ir.maktab.jdbc.entity.Major;

import java.util.List;

public class MajorService extends AbstractCrudService<Major,Integer>{
    @Override
    public void saveOrUpdate(Major entity) {
        super.saveOrUpdate(entity);
    }

    @Override
    public Major getById(Integer integer) {
        return super.getById(integer);
    }

    @Override
    public List<Major> getAll() {
        return super.getAll();
    }

    @Override
    public void delete(Major entity) {
        super.delete(entity);
    }

    public MajorService() {
        super.setBaseDao(new MajorDao());
    }

    public MajorDao getBaseDao() {
        return (MajorDao) super.getBaseDao();
    }
}
