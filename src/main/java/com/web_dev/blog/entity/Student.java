package com.web_dev.blog.entity;

import lombok.Data;

import java.time.LocalDateTime;


/**
 * @author xxq
 * @ClassName Student
 * @Description TODO
 * @Date 2019/11/6
 * @Version 1.0
 **/
@Data
public class Student {
    private Integer id;
    private String username;
    private String avatar;
    private String description;
    private LocalDateTime createTime;
}