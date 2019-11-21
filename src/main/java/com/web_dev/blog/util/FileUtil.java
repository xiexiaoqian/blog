package com.web_dev.blog.util;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author xxq
 * @ClassName fileUtile
 * @Description TODO
 * @Date 2019/11/21
 * @Version 1.0
 **/
public class FileUtil {
    public static String createFile(String path) {
        System.out.println(path);
        File file = null;
        try {
            file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
                return file.toString();
            } else {
                return file.toString();
            }
        } catch (Exception e) {
            System.out.println("异常");
        }
        return null;
    }

    public static String getName(String name) {
        LocalDateTime time = LocalDateTime.now();
        int index = name.lastIndexOf(".");
        String last = name.substring(index);
        String uuidName = UUID.randomUUID().toString().replace("-","" + last);

        return uuidName;
    }

    public static void main(String[] args) {
        System.out.println(getName("aaa.jpg"));

    }
}
