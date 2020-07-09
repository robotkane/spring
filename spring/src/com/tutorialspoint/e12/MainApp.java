package com.tutorialspoint.e12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansE12.xml");
        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
        System.out.println("--- Create ---");
        studentJDBCTemplate.create("小明", 1);
        studentJDBCTemplate.create("小东", 2);
        studentJDBCTemplate.create("小华", 3);
        System.out.println("--- List ---");
        List<Student> students = studentJDBCTemplate.listStudents();
        for (Student student : students) {
            System.out.println("ID : " + student.getId());
            System.out.println("Name : " + student.getName());
            System.out.println("Age : " + student.getAge());
        }
        System.out.println("--- GET ID ---");
        Student student = studentJDBCTemplate.getStudent(2);
        System.out.println("ID : " + student.getId());
        System.out.println("Name : " + student.getName());
        System.out.println("Age : " + student.getAge());
    }
}
