package com.web_dev.blog.dao;

import com.web_dev.blog.domain.UserDto;
import com.web_dev.blog.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author xxq
 * @ClassName UserDao
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public interface UserDao {

    /**
     *批量增添用户
     * @param userList
     * @return
     * @throws SQLException
     */
    int[] batchInsert(List<User> userList) throws SQLException;

    /**
     * 按手机号码查找用户
     * @param mobile
     * @return
     * @throws SQLException
     */
    User findUserByMobile(String mobile) throws SQLException;

    /**
     * 新曾用户
     * @param userDto
     * @return
     * @throws SQLException
     */
    int insert(UserDto userDto) throws SQLException;

    /**
     * 获取热门作者
     * @return
     * @throws SQLException
     */
    List<User> getHotUser() throws SQLException;

    /**
     * 通过指定id查找文章详细信息
     * @param id 指定文章id
     * @return
     * @throws SQLException
     */
    User getUserById(Long id) throws SQLException;

}
