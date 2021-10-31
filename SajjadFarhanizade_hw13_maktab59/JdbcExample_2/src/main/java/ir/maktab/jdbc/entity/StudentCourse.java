package ir.maktab.jdbc.entity;

import ir.maktab.jdbc.entity.base.BaseEntity;

public class StudentCourse implements BaseEntity<Integer> {
    private Student student;
    private Course course;



    public StudentCourse(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public void setId(Integer integer) {

    }

    @Override
    public Integer getId() {
        return null;
    }

    public static StudentCourseBuilder builder(){
        return new StudentCourseBuilder();
    }

    public static class StudentCourseBuilder{
        private Student student;
        private Course course;

        public StudentCourseBuilder student(Student student) {
            this.student = student;
            return this;
        }

        public StudentCourseBuilder course(Course course) {
            this.course = course;
            return this;
        }

        public StudentCourse build(){
            return new StudentCourse(student,course);
        }
    }
}
