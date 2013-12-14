<%@page import="webapp.java.Executer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	
	<% 
	String bgColor = request.getParameter("bgColor");
	if ((bgColor == null) || (bgColor.trim().equals(""))) { 
	 bgColor = "GRAY"; 
	} 
	%>
	<BODY BGCOLOR="<%= bgColor %>">
	</head>
	<body>
		<H2>Test code</H2>
		<UL>
			<LI>Current time: <%= new java.util.Date() %>
			<LI>Server: <%= application.getServerInfo() %>
			<LI>Session ID: <%= session.getId() %>
			<%! private int accessCount = 0; %>
			<H2>Webpagina aantal keer bekeken: 
			<%= ++accessCount %></H2>
		</UL>
		
		<input type="button" value="Button" class="btn" id="DeleteBtn" onclick=alert("hoi")></input> <br />
		<input type="button" value="Naar Overzicht" class="btn" id="DeleteBtn" onclick="location.href='MainServlet';"></input>
		Geen GET dus zal niet werken 
		
		<br /><br /><br />
		<form name="Form" method="post" action="MainServlet">
		    Username: <input type="text" name="username"/> <br/>
		    Password: <input type="password" name="password"/> <br/>
		    <input type="submit" value="Login" />
		</form>
	</body>
</html>