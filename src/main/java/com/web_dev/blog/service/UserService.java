package com.web_dev.blog.service;

import com.web_dev.blog.domain.UserDto;
import com.web_dev.blog.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author xxq
 * @ClassName UserService
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public interface UserService {
    /**
     *
     * 用户登录功能
     * @param userDto
     * @return
     */
    Map<String,Object> signIn(UserDto userDto);

    Map<String, Object> register(UserDto userDto);

    List<User> hotUser();

    /**
     * 获取指定id的用户信息
     * @param id 指定文章id
     * @return
     */
    User userById(Long id);


}
