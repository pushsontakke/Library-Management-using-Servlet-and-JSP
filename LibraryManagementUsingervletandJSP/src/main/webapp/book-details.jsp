<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.techdenovo.papps.model.Book"%>
<%@page import="java.util.ArrayList"%>

<html lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Library Management | Servlet &amp; JSP</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />
</head>

<body>
	<div class="container">
		<table class="table caption-top table-bordered border-primary">
			<caption>List of books</caption>
			<%
			Book book = (Book) request.getAttribute("book");
			%>
			<tr>
				<td class="table-primary" scope="col">ID no.</td>
				<td><%=book.getId()%></td>
			</tr>
			<tr>
				<td class="table-primary" scope="col">Title</td>
				<td><%=book.getBookName()%></td>
			</tr>
			<tr>
				<td class="table-primary" scope="col">Author</td>
				<td><%=book.getAuthorName()%></td>
			</tr>
			<tr>
				<td class="table-primary" scope="col">ISBN No.</td>
				<td><%=book.getIsbn()%></td>
			</tr>
			<tr>
				<td class="table-primary" scope="col">Edition</td>
				<td>5</td>
			</tr>
			<tr>
				<td class="table-primary" scope="col">Date of Publication</td>
				<td>01-01-2000</td>
			</tr>
			<tr>
				<td class="table-primary" scope="col">Publisher</td>
				<td>Wiley Publishing, Inc.</td>
			</tr>
			<tr>
				<td class="table-primary" scope="col">Executive Editor</td>
				<td>Robert Elliott</td>
			</tr>


			<tr>
				<td class="table-primary" scope="col">Copyright</td>
				<td>� 2005 by Ivor Horton</td>
			</tr>
			
		</table>
	</div>
</body>

</html>