package com.web_dev.blog.controller;

import cn.hutool.db.Session;
import com.web_dev.blog.util.ImageUtil;
import com.web_dev.blog.util.StringUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author xxq
 * @ClassName CodeController
 * @Description TODO
 * @Date 2019/11/20
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/api/code")
public class CodeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = StringUtil.createRandomCharData(6);
        //将验证码存入session
        HttpSession session = req.getSession();
        System.out.println(session.getId());
        session.setAttribute("code",code);
        resp.setHeader("Access-Token",session.getId());
        BufferedImage img = ImageUtil.getImage(code,200,100);
        //设置resp的响应内容类型
        resp.setContentType("image/jpg");
        //将图片通过输出流返回给客户端
        OutputStream out = resp.getOutputStream();
        ImageIO.write(img,"jpg",out);
        out.close();
    }
}
