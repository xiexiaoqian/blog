package com.web_dev.blog.controller;

import com.web_dev.blog.util.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

/**
 * @author xxq
 * @ClassName UploadController
 * @Description TODO
 * @Date 2019/11/21
 * @Version 1.0
 **/
@MultipartConfig(maxFileSize = 1024 * 1024 * 50)
@WebServlet(urlPatterns = "/api/upload")
public class UploadController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取多个文件的part
        Collection<Part> parts = req.getParts();

        for (Part part : parts) {
            long max = 1024 * 1024 * 5;
            if (part.getSize() < max) {
                //获取上传文件的名字
                String name = part.getSubmittedFileName();
                //截取文件格式
                String lastName = name.substring(name.lastIndexOf("."));
                System.out.println(lastName);
                //构造将要创建的文件夹路径
                LocalDate date = LocalDate.now();
                String path = req.getSession().getServletContext().getRealPath("") + date ;
                //新建文件夹，返回值为路径
                String p = FileUtil.createFile(path);
                System.out.println(p);
                //构造新名字
                String newName = UUID.randomUUID().toString();
                //写入指定路径，
                part.write(p + "/" + newName + lastName);
                System.out.println(path + lastName);
                req.setAttribute("msg","上传成功！");
            }else {
                req.setAttribute("msg","文件过大！");
            }

        }
        resp.setContentType("image/jpg");
        req.getRequestDispatcher("/upload.jsp").forward(req,resp);


    }
}
