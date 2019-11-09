package com.web_dev.blog.util;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author xxq
 * @ClassName JSoupTest
 * @Description TODO
 * @Date 2019/11/7
 * @Version 1.0
 **/
public class JSoupTest {
    public static void main(String[] args) throws IOException {
        Document document = null;
        document = Jsoup.connect("http://k27q175631.wicp.vip/growth.html").get();
        Elements cards = document.getElementsByClass("card");
        cards.forEach(card->{
            Element img = card.child(0);
            Element con = card.child(1);
            Element text = card.child(2);
            System.out.println(img);
            System.out.println(con.text());
            System.out.println(text.text());
        });

    }


}
