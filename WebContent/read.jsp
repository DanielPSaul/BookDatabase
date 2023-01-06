<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%
    String table = (String) request.getAttribute("table");
%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>The UGA Science Fiction Library</title>
<link rel='stylesheet' type="text/css" href='styles.css'>
</head>
<body>

<h1>UGA Sci Fi Library</h1>

<a class="button1" href="addForm.jsp">Add a book</a>

<br>

<p>Click the author's name to view their other books in the database!</p>
<p>Click on the buttons below to view the books filtered by star rating!</p>		


		<div class="filter">		
        <ul>
            <li><a href="star?bookRating=1">1 Star</a></li>
            <li><a href="star?bookRating=2">2 Star</a></li>
            <li><a href="star?bookRating=3">3 Star</a></li>
            <li><a href="star?bookRating=4">4 Star</a></li>
            <li><a href="star?bookRating=5">5 Star</a></li>
            <li><a href="read">See All Books</a></li> 
        </ul>

		</div>

<div class="table">
<%= table %>
</div>

<br>

<footer><p>Developed by Daniel Saul | Copyright 2021</p></footer>
</body>
</html>