<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thank you</title>
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  
     url="jdbc:mysql://localhost/test"  
     user="root"  password=""/> 
<%
String q1=(String)session.getAttribute("q1");
String q2=(String)session.getAttribute("q2");
String q3=(String)session.getAttribute("q3"); 
String name=(String)session.getAttribute("name");  

%>

<sql:update dataSource="${db}" var="count">  
INSERT INTO wpsa3q1 VALUES ('${name}','${q1}','${q2}','${q3}');  
</sql:update> 

<sql:query dataSource="${db}" var="rs">  
SELECT * from wpsa3q1;  
</sql:query>      
<table border="2" width="100%">  
<tr>  
<th>S.no</th>  
<th>q1</th>  
<th>q2</th>  
<th>q3</th>  
</tr>  
<c:forEach var="table" items="${rs.rows}">  
<tr>  
<td><c:out value="${table.name}"/></td>  
<td><c:out value="${table.q1}"/></td>  
<td><c:out value="${table.q2}"/></td>  
<td><c:out value="${table.q3}"/></td>  
</tr>  
</c:forEach>  
</table>  
     
     
     
     
<h1 style="text-align:centre"><c:out value="${'Thanks for taking survey'}"/> </h1>
<a href="index.jsp"><button>Submit another entry</button></a>
</body>
</html>