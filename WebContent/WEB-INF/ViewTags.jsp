<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-Type" content = "text/html; charset = ISO-8859-1">
<title>View Tags</title>
</head>
<body>
<table>
<tr><th> Tag name: </th><th>Tag Name: </th></tr>
 <c:forEach var = "tag" items = "${tags}">
 <tr><td>${tag.tags_name}</td><td>${tag.isbn_13}</td></tr>
 </c:forEach>



</table>
<hr/>
<h4> Use the form below to  add a new tag</h4>
<form method = "post">
Tag: <input type = "text"  name = "tag_name" />
isbn_13: <input type = "text" name = "isbn_13" />
<input type = "submit" value = "Add tag" />

</form>

</body>
</html>