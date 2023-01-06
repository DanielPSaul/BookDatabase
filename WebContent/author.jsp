<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%@ page import="model.Book" %>
    
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

<a class="button1" href="read">Return to page</a>

<div class="table">
<%= table %>
</div>

<footer><p>Developed by Daniel Saul | Copyright 2021</p></footer>
</body>
</html>