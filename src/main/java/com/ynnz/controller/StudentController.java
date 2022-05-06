package com.ynnz.controller;

import com.ynnz.entity.Student;
import com.ynnz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;

/**
 * @Title: StudentController
 * @Description:
 * @PACKAGE_NAME：com.ynnz.controller
 * @Author: 94358 fangjinsen
 * CreateDate: 2022/5/6 10:57
 */
@Controller
public class StudentController {
    private Random random = new Random();
    @Autowired
    private StudentService studentService;
    //查询
    @RequestMapping("/queryStudents")
    public String queryStudents(Model model) {
        List<Student> studentList = studentService.queryStudents();
        model.addAttribute("studentList", studentList);
        return "main.jsp";
    }

    //删除
    @RequestMapping("/deleteStudents")
    public String deleteStudents(int id) {
        int i = studentService.deleteStudent(id);
        if (i>0){
            return "queryStudents";
        }
        return null;
    }

    //新增
    @RequestMapping("/insertStudents")
    public String insertStudents(Student student) {
        boolean temp = random.nextBoolean();
        int id = studentService.queryStudents().get(studentService.queryStudents().size() - 1).getId()+1;
        String sex ;
        if (temp==true){
            sex = "男";
        }else {
            sex = "女";
        }
        int nextInt = random.nextInt(100);
        student.setId(id);
        student.setName("测试数据"+nextInt);
        student.setSex(sex);
        student.setAge(nextInt);
        int i = studentService.insertStudent(student);
        if (i>0){
            return "queryStudents";
        }
        return null;
    }

    //修改
    @RequestMapping("/updataStudents")
    public String updataStudents(Student student,int id) {
        student.setId(id);
        student.setName("测试数据");
        student.setSex("男");
        student.setAge(random.nextInt(100));
        int i = studentService.updateStudent(student);
        if (i>0){
            return "queryStudents";
        }
        return null;
    }

    //测试路径
    //设置数据请求的路径、地址
    @RequestMapping("/test2")
    @ResponseBody
    public String test2() {
        return "成功";
    }
}
