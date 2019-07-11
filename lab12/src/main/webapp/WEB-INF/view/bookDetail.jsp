<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${msg} a Book</title>
</head>

<body>
<c:if test="${msg == 'Update'}">
    <form:form modelAttribute="book" action="../books/${book.id}" method="post">
</c:if>
<c:if test="${msg == 'Add'}">
    <form:form modelAttribute="book" action="../books" method="post">
</c:if>
<form:errors path="*" cssClass="errorblock" element="div" />
<table>
    <tr>
        <td>Title:</td>
        <td><form:input path="title"/></td>
    </tr>
    <tr>
        <td>ISBN:</td>
        <td><form:input path="ISBN" /></td>
    </tr>
    <tr>
        <td>Author:</td>
        <td><form:input path="author"/></td>
    </tr>
    <tr>
        <td>Price:</td>
        <td><form:input path="price"/></td>
    </tr>
</table>
<input type="submit"/>
</form:form>
<c:if test="${msg == 'Update'}">
    <form:form action="delete?bookId=${book.id}" method="post">
        <button type="submit">Delete</button>
    </form:form>
</c:if>
</body>

</html>