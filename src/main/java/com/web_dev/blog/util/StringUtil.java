package com.web_dev.blog.util;

import java.util.Random;

/**
 * @author xxq
 * @ClassName StringUtil
 * @Description TODO
 * @Date 2019/11/20
 * @Version 1.0
 **/
public class StringUtil {
    public static String createRandomCharData(int length)
    {
        StringBuilder sb=new StringBuilder();
        Random rand=new Random();
        Random randdata=new Random();
        int data=0;
        for(int i=0;i<length;i++)
        {
            int index=rand.nextInt(3);
            //目的是随机选择生成数字，大小写字母
            switch(index)
            {
                case 0:
                    data=randdata.nextInt(10);
                    sb.append(data);
                    break;
                case 1:
                    data=randdata.nextInt(26)+65;
                    sb.append((char)data);
                    break;
                case 2:
                    data=randdata.nextInt(26)+97;
                    sb.append((char)data);
                    break;
            }
        }
        String result=sb.toString();
        return result;
    }








    public static void main(String[] args) {
        System.out.println(StringUtil.createRandomCharData(6));
    }
}
