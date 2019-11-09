package com.web_dev.blog.service;

import com.web_dev.blog.entity.Student;
import com.web_dev.blog.factory.ServiceFactory;
import com.web_dev.blog.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceTest {

    private StudentService studentService = ServiceFactory.getStudentServiceInstance();

    @Test
    public void listStudent() {
        List<Student> studenList = studentService.listStudent();
        studenList.forEach(System.out::println);
    }
}