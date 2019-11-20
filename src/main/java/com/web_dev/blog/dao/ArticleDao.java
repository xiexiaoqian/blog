package com.web_dev.blog.dao;


import com.web_dev.blog.entity.Article;

import java.sql.SQLException;
import java.util.List;

/**
 * @author xunmi
 * @ClassName ArticleDao
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public interface ArticleDao {

    /**
     * 初始化文章信息
     * @return
     * @throws SQLException
     */
    List<Article> selectAll() throws SQLException;

    /**
     * 批量增添数据
     * @param articleList
     * @return
     * @throws SQLException
     */
    int[] batchInsert(List<Article> articleList) throws SQLException;



}
