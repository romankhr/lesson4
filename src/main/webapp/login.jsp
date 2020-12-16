<%@ page import="ua.lviv.lgs.lesson4.servlet.Attribute" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Login</title>
        <link href="css/login.css" rel="stylesheet">
    </head>
    <body>

        <div class="loginmodal-container">
            <h1>Login to Your Account</h1><br>
            <form action="./login" method="post">
                <input type="text" name="email" placeholder="Email">
                <input type="password" name="pass" placeholder="Password">

                <input type="submit" name="login" class="login loginmodal-submit" value="Login">
            </form>
            <% if (request.getAttribute(Attribute.REQUEST_LOGIN_ERROR.getValue()) != null) { %>
            <div class="login-help">
                <p style="color: red"><%= request.getAttribute(Attribute.REQUEST_LOGIN_ERROR.getValue()) %></p>
            </div>
            <% } %>
            <div class="login-help">
                <a href="./register">Register</a></a>
            </div>
            <div class="login-help">
                <a href="./visitor">Visitor</a></a>
            </div>
        </div>
    </body>
</html>