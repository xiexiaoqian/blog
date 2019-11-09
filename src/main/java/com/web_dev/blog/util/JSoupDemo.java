package com.web_dev.blog.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author xxq
 * @ClassName JsoupDemo
 * @Description JSoup解析器练习
 * @Date 2019/11/7
 * @Version 1.0
 **/
public class JSoupDemo {
    public static void main(String[] args) throws Exception {

        Document document;
        //通过
        document = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users").get();
        //选取所有class为col-xs-8的元素集合
        Elements divs = document.getElementsByClass("col-xs-8");
//        对divs遍历
        divs.forEach(div-> {
//            取div的孩子节点
            Element wrapDiv = div.child(0);
//            System.out.println(wrapDiv.text());
            Element _blank = wrapDiv.child(0);
            Element name = _blank.child(1);
//            Element description = _blank.child(2);
            Element description = wrapDiv.child(0).child(2);
            System.out.println(name.text());
            System.out.println(description.text());
        });




    }
}
