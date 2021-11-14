<%--
  Created by IntelliJ IDEA.
  User: duynguyen
  Date: 14/11/2021
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<fieldset style="width: 25%">
    <legend>Edit Product</legend>
    <form method="post">
        <table>
            <tr><td> Name: </td>
                <td>
                    <input type="text" name="name" value="${bookEdit.getName()}">
                </td>
            </tr>
            <tr><td>Description:  </td>
                <td>
                    <input type="text" name="description" value="${bookEdit.getDescription()}">
                </td>
            </tr>
            <tr> <td>Producer: </td>
                <td>
                    <input type="text" name="producer" value="${bookEdit.getProducer()}">
                </td>
            </tr>
            <tr> <td>Price:  </td>
                <td>
                    <input type="number" name="price" value="${bookEdit.getPrice()}">
                </td>
            </tr>
            <tr> <td>Category:  </td>
                <td>
                    <select name="idCategory">
                        <c:forEach items="${category}" var="cate">
                            <option value="${cate.getId()}">${cate.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <button type="submit">Submit</button>
        <button type="reset">Clear</button>
    </form>
    <a href="/books">Home page</a>
</fieldset>
</body>
</html>
