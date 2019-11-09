package com.web_dev.blog.service.impl;

import com.web_dev.blog.dao.StudentDao;
import com.web_dev.blog.entity.Student;
import com.web_dev.blog.factory.DaoFactory;
import com.web_dev.blog.service.StudentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author xxq
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Date 2019/11/7
 * @Version 1.0
 **/
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = DaoFactory.getStudentDaoInstance();

    @Override
    public List<Student> listStudent() {
        List<Student> studentList = null;
        try {
            studentList = studentDao.selectAll();
        } catch (SQLException e) {
            System.out.println("查询所有学生出现异常");
        }

        return studentList;
    }
}
