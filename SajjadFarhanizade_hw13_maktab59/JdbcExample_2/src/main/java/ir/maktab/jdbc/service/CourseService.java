package ir.maktab.jdbc.service;

import ir.maktab.jdbc.dao.CourseDao;
import ir.maktab.jdbc.entity.Course;

import java.util.List;

public class CourseService extends AbstractCrudService<Course,Integer> {
    public CourseService() {
        super.setBaseDao(new CourseDao());
    }

    @Override
    public void saveOrUpdate(Course entity) {
        super.saveOrUpdate(entity);
    }

    @Override
    public Course getById(Integer integer) {
        return super.getById(integer);
    }

    @Override
    public List<Course> getAll() {
        return super.getAll();
    }

    @Override
    public void delete(Course entity) {
        super.delete(entity);
    }

    public CourseDao getBaseDao() {
        return (CourseDao) super.getBaseDao();
    }
}
