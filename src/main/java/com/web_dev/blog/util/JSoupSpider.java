package com.web_dev.blog.util;

import com.web_dev.blog.entity.Article;
import com.web_dev.blog.entity.User;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author mq_xu
 * @ClassName JSoupSpider
 * @Description JSoup实现的一个爬虫工具
 * @Date 9:13 2019/11/7
 * @Version 1.0
 **/
public class JSoupSpider {
    private static Logger logger = LoggerFactory.getLogger(JSoupSpider.class);

    public static List<User> getUsers() {
        Document document = null;
        List<User> userList = new ArrayList<>(100);
        for (int i = 1; i <= 3; i++) {
            try {
                document = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users&page=" + i).get();
            } catch (IOException e) {
                logger.error("连接失败");
            }
            Elements divs = document.getElementsByClass("col-xs-8");
            divs.forEach(div -> {
                Element wrapDiv = div.child(0);
                Element link = wrapDiv.child(0);
                Elements linkChildren = link.children();
                User user = new User();
                user.setMobile(DataUtil.getMobile());
                user.setPassword(DataUtil.getPassword());
                user.setNickname(linkChildren.get(1).text());
                user.setGender(DataUtil.getGender());
                user.setAvatar("https:" + linkChildren.get(0).attr("src"));
                user.setIntroduction(linkChildren.get(2).text());
                user.setBirthday(DataUtil.getBirthday());
                user.setCreateTime(LocalDateTime.now());
                userList.add(user);
            });
        }
        return userList;
    }


    public static List<Article> getArticle() {
        Document document = null;
        List<Article> articleList = new ArrayList<>(100);
        int j = 0;
        for (int i = 0; i <= 180; ) {
            try {
                document = Jsoup.connect("https://book.douban.com/review/best/?start=" + i).get();
            } catch (IOException e) {
                logger.info("连接失败");
            }
            Elements cards = document.getElementsByClass("main review-item");
            cards.forEach(card -> {
                Element img = card.child(0).child(0);
                Element name = card.child(1).child(1);
                Element title = card.child(2).child(0);
                Element content = card.child(2).child(1).child(0);
                Element like = card.child(2).child(3).child(0).child(1);
                int n = card.child(1).children().size()-1;
                Element data = card.child(1).child(n);
                Article article = new Article();
                article.setTitle(title.text());
                article.setContent(content.text());
                article.setCover(img.attr("src"));
                article.setDiamond(new Random().nextInt(100));
                article.setComments(new Random().nextInt(100));
                article.setLikes(Integer.valueOf(like.text()));
                article.setPublishTime(Timestamp.valueOf(data.text()).toLocalDateTime());
                article.setUserId((long)new Random().nextInt(72)+1);
                articleList.add(article);
            });
            j++;
            i = j * 2 * 10;
        }
        return articleList;
    }


}
