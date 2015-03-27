<%@page import="ru.tutorialsworld.models.ArticleModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="ru.tutorialsworld.models.entities.Article"%>
<%@ page import="ru.tutorialsworld.models.CategoryModel"%>
<%@ page import="ru.tutorialsworld.models.entities.Category"%>

<%
	List<Category> categories = CategoryModel.getCategoriesByLevel(2);
	Boolean articleSaveParam = (Boolean)request.getAttribute("article-save-ok");
	
	String articleIdParam = (String)request.getParameter("id");
	Article article = null;
	if (articleIdParam!=null){
		int articleId = Integer.valueOf(articleIdParam);
		article = ArticleModel.getArticleById(articleId);
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="ckeditor/ckeditor.js"></script>
<title>add article page</title>
</head>
<body>
	<h3>Форма добавления статьи</h3>
	<form action="/add_content" method="post">
		<input name="content-type" type="hidden" value="article" />
		<input name="article-id" type="hidden" value="<%=article==null ? "" : article.getId()%>" />
		<label>Заголовок статьи </label>
		<input type="text" name="title" maxlength="200" value="<%=article==null ? "" : article.getTitle()%>"/> <br />
		<label>URL статьи</label>
		<input type="text" name="url" maxlength="50" value="<%=article==null ? "" : article.getUrl()%>"/> <br />
		<label>Категория</label>
		<select name="category">
			<%
				for(Category cat : categories) {
			%>
			<option value="<%=cat.getId()%>"><%=cat.getFullName()%></option>
			<%
				}
			%>
		</select>
		<br />
		<label>Текст статьи</label>
		<br />
		<textarea name="editor1" id="editor1" rows="10" cols="40"><%=article==null ? "" : article.getContent()%></textarea>
		<br />
		<button type="submit">Отправить</button>
	</form>
	<% if (articleSaveParam != null){ %>
	<h4 style="color: green; font-style: italic;">Статья успешно сохранена <%=articleSaveParam %></h4>
	<% } %>
	<script>
		CKEDITOR.replace('editor1', {
			uiColor : '#9AB8F3'
		});
	</script>
</body>
</html>