<%--
  Created by IntelliJ IDEA.
  User: Velles
  Date: 28.08.2023
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <label><b>Login</b></label>
        <br>
        <form action="/login" method="post">
            <label>Login: </label>
            <input name="login">
            <br>
            <label>Password: </label>
            <input name="password">
            <br>
            <input type="submit">
        </form>
    </body>
</html>
