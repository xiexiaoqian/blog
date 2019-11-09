package com.web_dev.blog.factory;

import com.web_dev.blog.service.StudentService;
import com.web_dev.blog.service.UserService;
import com.web_dev.blog.service.impl.StudentServiceImpl;
import com.web_dev.blog.service.impl.UserServiceImpl;

/**
 * @author xxq
 * @ClassName ServiceFactory
 * @Description TODO
 * @Date 2019/11/7
 * @Version 1.0
 **/
public class ServiceFactory {
    public static StudentService getStudentServiceInstance(){
        return new StudentServiceImpl();
    }

    public static UserService getUserServiceInstance(){
        return new UserServiceImpl();
    }

}
