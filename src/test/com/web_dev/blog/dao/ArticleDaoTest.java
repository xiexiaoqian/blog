package com.web_dev.blog.dao;

import com.web_dev.blog.dao.DaoImpl.ArticleDaoImpl;
import com.web_dev.blog.entity.Article;
import com.web_dev.blog.factory.DaoFactory;
import com.web_dev.blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArticleDaoTest {
    ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
    Logger logger = LoggerFactory.getLogger(ArticleDaoTest.class);

    @Test
    public void selectAll() {
        try {
            articleDao.selectAll();
        } catch (SQLException e) {
            logger.info("查询所有信息失败");
        }


    }

    @Test
    public void batchInsert() {
        try {
            int[] result = articleDao.batchInsert(JSoupSpider.getArticle());
            System.out.println(result.length);
        } catch (SQLException e) {
            logger.info("批量插入失败");
        }

    }
}