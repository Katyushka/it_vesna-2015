<%@page import="ru.tutorialsworld.models.CategoryModel"%>
<%@page import="java.awt.geom.Arc2D"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="ru.tutorialsworld.models.ArticleModel"%>
<%@page import="ru.tutorialsworld.models.entities.Article"%>
<%@ page import="java.util.List"%>
<%
	List<Article> articles = ArticleModel.getAllArticles();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Articles list</title>
</head>
<body>
	<h3>Список статей:</h3>
	<%
		for (Article article : articles) {
	%>
	<div style="border: 1px solid; margin-bottom: 5px;">
		<div>
			<a href="/add_article.jsp?id=<%=article.getId()%>"><%=article.getTitle()%></a>
		</div>
		<div>
			дата:
			<%=article.getCreateDate()%></div>
		<span>категория: <%=article.getCategoryId()%></span>

	</div>
	<%
		}
	%>
</body>
</html>