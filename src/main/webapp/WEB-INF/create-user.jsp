<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 09.01.2022
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new User</title>
</head>
<body>
<form action="/createUserServlet" method="post">
    <table>
        <tr>
            <td>
                <label for="name">Username : </label>
            </td>
            <td>
                <input type="text" id="name" name="name">
            </td>
        </tr>
        <tr>
            <td>
                <label for="email">Email : </label>
            </td>
            <td>
                <input type="text" id="email" name="email">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create">
            </td>
            <td>
                <input type="reset" value="Clear">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
