<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>The UGA Science Fiction Library</title>
<link rel='stylesheet' type="text/css" href='styles.css'>
</head>
<body>

<h1>UGA Sci Fi Library | Add a Book</h1>

<a class="button1" href="read">Return to page</a>

<br>

<div class="forms">
<form name=addForm action=addBook method=post >

   <label>
      Book title:
   </label>
   <input type=text name=title value="" />
   <br />
   <label>
      Book author:
   </label>
   <input type=text name=author value="" />
   <br />
   
   <label>
      Book pages:
   </label>
   <input type=text name=pages value="" />
   <br />
   
   <label>
      Rating:
   </label>
   <select id="rating" name="rating">
  	<option value="1">1</option>
  	<option value="2">2</option>
  	<option value="3">3</option>
 	<option value="4">4</option>
 	<option value="5">5</option>
</select>
   
   <br>
   
   <input type=submit class="submitButton" name=submit value="Submit" />

</form>
</div>

<footer><p>Developed by Daniel Saul | Copyright 2021</p></footer>
</body>
</html>