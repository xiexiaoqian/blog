package com.web_dev.blog.service;

import com.web_dev.blog.entity.Article;

import java.util.List;

/**
 * @author xunmi
 * @ClassName ArticleService
 * @Description 文章业务逻辑
 * @Date 2019/11/9
 * @Version 1.0
 **/
public interface ArticleService {

    /**
     * 初始化图书信息
     * @return
     */
    List<Article> initArticle();

}
