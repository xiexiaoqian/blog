package com.web_dev.blog.service;

import com.web_dev.blog.dao.UserDao;
import com.web_dev.blog.domain.UserDto;
import com.web_dev.blog.factory.ServiceFactory;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService = ServiceFactory.getUserServiceInstance();

    @Test
    public void signIn() {
        UserDto userDto = new UserDto("13959327030", "f3dc41a6273bc0b4219d705b88dc5de5");
        Map<String, Object> map = userService.signIn(userDto);
        System.out.println(map);
    }
}