<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>survey_final</title>
</head>
<body>
<%
String q=request.getParameter("q3");    
  
session.setAttribute("q3",q);   


%>
<h2>question 1?</h2>
<h3>Answer - a1</h3>
<h2>question 2?</h2>
<h3>Answer - b2</h3>
<h2>question 3?</h2>
<h3>Answer - d3</h3>

<% 
int i=0;
String q1=(String)session.getAttribute("q1");  
out.println("question 1 selected option "+q1);
if(q1.equals("a1"))
{
	out.println("question 1 correct ");
	i=i+1;
}
else
{
	out.println("question 1 wrong ");
}
%>
<br>
<%
String q2=(String)session.getAttribute("q2");  
out.println("question 2 selected option"+q2);
if(q2.equals("b2"))
{
	out.println("question 2 correct ");
	i=i+1;
}
else
{
	out.println("question 2 wrong ");
}


%>
<br>
<%
String q3=(String)session.getAttribute("q3");  
out.println("question 3 selected option "+q3);
if(q.equals("d3"))
{
	out.println("question 3 correct ");
	i=i+1;
}
else
{
	out.println("question 3 wrong ");
}

out.println("Score = "+i+"/3");

%>
<br>
<a href="storedb.jsp"><button>OK</button></a>
<a href="index.jsp"><button>Cancel</button></a>

</body>
</html>
