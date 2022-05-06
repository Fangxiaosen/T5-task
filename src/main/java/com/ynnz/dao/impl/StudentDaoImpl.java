package com.ynnz.dao.impl;//package com.ynnz.dao.I;

import com.ynnz.dao.StudentDao;
import com.ynnz.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate template;

    @Override
    public int insertStudent(Student student) {
        String sql = "insert into student values(?,?,?,?)";
        return template.update(sql, student.getId(), student.getName(),
                student.getSex(), student.getAge());
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "update student set name=?,sex=?,age=? where id=?";
        return template.update(sql, student.getName(), student.getSex(),
                student.getAge(), student.getId());
    }

    @Override
    public int deleteStudent(int id) {
        String sql = "delete from student where id=?";
        return template.update(sql, id);
    }

    @Override
    public List<Student> queryStudents() {
        String sql = "select * from student";
        return template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
    }

    @Override
    public List<Student> queryStudentById(int id) {
        String sql = "select * from student where id=?";
        return template.query(sql, new BeanPropertyRowMapper<Student>(Student.class), id);
    }
}