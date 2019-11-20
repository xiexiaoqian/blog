package com.web_dev.blog.factory;

import com.web_dev.blog.entity.Article;
import com.web_dev.blog.service.ArticleService;
import com.web_dev.blog.service.UserService;
import com.web_dev.blog.service.impl.ArticleServiceImpl;
import com.web_dev.blog.service.impl.UserServiceImpl;

/**
 * @author xxq
 * @ClassName ServiceFactory
 * @Description TODO
 * @Date 2019/11/7
 * @Version 1.0
 **/
public class ServiceFactory {

    public static UserService getUserServiceInstance(){
        return new UserServiceImpl();
    }

    public static ArticleService getArticleServiceInstance() {
        return new ArticleServiceImpl();
    }

}
