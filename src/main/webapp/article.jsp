<%@page import="ru.tutorialsworld.models.entities.Article"%>
<%@page import="ru.tutorialsworld.models.ArticleModel"%>
<%@page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page import="ru.tutorialsworld.models.CategoryModel" %>
<%@ page import="ru.tutorialsworld.models.entities.Category" %>

<%
	CategoryModel categoryModel = new CategoryModel();
	ArticleModel articleModel = new ArticleModel();
	List<Category> topLevelCategories = categoryModel.getTopLevelCategories();
	//Category category = categoryModel.getCategoryByName
	
%>
<!DOCTYPE html>
<html lang="ru">
	<head>
		<title>Tutorials World</title>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="css/stdtheme.css">
	</head>
<body>

	<div id='top'>
		<div id='topLogo'>
			<a href='/'><h2>TutorialsWorld.ru</h2></a>
		</div>
	</div>

	<div id='topnav'>
		<div id='topnavTut' class='notranslate'>
			<a class='topnav' target='_top' href='#'>Core Java</a>
			<a class='topnav' target='_top' href='#'>Servlet</a>
			<a class='topnav' target='_top' href='#'>JSP</a>
			<a class='topnav' target='_top' href='#'>EJB</a>
			<a class='topnav' target='_top' href='#'>Struts2</a>
			<a class='topnav' target='_top' href='#'>JavaMail</a>
			<a class='topnav' target='_top' href='#'>Hibernate</a>
			<a class='topnav' target='_top' href='#'>Spring</a>
			<div style='float:right;word-spacing:0;'><a class='topnav' target='_top' href='#'>страница 1</a>
				<span style='letter-spacing:14px;'> |</span><a class='topnav' target='_top' href='#'>страница 2</a>
				<span style='letter-spacing:14px;'> |</span><a class='topnav' target='_blank' href='#'>страница 3</a>
				<span style='letter-spacing:14px;'> |</span><a class='topnav' target='_top' href='#'>страница 4</a>
			</div>
		</div>
	</div>

	<div id='belowTopnav'>
		<div id='page'>
			<div>
				<div id='leftcolumn'>
					
					<% 
					List<Category> subcategories = categoryModel.getCategoriesByLevel(2);
					for (Category subcategory : subcategories) { %>
					<h2 class="left"><span class="left_h2"><%= subcategory.getFullName()%></span></h2>
					<% for (Article article : articleModel.getAllArticles()){ %>
					<a target="_top" href="article?id=<%=subcategory.getFullName() %>" class=""><%= article.getTitle() %></a>
					
					<% }} %>				
					
					
					
				</div>
			<div id='main'>
				<div id='mainLeaderboard'>
				</div>
				<h1><%=(String)request.getAttribute("id")%></h1>
				<div class="chapter">
					<div class="prev"><a class="chapter" href="#">&laquo; предыдущая</a></div>
					<div class="next"><a class="chapter" href="#">следующая &raquo;</a></div>
				</div>
				<br>
				<div class="content">
					
					
					
					
					
					
					Тут текст статьи
					Тут текст статьи
					Тут текст статьи
					Тут текст статьи
					Тут текст статьи
					Тут текст статьи

					Тут текст статьи
					Тут текст статьи
				</div>
				<br>
				<div class="chapter">
					<div class="prev"><a class="chapter" href="#">&laquo; предыдущая</a></div>
					<div class="next"><a class="chapter" href="#">следующая &raquo;</a></div>
				</div>
			</div>
			<div style="clear:both;"></div>
		</div>
	</div>
	<div id="rightcolumn">
		<div class="right" style="margin-top: 10px;">
			<div id="searchSection">
				<h2>Поискать на нашем сайте:</h2>
				<div id="googleSearch">
					<div class="gcse-search">
						<input placeholder="поискать..."/>
					</div>
				</div>
			</div>
		</div>
		<div class="right">
			<h2>Виджит</h2>
			<a target="_blank" rel="nofollow" href="#">ссылка</a>
		</div>
	</div>

	<div class="footer">
		<br>
		<table id="bottomlinks">
			<tr>
				<td style="vertical-align:top;">
					<h3>Top 10 чего-то</h3>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
				</td>
				<td style="vertical-align:top;">
					<h3>Top 10 чего-то</h3>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
				</td>
				<td style="vertical-align:top;">
					<h3>Top 10 чего-то</h3>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a>
				</td>
				<td style="vertical-align:top;">
					<h3>Top 10 чего-то</h3>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
					<a href="#"><span class="bottomlinksraquo">&raquo;</span>ссылка на статью</a><br>
				</td>
				<td style="vertical-align:top;">
					<h3>Какой-то блок</h3>
					<a href="#">
					<!--	<img src="/images/colorpicker.gif" alt="colorpicker" style="width:80px;height:68px;"> -->
					</a>
				</td>
			</tr>
		</table>
	</div>
	<hr style="height:5px;">

	<div class="footer">
		<div id="footerImg"><a href="#"></a>
		</div>
		<div id="footerAbout">
			<a href="#" style="word-spacing:normal;">ссылка 1</a> |
			<a href="#">ссылка 1</a> |
			<a href="#">ссылка 1</a> |
			<a href="#">ссылка 1</a> |
			<a href="#">ссылка 1</a> |
			<a href="#">ссылка 1</a> |
			<a href="#" style="word-spacing:normal;">ссылка 1</a>
		</div>
		<div id="footerText">
			Какой-то текст тут 
			<!--<a href="/about/about_copyright.asp">terms of use</a>,
	 		<a href="/about/about_privacy.asp">cookie and privacy policy</a>. -->
			<a href="/about/about_copyright.asp">Copyright 2014</a> by KaVaBUnGO. All Rights Reserved.<br><br>
		</div>
	</div>

</body>
</html>
