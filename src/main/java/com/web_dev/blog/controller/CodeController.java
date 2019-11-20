package com.web_dev.blog.controller;

import com.web_dev.blog.util.ImageUtil;
import com.web_dev.blog.util.StringUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@WebServlet(urlPatterns = "/code")
public class CodeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = StringUtil.createRandomCharData(6);

        BufferedImage img = ImageUtil.getImage(code,200,100);

        resp.setContentType("image/jpg");

        OutputStream out = resp.getOutputStream();
        ImageIO.write(img,"jpg",out);
        out.close();
    }
}
