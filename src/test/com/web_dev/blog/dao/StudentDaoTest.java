package com.web_dev.blog.dao;

import com.web_dev.blog.entity.Student;
import com.web_dev.blog.factory.DaoFactory;
import com.web_dev.blog.factory.ServiceFactory;
import com.web_dev.blog.service.StudentService;
import com.web_dev.blog.util.JSoupSpiderStudent;
import org.junit.Test;


import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoTest {

    StudentService studentService = ServiceFactory.getStudentServiceInstance();
    StudentDao studentDao =DaoFactory.getStudentDaoInstance();

    @Test
    public void insert() throws SQLException {
        Student student = new Student();
        student.setId(1);
        student.setAvatar("123");
        student.setUsername("xxq");
        student.setCreateTime(LocalDateTime.now());

        System.out.println(DaoFactory.getStudentDaoInstance().insert(student));

    }

    @Test
    public void batchInsert() throws SQLException{
        int[] n = DaoFactory.getStudentDaoInstance().batchInsert(JSoupSpiderStudent.getStudent());
        assertEquals(24,n.length);
    }

    @Test
    public void selectAll() throws SQLException{
        List<Student> list = studentDao.selectAll();
        list.forEach(System.out::println);
    }
}