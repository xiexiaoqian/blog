package com.web_dev.blog.dao.DaoImpl;

import cn.hutool.extra.tokenizer.Result;
import com.web_dev.blog.dao.StudentDao;
import com.web_dev.blog.entity.Student;
import com.web_dev.blog.util.DbUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xxq
 * @ClassName StudentDaoImpl
 * @Description TODO
 * @Date 2019/11/6
 * @Version 1.0
 **/

public class StudentDaoImpl implements StudentDao {
    @Override
    public int insert(Student student) throws SQLException {
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO t_student VALUES (NULL,?,?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, student.getUsername());
        pstmt.setString(2, student.getAvatar());
        pstmt.setTimestamp(3, Timestamp.valueOf(student.getCreateTime()));
        int n = pstmt.executeUpdate();
        connection.commit();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public int[] batchInsert(List<Student> studentList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_student VALUES (NULL,?,?,?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        connection.setAutoCommit(false);
        studentList.forEach(student -> {
            try {
                pstmt.setString(1,student.getUsername());
                pstmt.setString(2,student.getAvatar());
                pstmt.setTimestamp(3,Timestamp.valueOf(student.getCreateTime()));
                System.out.println(student.getDescription());
                pstmt.setString(4,student.getDescription());
                pstmt.addBatch();
            } catch (SQLException e) {
                System.out.println("获取失败");
            }

        });

        //执行批处理操作
        int[] result = pstmt.executeBatch();
        //提交
        connection.commit();
        //关闭操作
        pstmt.close();
        connection.close();

        return result;
    }

    @Override
    public List<Student> selectAll() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_student ORDER BY id DESC";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setUsername(rs.getString("username"));
            student.setAvatar(rs.getString("avatar"));
            Timestamp timestamp = rs.getTimestamp("create_time");
            student.setCreateTime(timestamp.toLocalDateTime());
            studentList.add(student);

        }

        return studentList;
    }
}
