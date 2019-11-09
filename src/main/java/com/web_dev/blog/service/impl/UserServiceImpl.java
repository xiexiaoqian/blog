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
import java.util.HashMap;
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
}
