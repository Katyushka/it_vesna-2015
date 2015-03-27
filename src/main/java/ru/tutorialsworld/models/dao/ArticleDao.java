package ru.tutorialsworld.models.dao;

import java.util.List;

import ru.tutorialsworld.models.entities.Article;

public interface ArticleDao {
	public Article getArticleById(int articleId);
	public List<Article> getAllArticles();
	public List<Article> getArticlesByCategory(int category);
	public Article createArticle(String title, String url, String userName, int categoryId, String content);
	public Article updateArticle(int id, String title, String url, String userName, int categoryId, String content);
	public boolean deleteArticle(int id);
	public Article getArticleByTitle(String title);
}
