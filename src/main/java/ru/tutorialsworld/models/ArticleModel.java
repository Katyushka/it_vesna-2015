package ru.tutorialsworld.models;

import java.util.List;

import ru.tutorialsworld.models.dao.ArticleDao;
import ru.tutorialsworld.models.dao.ArticleDaoImpl;
import ru.tutorialsworld.models.entities.Article;

public class ArticleModel {
	public static Article createArticle(String title, String url,
			int categoryId, String content, String userName) {
		ArticleDao articleDao = new ArticleDaoImpl();
		Article article = articleDao.createArticle(title, url,
				userName, categoryId, content);
		return article;
	}

	public static List<Article> getAllArticles() {
		ArticleDao articleDao = new ArticleDaoImpl();
		List<Article> articles = articleDao.getAllArticles();
		return articles;
	}

	public static Article getArticleById(int articleId) {
		ArticleDao articleDao = new ArticleDaoImpl();
		Article article = articleDao.getArticleById(articleId);
		return article;
	}

	public static Article getArticleByTitle(String title){
		ArticleDao articleDao = new ArticleDaoImpl();
		Article article = articleDao.getArticleByTitle(title);
		return article;
	}

	public static Article updateArticle(int id, String title, String url, int categoryId, String content, String userName) {
		ArticleDao articleDao = new ArticleDaoImpl();
		Article article = articleDao.updateArticle(id, title, url, userName, categoryId, content);
		return article;
	}
}
