<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>survey_ques2</title>
</head>
<body>
<%
String q1=request.getParameter("q1");    
  
session.setAttribute("q1",q1);   
String username=request.getParameter("username"); 
session.setAttribute("name",username); 


%>
<form action="question3.jsp">
<h1>Question 2</h1>
<h2>Question 2?</h2>
<input type="radio" name="q2" value="a2">
<label>a2</label><br>
<input type="radio" name="q2" value="b2">
<label>b2</label><br>
<input type="radio" name="q2" value="c2">
<label>c2</label><br>
<input type="radio" name="q2" value="d2">
<label>d2</label><br>
<br>
<input type="submit" value="next">
</form>
<a href="index.jsp"><button>back</button></a>



</body>
</html>