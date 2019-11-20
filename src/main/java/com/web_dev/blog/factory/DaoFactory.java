package com.web_dev.blog.factory;

import com.web_dev.blog.dao.ArticleDao;
import com.web_dev.blog.dao.DaoImpl.ArticleDaoImpl;
import com.web_dev.blog.dao.DaoImpl.UserDaoImpl;
import com.web_dev.blog.dao.UserDao;

/**
 * @author xxq
 * @ClassName DaoFactory
 * @Description TODO
 * @Date 2019/11/6
 * @Version 1.0
 **/
public class DaoFactory {
    public static UserDao getUserDaoInstance(){
        return new UserDaoImpl();
    }

    public static ArticleDao getArticleDaoInstance(){
        return new ArticleDaoImpl();
    }




}
