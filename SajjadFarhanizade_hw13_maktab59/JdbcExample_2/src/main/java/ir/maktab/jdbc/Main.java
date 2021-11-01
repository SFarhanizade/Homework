package ir.maktab.jdbc;

import ir.maktab.jdbc.entity.Course;
import ir.maktab.jdbc.entity.Major;
import ir.maktab.jdbc.entity.Student;
import ir.maktab.jdbc.service.CourseService;
import ir.maktab.jdbc.service.MajorService;
import ir.maktab.jdbc.service.StudentService;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        CourseService courseService = new CourseService();
        StudentService studentService = new StudentService();
        MajorService majorService = new MajorService();
        while (true) {
            System.out.println("""
                    1-Manage Courses
                    2-Manage Students
                    3-Manage Majors""");
            int menuNum = input.nextInt();
            input.nextLine();
            switch (menuNum) {
                case 1: {
                    List<Course> courses = courseService.getAll();
                    System.out.println("""
                            ========
                            Courses:
                            ========""");
                    for (int i = 0; i < courses.size(); i++) {
                        Course tmpCourse = courses.get(i);
                        System.out.println((i + 1) + "-" + tmpCourse.getName() + "  | Unit: "
                                + tmpCourse.getUnit());
                    }
                    System.out.println("""
                                                        
                            1-Edit a course
                            2-Add a course
                            3-Back
                            """);
                    menuNum = input.nextInt();
                    input.nextLine();
                    switch (menuNum) {
                        case 1: {
                            System.out.print("Enter the course number: ");
                            menuNum = input.nextInt();
                            input.nextLine();
                            Course tmpCourse = courses.get(menuNum - 1);
                            System.out.println("\nCourse id: " + tmpCourse.getId()
                                    + "\nCourse name: " + tmpCourse.getName()
                                    + "\nCourse unit: " + tmpCourse.getUnit());
                            System.out.println("""
                                    1-Edit name
                                    2-Edit unit
                                    3-Delete""");
                            menuNum = input.nextInt();
                            input.nextLine();
                            switch (menuNum) {
                                case 1: {
                                    System.out.print("Enter the new name: ");
                                    String name = input.nextLine();
                                    tmpCourse.setName(name);
                                    courseService.saveOrUpdate(tmpCourse);
                                    break;
                                }
                                case 2: {
                                    System.out.print("Enter the new unit: ");
                                    int unit = input.nextInt();
                                    input.nextLine();
                                    tmpCourse.setUnit(unit);
                                    courseService.saveOrUpdate(tmpCourse);
                                    break;
                                }
                                case 3: {
                                    System.out.print("Are you sure to delete this? (y/n) ");
                                    String result = input.nextLine();
                                    if (result.equals("y"))
                                        courseService.delete(tmpCourse);
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            System.out.print("Name: ");
                            String name = input.nextLine();
                            System.out.print("Unit: ");
                            int unit = input.nextInt();
                            courseService.saveOrUpdate(new Course(0, name, unit));
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    List<Student> students = studentService.getAll();
                    System.out.println("""
                            ========
                            Students:
                            ========""");
                    for (int i = 0; i < students.size(); i++) {
                        Student tmpStudent = students.get(i);
                        System.out.println((i + 1) + "-" + tmpStudent.getName() + "  | Major: "
                                + tmpStudent.getMajor());
                    }
                    System.out.println("""
                                                        
                            1-Edit a student
                            2-Add a student
                            3-Back
                            """);
                    menuNum = input.nextInt();
                    input.nextLine();
                    switch (menuNum) {
                        case 1: {
                            System.out.print("Enter the student number: ");
                            menuNum = input.nextInt();
                            input.nextLine();
                            Student tmpStudent = students.get(menuNum - 1);
                            System.out.println("Student id: " + tmpStudent.getId()
                                    + "\nName: " + tmpStudent.getName()
                                    + "\nFamily: " + tmpStudent.getFamilyName()
                                    + "\nMajor: " + tmpStudent.getMajor().getName()
                                    + "\nTotal Units: " + tmpStudent.getTotalUnits());
                            System.out.println("""
                                                                        
                                    1-Edit name
                                    2-Edit family
                                    3-Edit major
                                    4-Show courses
                                    5-Back                                    
                                    """);
                            menuNum = input.nextInt();
                            input.nextLine();
                            switch (menuNum) {
                                case 1: {
                                    System.out.print("Enter a new name: ");
                                    String name = input.nextLine();
                                    tmpStudent.setName(name);
                                    studentService.saveOrUpdate(tmpStudent);
                                    break;
                                }
                                case 2: {
                                    System.out.print("Enter a new family name: ");
                                    String family = input.nextLine();
                                    tmpStudent.setFamilyName(family);
                                    studentService.saveOrUpdate(tmpStudent);
                                    break;
                                }
                                case 3: {
                                    List<Major> majors = majorService.getAll();
                                    for (int i = 0; i < majors.size(); i++) {
                                        Major tmpMajor = majors.get(i);
                                        System.out.println((i + 1) + "-" + tmpMajor.getName());
                                    }
                                    System.out.print("\nSelect a major: ");
                                    menuNum = input.nextInt();
                                    tmpStudent.setMajor(majors.get(menuNum - 1));
                                    break;
                                }
                                case 4: {
                                    List<Course> courses = (List<Course>) tmpStudent.getCourses();
                                    for (int i = 0; i < courses.size(); i++) {
                                        Course tmpCourse = courses.get(i);
                                        System.out.println((i + 1) + "-" + tmpCourse.getName());
                                    }
                                    System.out.println("""
                                                                                        
                                            1-Delete a course
                                            2-Add a course
                                            3-Back
                                            """);
                                    menuNum = input.nextInt();
                                    input.nextLine();
                                    switch (menuNum){
                                        case 1:{
                                            System.out.print("Enter the course number: ");
                                            menuNum = input.nextInt();
                                            input.nextLine();
                                            courses.remove(menuNum-1);
                                            tmpStudent.setCourses((Set<Course>) courses);
                                            studentService.saveOrUpdate(tmpStudent);
                                            break;
                                        }
                                        case 2:{
                                            for (int i = 0; i < courses.size(); i++) {
                                                Course tmpCourse = courses.get(i);
                                                System.out.println((i+1)+"-"+ tmpCourse.getName()
                                                +"   |   Units: "+tmpCourse.getUnit());
                                            }
                                            System.out.print("\nEnter a course number to add: ");
                                            menuNum = input.nextInt();
                                            input.nextLine();
                                            Set<Course> courseSet = (Set<Course>) courses;
                                            courseSet.add(courses.get(menuNum-1));
                                            tmpStudent.setCourses(courseSet);
                                            studentService.saveOrUpdate(tmpStudent);
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
}
