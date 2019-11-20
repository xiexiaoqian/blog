package com.web_dev.blog.dao.DaoImpl;



import com.web_dev.blog.dao.ArticleDao;
import com.web_dev.blog.entity.Article;
import com.web_dev.blog.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xunmi
 * @ClassName ArticleDaoImpl
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public class ArticleDaoImpl implements ArticleDao {

    @Override
    public List<Article> selectAll() throws SQLException {
        List<Article> articleList = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_article ORDER BY id DESC ";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Article article = new Article();
            article.setId(rs.getLong("id"));
            article.setTitle(rs.getString("title"));
            article.setContent(rs.getString("content"));
            article.setCover(rs.getString("cover"));
            article.setDiamond(rs.getInt("diamond"));
            article.setComments(rs.getInt("comments"));
            article.setLikes(rs.getInt("likes"));
            article.setPublishTime(rs.getTimestamp("publish_time").toLocalDateTime());
            articleList.add(article);
        }
//        DbUtil.close(rs, stmt, connection);
        return articleList;
    }

    @Override
    public int[] batchInsert(List<Article> articleList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_article (title,content,cover,diamond,comments,likes,publish_time,user_id) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        connection.setAutoCommit(false);
        articleList.forEach(article -> {
            try {
                pstmt.setString(1,article.getTitle());
                pstmt.setString(2,article.getContent());
                pstmt.setString(3,article.getCover());
                pstmt.setInt(4,article.getDiamond());
                pstmt.setInt(5,article.getComments());
                pstmt.setInt(6,article.getLikes());
                pstmt.setObject(7,article.getPublishTime());
                pstmt.setLong(8,article.getUserId());
                pstmt.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        int[] result = pstmt.executeBatch();
        //提交
        connection.commit();
//        DbUtil.close(null,pstmt,connection);
        return result;
    }
}
