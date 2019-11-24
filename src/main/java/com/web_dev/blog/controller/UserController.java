package com.web_dev.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.web_dev.blog.domain.UserDto;
import com.web_dev.blog.entity.User;
import com.web_dev.blog.factory.ServiceFactory;
import com.web_dev.blog.listener.MySessionContext;
import com.web_dev.blog.service.UserService;
import com.web_dev.blog.util.Message;
import com.web_dev.blog.util.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xxq
 * @ClassName UserController
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
@WebServlet(urlPatterns = {"/api/sign-in", "/api/register", "/api/user/hot", "/api/user/detail/*"})
public class UserController extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService = ServiceFactory.getUserServiceInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        Gson gson = new GsonBuilder().create();
        UserDto userDto = gson.fromJson(stringBuilder.toString(), UserDto.class);
        String inputCode = userDto.getCode().trim();
        Map<String, Object> map = null;
        // 获取请求路径
        String sessionId = req.getHeader("Access-Token");
        System.out.println("客户端传来的JSESSIONID：" + sessionId);
        MySessionContext myc = MySessionContext.getInstance();
        HttpSession session = myc.getSession(sessionId);
        String correctCode = session.getAttribute("code").toString().replace("  ", "");
        System.out.println("正确的验证码：" + correctCode);
        // 获取请求路径
        String requestPath = req.getRequestURI().trim();
        PrintWriter out = resp.getWriter();

        switch (requestPath) {
            case "/api/sign-in":
                map = userService.signIn(userDto);
                if (!inputCode.equalsIgnoreCase(correctCode)) {
                    map.put("msg", "验证码错误");
                }

                break;
            case "/api/register":
                map = userService.register(userDto);
                break;
        }
        String msg = (String) map.get("msg");
        ResponseObject ro;
        switch (msg) {
            case Message.SIGN_IN_SUCCESS:
            case Message.REGISTER_SUCCESS:
                ro = ResponseObject.success(200, msg, map.get("data"));
                break;
            case Message.PASSWORD_ERROR:
            case Message.MOBILE_NOT_FOUND:
            case Message.REGISTER_DEFEATED:
            case Message.CODE_ERROR:

            default:
                ro = ResponseObject.success(200, msg);
        }
        out.print(gson.toJson(ro));
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = new ArrayList<>();
        String requestPath = req.getRequestURI().trim();
        ResponseObject ro = null;
        User user = null;
        switch (requestPath) {
            case "/api/user/hot":
                userList = userService.hotUser();
                ro = ResponseObject.success(resp.getStatus(), resp.getStatus() == 200 ? "成功" : "失败", userList);
                break;
            default:
                String id = requestPath.substring(requestPath.lastIndexOf("/") + 1);
                user = userService.userById(Long.valueOf(id));
                ro = ResponseObject.success(resp.getStatus(), resp.getStatus() == 200 ? "成功" : "失败", user);
        }
        PrintWriter out = resp.getWriter();
        Gson gson = new GsonBuilder().create();
        out.print(gson.toJson(ro));
        out.close();
    }


    @Override
    public void init() throws ServletException {
        logger.info("UserController初始化");
    }
}
