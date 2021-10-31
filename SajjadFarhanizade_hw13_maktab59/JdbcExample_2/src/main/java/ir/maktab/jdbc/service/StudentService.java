package ir.maktab.jdbc.service;

import ir.maktab.jdbc.dao.MajorDao;
import ir.maktab.jdbc.dao.StudentDao;
import ir.maktab.jdbc.dao.core.BaseDao;
import ir.maktab.jdbc.entity.Student;

public class StudentService extends AbstractCrudService<Student, Integer> {
    public StudentService() {
        setBaseDao(new StudentDao());
    }

    public StudentDao getBaseDao() {
        return (StudentDao) super.getBaseDao();
    }

}
