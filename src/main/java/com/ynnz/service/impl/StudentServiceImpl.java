package com.ynnz.service.impl;

import com.ynnz.dao.StudentDao;
import com.ynnz.entity.Student;
import com.ynnz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public int deleteStudent(int id) {
        return studentDao.deleteStudent(id);
    }

    @Override
    public List<Student> queryStudents() {
        return studentDao.queryStudents();
    }

    @Override
    public List<Student> queryStudentById(int id) {
        return studentDao.queryStudentById(id);
    }
}