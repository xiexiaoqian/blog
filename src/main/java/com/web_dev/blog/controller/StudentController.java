package com.web_dev.blog.controller;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import com.web_dev.blog.entity.Student;
import com.web_dev.blog.factory.ServiceFactory;
import com.web_dev.blog.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author xxq
 * @ClassName StudentController
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/student")
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService studentService = ServiceFactory.getStudentServiceInstance();
        List<Student> studentList = studentService.listStudent();
        Gson gson = new Gson();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(studentList));
        out.close();


    }
}
