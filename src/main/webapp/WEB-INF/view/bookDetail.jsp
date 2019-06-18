<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update a Book</title>
        <link href="../css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <form:form modelAttribute="book" action="../books/${book.id}" method="post">
            <form:errors path="*" cssClass="error" element="div" />

            <table>
                <tr>
                    <td>Title:</td>
                    <td><form:input type="text" path="title" value="${book.title}"/> </td>
                    <td><form:errors path="title" cssClass="error" /> </td>

                </tr>
                <tr>
                    <td>ISBN:</td>
                    <td><form:input type="text" path="ISBN" value="${book.ISBN}"/> </td>
                    <td><form:errors path="ISBN" cssClass="error" /> </td>

                </tr>
                <tr>
                    <td>Author:</td>
                    <td><form:input type="text" path="author" value="${book.author}"/> </td>
                    <td><form:errors path="author" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><form:input type="text" path="price" value="${book.price}"/> </td>
                    <td><form:errors path="price" cssClass="error" /> </td>
                </tr>
            </table>
            <input type="submit"/>
        </form:form>
        <form action="delete?bookId=${book.id}" method="post">
            <button type="submit">Delete</button>
            <sec:csrfInput/>
        </form>
    </body>
</html>