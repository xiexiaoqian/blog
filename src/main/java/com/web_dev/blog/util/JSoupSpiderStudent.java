package com.web_dev.blog.util;

import com.web_dev.blog.entity.Student;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xxq
 * @ClassName JSoupSpider
 * @Description TODO
 * @Date 2019/11/7
 * @Version 1.0
 **/
public class JSoupSpiderStudent {
    //静态的公有无参方法，方法名自定，，返回List<Student>
    public static List<Student> getStudent() {
        //声明文档变量
        Document document = null;
        //通过JSoup连接到目标页面
        try {
            document = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users").get();
        } catch (IOException e) {
            System.err.println("连接失败");
        }
        //选取所有class为col-xs-8的集合
        Elements divs = document.getElementsByClass("col-xs-8");
        //创建集合，建议给定初始化大小
        List<Student> studentList = new ArrayList<>(divs.size());
        //对divs遍历
        divs.forEach(div -> {
            //取出class为wrap的结点
            Element wrapDiv = div.child(0);
            Element avatar = wrapDiv.child(0).child(0);
            Element name = wrapDiv.child(0).child(1);
            Element description = wrapDiv.child(0).child(2);
            Student student = new Student();
            student.setUsername(name.text());
            student.setAvatar("http:" + avatar.attr("src"));
            student.setCreateTime(LocalDateTime.now());
            student.setDescription(description.text());
            studentList.add(student);
        });
        return studentList;
    }
}

