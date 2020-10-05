<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<%@ page import="com.m2i.helloworld.entities.*" %>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
		
	<h1>Main</h1>
	
	
	Hello <%out.print(session.getAttribute("userNameSession"));%>
	
	<table class="table">
		<thead>
			<tr>
				<th>#</th>
				<th>login</th>
				<th>name</th>
				<th>firstname</th>
			</tr>
		</thead>
		<tbody>
			
				
				<%
					List<User> l = (List<User>)session.getAttribute("users");
					for (User u:l){ 
				%>
				<tr>		
					<td><%=u.getId() %></td>
					<td><%=u.getUserName() %></td>
					<td><%=u.getName() %></td>
					<td><%=u.getFirstName() %></td>
				</tr>		
				<% } %>
		
			
		</tbody>
	</table>
	
			
</body>
</html>