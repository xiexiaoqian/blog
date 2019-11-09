package com.web_dev.blog.dao;

import com.web_dev.blog.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface  StudentDao {
    int insert(Student student) throws SQLException;

    /**
     *
     * @param studentList
     * @return int[]
     * @throws SQLException
     */
    int[] batchInsert(List<Student> studentList) throws SQLException;

    /**
     *
     * @return
     * @throws SQLException
     */
    List<Student> selectAll() throws SQLException;
}
