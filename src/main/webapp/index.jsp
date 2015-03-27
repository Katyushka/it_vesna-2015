<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page import="ru.tutorialsworld.models.CategoryModel" %>
<%@ page import="ru.tutorialsworld.models.entities.Category" %>

<%
	CategoryModel categoryModel = new CategoryModel();
	List<Category> topLevelCategories = categoryModel.getTopLevelCategories();
%>

<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>My First HTML</title>
  <link rel="stylesheet" type="text/css" href="css/styles.css"  />
</head>
<body>
<div id="top">
	<div id='topLogo'>
			<a href='/'><h2>TutorialsWorld.ru</h2></a>
		</div>
	<div id="searchSection">
		<div style="font-size:12px;font-style:italic;">Поискать на нашем сайте:</div>
		<div class="gcse-search">
			<input placeholder="поискать"></input>
		</div>
	</div>
</div>


<div id="page">
	<div id="leftcol">
		<% for(Category topLevelCategory : topLevelCategories) { %>
		<h3 style="margin-top:0px;"><%=topLevelCategory.getFullName()%></h3>
		<% 
		List<Category> subcategories = categoryModel.getSubcategories(topLevelCategory);
		for (Category subcategory : subcategories) { %>
		<a href="article?id=<%=subcategory.getId() %>" target="_top"><%=subcategory.getName() %></a><br>
		<% } %>				
		<% } %>
	</div>
	<div id="maincol">
		<div class="box1">
			<div class="tutlogo">
				<a class="box" href="#" target="_top">
					<div class="image" style="background-color:#87C71D;"></div>
					<h1>Java</h1>
				</a>
			</div>
			<div class="tutbuttons">
				<a class="btn" href="#" target="_top">Java Tutorial</a>
				<a class="btn" href="#" target="_top">Java Quizzes</a>
			</div>
		</div>
		<div class="box1">
			<div class="tutlogo">
				<a class="box" href="№" target="_top">		
					<div class="image" style="background-color:#07B3D3;"></div>
					<h1>SQL</h1>
				</a>
			</div>
			<div class="tutbuttons">
				<a class="btn" href="#" target="_top">SQL Tutorial</a>
				<a class="btn" href="#" target="_top">SQL Quizzes</a>			
			</div>
		</div>
		<div class="box1">
			<div class="tutlogo">
				<a class="box" href="#" target="_top">		
					<div class="image" style="background-color:#555555;"></div>
					<h1>JavaScript</h1>
				</a>
			</div>
			<div class="tutbuttons">
				<a class="btn" href="#" target="_top">JavaScript Tutorial</a>
				<a class="btn" href="#" target="_top">JavaScript Quizzes</a>			
			</div>
		</div>		
		<div class="box1">
			<div class="tutlogo">
				<a class="box" href="#" target="_top">		
					<div class="image" style="background-color:#FF9900;"></div>
					<h1>HTML5</h1>
				</a>
			</div>
			<div class="tutbuttons">
				<a class="btn" href="#" target="_top">HTML5 Tutorial</a>
				<a class="btn" href="#" target="_top">HTML5 Quizzes</a>			
			</div>
		</div>
		<div class="box1">
			<div class="tutlogo">
				<a class="box" href="#" target="_top">		
					<div class="image" style="background-color:#41BC81;"></div>
					<h1>CSS</h1>
				</a>
			</div>
			<div class="tutbuttons">
				<a class="btn" href="#" target="_top">CSS Tutorial</a>
				<a class="btn" href="#" target="_top">CSS Quizzes</a>			
			</div>
		</div>
		<div class="box1">
			<div class="tutlogo">
				<a class="box" href="#" target="_top">		
					<div class="image" style="background-color:#6A8CE9;"></div>
					<h1>AJAX</h1>
				</a>
			</div>
			<div class="tutbuttons">
				<a class="btn" href="#" target="_top">AJAX Tutorial</a>
				<a class="btn" href="#" target="_top">AJAX Quizzes</a>			
			</div>
		</div>
		<div style="clear:both;"></div>

	</div>
	<div style="clear:both;"></div>
</div>
	<div id="bottomContainer">

	</div>
</body>
</html>
