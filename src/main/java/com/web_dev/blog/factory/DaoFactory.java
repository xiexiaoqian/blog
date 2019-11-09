package com.web_dev.blog.factory;

import com.web_dev.blog.dao.DaoImpl.StudentDaoImpl;
import com.web_dev.blog.dao.DaoImpl.UserDaoImpl;
import com.web_dev.blog.dao.StudentDao;
import com.web_dev.blog.dao.UserDao;
import com.web_dev.blog.entity.User;

/**
 * @author xxq
 * @ClassName DaoFactory
 * @Description TODO
 * @Date 2019/11/6
 * @Version 1.0
 **/
public class DaoFactory {
    public static StudentDao getStudentDaoInstance(){
        return new StudentDaoImpl();
    }


    public static UserDao getUserDaoInstance(){
        return new UserDaoImpl();
    }




}
