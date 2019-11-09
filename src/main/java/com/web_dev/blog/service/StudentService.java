package com.web_dev.blog.service;

import com.web_dev.blog.entity.Student;

import java.util.List;

public interface StudentService {
    /**
     * 获取所有学生
     * @return
     */
    List<Student> listStudent();
}
