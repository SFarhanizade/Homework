package ir.maktab.jdbc;

import ir.maktab.jdbc.entity.Course;
import ir.maktab.jdbc.service.CourseService;

import javax.xml.namespace.QName;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        CourseService courseService = new CourseService();
        while(true){
            System.out.println("""
                    1-Manage Courses
                    2-Manage Students
                    3-Manage Majors""");
            int menuNum= input.nextInt();
            input.nextLine();
            switch(menuNum){
                case 1:{
                    List<Course> courses = courseService.getAll();
                    System.out.println("""
                            ========
                            Courses:
                            ========""");
                    for(int i = 0;i<courses.size();i++){
                        Course tmpCourse = courses.get(i);
                        System.out.println((i+1)+"-"+tmpCourse.getName() + "  | Unit: "
                        +tmpCourse.getUnit());
                    }
                    System.out.println("""
                            
                            1-Edit a course
                            2-Add a course
                            """);
                    menuNum = input.nextInt();
                    input.nextLine();
                    switch (menuNum){
                        case 1:{
                            System.out.print("Enter the course number: ");
                            menuNum = input.nextInt();
                            input.nextLine();
                            Course tmpCourse = courses.get(menuNum-1);
                            System.out.println("\nCourse id: "+tmpCourse.getId()
                                                +"\nCourse name: "+ tmpCourse.getName()
                                                +"\nCourse unit: "+tmpCourse.getUnit());
                            System.out.println("""
                                    1-Edit name
                                    2-Edit unit
                                    3-Delete""");
                            menuNum=input.nextInt();
                            input.nextLine();
                            switch (menuNum){
                                case 1:{
                                    System.out.print("Enter the new name: ");
                                    String name=input.nextLine();
                                    tmpCourse.setName(name);
                                    courseService.saveOrUpdate(tmpCourse);
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
