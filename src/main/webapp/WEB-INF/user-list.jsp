<%@ page import="org.softserveacademy.model.User" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        All Users
    </title>
</head>
<body>
<table border="2">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th colspan="3">Operations</th>
    </tr>

    <%
        for (User user : (List<User>)request.getAttribute("user")){
    %>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getName()%></td>
        <td><%=user.getEmail()%></td>
        <td>
            <a href="/retrieveUserServlet?id=<%=user.getId()%>">Read</a>
        </td>
        <td>
            <a href="/updateUserServlet?id=<%=user.getId()%>">Update</a>
        </td>
        <td>
            <a href="/deleteUserServlet?id=<%=user.getId()%>">Delete</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
