package com.web_dev.blog.service.impl;

import com.web_dev.blog.dao.UserDao;
import com.web_dev.blog.domain.UserDto;
import com.web_dev.blog.entity.User;
import com.web_dev.blog.factory.DaoFactory;
import com.web_dev.blog.service.UserService;
import com.web_dev.blog.util.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xxq
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao = DaoFactory.getUserDaoInstance();
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Map<String, Object> signIn(UserDto userDto) {
        User user = null;
        Map<String,Object> map = new HashMap<>();

        try {
            user = userDao.findUserByMobile(userDto.getMobile());
        } catch (SQLException e) {
            logger.error("根据手机号查询用户出现异常");
        }
        if (user != null) {
            if (user.getPassword().equals(userDto.getPassword())) {
                map.put("msg", Message.SIGN_IN_SUCCESS);
                map.put("data", user);
            } else {
                map.put("msg", Message.PASSWORD_ERROR);
            }
        } else {
            map.put("msg", Message.MOBILE_NOT_FOUND);
        }
        return map;


    }

    @Override
    public Map<String, Object> register(UserDto userDto) {
        Map<String, Object> map = new HashMap<>();
        int i = 0;
        try {
            i = userDao.insert(userDto);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("用户注册时出错！");
        }
        System.out.println("i的值为：" + i);
        if (i == 1) {
            map.put("msg", Message.REGISTER_SUCCESS);
            map.put("data", userDto);
            logger.info("注册" + userDto.getMobile() + "用户成功");
        } else {
            map.put("msg", Message.REGISTER_DEFEATED);
        }
        return map;
    }

    @Override
    public List<User> hotUser() {
        List<User> userList = new ArrayList<>();
        try {
            userList = userDao.getHotUser();
        } catch (SQLException e) {
            logger.error("查询热门博主出现异常");
        }
        return userList;
    }

    @Override
    public User userById(Long id) {
        User user = null;
        try {
            user = userDao.getUserById(id);
        } catch (SQLException e) {
            logger.error("获取id=" + id + "的文章出错");
        }
        return user;
    }

}
