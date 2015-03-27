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
		<a href="article?id=<%=subcategory.getName() %>" target="_top"><%=subcategory.getName() %></a><br>
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
				<a class="btn" href="#" target="_top">Java  Tutorial</a>
				<a class="btn" href="#" target="_top">Java остальное</a>
			</div>
		</div>
		<div class="box1">
			<div class="tutlogo">
				<a class="box" href="№" target="_top">		
					<div class="image" style="background-color:#07B3D3;"></div>
					<h1>Кат 1</h1>
				</a>
			</div>
			<div class="tutbuttons">
				<a class="btn" href="css/default.asp" target="_top">текст</a>
				<a class="btn" href="cssref/default.asp" target="_top">текст</a>			
			</div>
		</div>
		<div class="box1">
			<div class="tutlogo">
				<a class="box" href="js/default.asp" target="_top">		
					<div class="image" style="background-color:#555555;"></div>
					<h1>Кат 1</h1>
				</a>
			</div>
			<div class="tutbuttons">
				<a class="btn" href="js/default.asp" target="_top">текст</a>
				<a class="btn" href="jsref/default.asp" target="_top">текст</a>			
			</div>
		</div>		
		<div class="box1">
			<div class="tutlogo">
				<a class="box" href="sql/default.asp" target="_top">		
					<div class="image" style="background-color:#FF9900;"></div>
					<h1>Кат 1</h1>
				</a>
			</div>
			<div class="tutbuttons">
				<a class="btn" href="sql/default.asp" target="_top">текст</a>
				<a class="btn" href="sql/sql_quickref.asp" target="_top">текст</a>			
			</div>
		</div>
		<div class="box1">
			<div class="tutlogo">
				<a class="box" href="php/default.asp" target="_top">		
					<div class="image" style="background-color:#41BC81;"></div>
					<h1>Кат 1</h1>
				</a>
			</div>
			<div class="tutbuttons">
				<a class="btn" href="php/default.asp" target="_top">текст</a>
				<a class="btn" href="php/php_ref_array.asp" target="_top">текст</a>			
			</div>
		</div>
		<div class="box1">
			<div class="tutlogo">
				<a class="box" href="jquery/default.asp" target="_top">		
					<div class="image" style="background-color:#6A8CE9;"></div>
					<h1>Кат 1</h1>
				</a>
			</div>
			<div class="tutbuttons">
				<a class="btn" href="jquery/default.asp" target="_top">текст</a>
				<a class="btn" href="jquery/jquery_ref_selectors.asp" target="_top">текст</a>			
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
