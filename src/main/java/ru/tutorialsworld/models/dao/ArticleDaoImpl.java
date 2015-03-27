package ru.tutorialsworld.models.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ru.tutorialsworld.models.connection.ConnectionProvider;
import ru.tutorialsworld.models.entities.Article;

public class ArticleDaoImpl implements ArticleDao {

    @Override
    public Article getArticleById(int articleId) {
        Article article = null;
        try {
            String query = "SELECT * FROM articles WHERE id = ?";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, articleId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String url = rs.getString("url");
                Date createDate = new Date(rs.getDate("createDate").getTime());
                Date modifiedDate = new Date(rs.getDate("modifiedDate")
                        .getTime());
                String userName = rs.getString("userName");
                int categoryId = rs.getInt("categoryId");
                String content = rs.getString("content");
                article = new Article(id, title, url, createDate, modifiedDate,
                        userName, categoryId, content);
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<Article>();
        try {
            String query = "SELECT * FROM articles";
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String url = rs.getString("url");
                Date createDate = new Date(rs.getDate("createDate").getTime());
                Date modifiedDate = new Date(rs.getDate("modifiedDate")
                        .getTime());
                String userName = rs.getString("userName");
                int categoryId = rs.getInt("categoryId");
                String content = rs.getString("content");
                Article article = new Article(id, title, url, createDate,
                        modifiedDate, userName, categoryId, content);
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    @Override
    public List<Article> getArticlesByCategory(int category) {
        List<Article> articles = new ArrayList<Article>();
        try {
            String query = "SELECT * FROM articles WHERE categoryId = ?";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, category);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String url = rs.getString("url");
                Date createDate = new Date(rs.getDate("createDate").getTime());
                Date modifiedDate = new Date(rs.getDate("modifiedDate")
                        .getTime());
                String userName = rs.getString("userName");
                int categoryId = rs.getInt("categoryId");
                String content = rs.getString("content");
                Article article = new Article(id, title, url, createDate,
                        modifiedDate, userName, categoryId, content);
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }
    

    @Override
    public Article createArticle(String title, String url, String userName,
                                 int categoryId, String content) {
        Article article = null;
        try {
            String query = "INSERT INTO articles (title, url, createDate, modifiedDate, userName, categoryId, content) VALUES(?,?,now(),now(),?,?,?)";
            PreparedStatement pstmt = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, title);
            pstmt.setString(2, url);
            pstmt.setString(3, userName);
            pstmt.setInt(4, categoryId);
            pstmt.setString(5, content);
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            int articleId = -1;
            if (rs.next()) {
                articleId = rs.getInt(1);
            }
            article = getArticleById(articleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public Article updateArticle(int id, String title, String url, String userName,
                                 int categoryId, String content) {
        Article article = null;
        try {
            String query = "UPDATE articles SET title = ?, url = ?, modifiedDate = now(), userName = ?, categoryId = ?, content = ? WHERE id = ?";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, title);
            pstmt.setString(2, url);
            pstmt.setString(3, userName);
            pstmt.setInt(4, categoryId);
            pstmt.setString(5, content);
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
            System.out.println("Обновлена статья с id: " + id);
            article = this.getArticleById(id);
        } catch (SQLException e) {
            System.out.println("Валимся");
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public boolean deleteArticle(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Article getArticleByTitle(String titleParam) {
        Article article = null;
        try {
            String query = "SELECT * FROM articles WHERE name = ?";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, titleParam);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String url = rs.getString("url");
                Date createDate = new Date(rs.getDate("createDate").getTime());
                Date modifiedDate = new Date(rs.getDate("modifiedDate")
                        .getTime());
                String userName = rs.getString("userName");
                int categoryId = rs.getInt("categoryId");
                String content = rs.getString("content");
                article = new Article(id, title, url, createDate, modifiedDate,
                        userName, categoryId, content);
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    private Connection getConnection() {
        return ConnectionProvider.getConnection();
    }
}
