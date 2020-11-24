<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>survey_ques3</title>
</head>
<body>
<%
String q2=request.getParameter("q2");    
  
session.setAttribute("q2",q2);   


%>
<form action="final.jsp">
<h1>Question 3</h1>
<h2>Question 3?</h2>
<input type="radio" name="q3" value="a3">
<label>a3</label><br>
<input type="radio" name="q3" value="b3">
<label>b3</label><br>
<input type="radio" name="q3" value="c3">
<label>c3</label><br>
<input type="radio" name="q3" value="d3">
<label>d3</label><br>
<br>
<input type="submit" value="next">
</form>
<a href="question2.jsp"><button>back</button></a>



</body>
</html>