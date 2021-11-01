package ir.maktab.jdbc.service;

import ir.maktab.jdbc.dao.MajorDao;
import ir.maktab.jdbc.dao.StudentDao;
import ir.maktab.jdbc.dao.core.BaseDao;
import ir.maktab.jdbc.entity.Student;

import java.util.List;

public class StudentService extends AbstractCrudService<Student, Integer> {
    public StudentService() {
        setBaseDao(new StudentDao());
    }

    public StudentDao getBaseDao() {
        return (StudentDao) super.getBaseDao();
    }
    public void add(Student student){
        saveOrUpdate(student);
    }

    public Student getById(Integer id){
        return super.getById(id);
    }

    public List<Student> getAll(){
        return super.getAll();
    }

    public void delete(Student student){
        super.delete(student);
    }


}
