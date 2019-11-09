package com.web_dev.blog.dao;

import com.web_dev.blog.entity.User;
import com.web_dev.blog.factory.DaoFactory;
import com.web_dev.blog.util.JSoupSpiderUser;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;


public class UserDaoTest {
    private static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
    private UserDao userDao = DaoFactory.getUserDaoInstance();

    @Test
    public void batchInsert() {
        try {
            int[] result = userDao.batchInsert(JSoupSpiderUser.getUsers());
            System.out.println(result.length);
        } catch (SQLException e) {
            logger.error("批量新增用户出现异常");
        }
    }


    @Test
    public void findUserByMobile() {
        try {
            User user = userDao.findUserByMobile("13973379891");
            System.out.println(user);
        } catch (SQLException e) {
            logger.info("按手机查找用户异常");
        }
    }
}