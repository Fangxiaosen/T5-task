package com.ynnz.test;

import com.ynnz.entity.Student;
import com.ynnz.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentTest {

    @Test
    public void testInsert() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) context.getBean("studentService");
        // 封装数据
        Student student = new Student(1001, "张三", "男", 25);
        int count = studentService.insertStudent(student);
        if (count > 0) {
            System.out.println("新增成功");
        } else {
            System.out.println("新增失败");
        }
    }

    @Test
    public void testUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) context.getBean("studentService");
        // 封装数据
        Student student = new Student(1001, "李四", "女", 23);
        int count = studentService.updateStudent(student);
        if (count > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    @Test
    public void testDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) context.getBean("studentService");
        int count = studentService.deleteStudent(1001);
        if (count > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void testQuery() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) context.getBean("studentService");
        // 查询数据
        List<Student> list = studentService.queryStudents();
        System.out.println(list);
    }

    @Test
    public void testQueryById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) context.getBean("studentService");
        // 查询数据
        List<Student> list = studentService.queryStudentById(1002);
        System.out.println(list);
    }
}