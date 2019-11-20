package com.web_dev.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.web_dev.blog.entity.Article;
import com.web_dev.blog.factory.ServiceFactory;
import com.web_dev.blog.service.ArticleService;
import com.web_dev.blog.util.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author xunmi
 * @ClassName ArticleController
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/api/article")
public class ArticleController extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);
    private ArticleService articleService = ServiceFactory.getArticleServiceInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> articleList = null;
        articleList = articleService.initArticle();
        ResponseObject ro = null;
        if (resp.getStatus() == 200) {
            ro = ResponseObject.success(200, "成功", articleList);
        } else {
            ro = ResponseObject.error(resp.getStatus(), "失败");
        }
        PrintWriter out = resp.getWriter();
        Gson gson = new GsonBuilder().create();
        out.print(gson.toJson(ro));
        out.close();
    }

    @Override
    public void init() throws ServletException {
        logger.info("ArticleController初始化");
    }
}
