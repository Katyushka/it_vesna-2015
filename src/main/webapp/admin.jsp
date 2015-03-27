<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin page</title>
</head>
<body>
	<%
		String userName = (String) session.getAttribute("user");
		if (userName == null) {
	%>
	<h1>Вы зашли на страницу админа.</h1>
	<br>
	<form action="/admin" method="post">
		<label>Имя пользователя: </label>
		<input type="text" name="username" /><br />
		<label>Пароль: </label>
		<input type="password" name="password" /><br />
		<button type="submit">Войти</button>
	</form>
	<%
		} else {
	%>
	<h1>
		Страница админа
	</h1>
	<br />
	<a href="/add_article.jsp">Добавить статью</a> <br />
	<a href="/show_articles.jsp">Все статьи</a>
	<%
		}
	%>
</body>
</html>