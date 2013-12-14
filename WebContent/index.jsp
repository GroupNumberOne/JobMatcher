<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Title</title>
	</head>
	<body>
		<H2>Test code</H2>
		<UL>
			<LI>Current time: <%= new java.util.Date() %>
			<LI>Server: <%= application.getServerInfo() %>
			<LI>Session ID: <%= session.getId() %>
			<%! private int accessCount = 0; %>
			<LI>Webpagina aantal keer bekeken: <%= ++accessCount %>
		</UL>
		
		<br /><br /><br />
		<form name="Form" method="post" action="MainServlet">
		    Column: <input type="text" name="box1"/>
		    Table: <input type="text" name="box2"/> <br/><br/>
		    Match met woord: <input type="text" name="box3"/> 
		    <input type="submit" value="Continue" />
		</form>
	</body>
</html>