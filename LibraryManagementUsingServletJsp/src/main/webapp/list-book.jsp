<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page
import="com.techdenovo.papps.model.Book" %> 
<td%@page
import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Library Management | Servlet &amp; JSP</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
  </head>

  <body>
    <div class="container">
      <table class="table caption-top">
        <caption>
          List of books
        </caption>
        <thead>
          <tr class="table-primary">
            <th scope="col">ID no.</th>
            <th scope="col">Title</th>
            <th scope="col">Author</th>
            <th scope="col">ISBN No.</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="book" items="${Books}">
            <tr>
              <td><c:out value="${book.getId()}" /></td>
              <td><c:out value="${book.getBookName()}" /></td>
              <td><c:out value="${book.getAuthorName()}" /></td>
              <td><c:out value="${book.getIsbn()}" /></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>