<%@ page import="ua.lviv.lgs.lesson4.servlet.Attribute" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>Register</title>

        <link href="css/login.css" rel="stylesheet">
    </head>
    <body>
        <div class="loginmodal-container">
            <h1>Register a new account</h1><br>
            <form action="./register" method="post">
                <input type="text" name="fistName" placeholder="First name">
                <input type="text" name="lastName" placeholder="Last name">
                <input type="text" name="email" placeholder="Email">
                <input type="password" name="pass" placeholder="Password">

                <input type="submit" name="login" class="login loginmodal-submit" value="Register">
            </form>
            <% if (request.getAttribute(Attribute.REQUEST_REGISTRATION_ERROR.getValue()) != null) { %>
            <div class="login-help">
                <p style="color: red"><%= request.getAttribute(Attribute.REQUEST_REGISTRATION_ERROR.getValue()) %></p>
            </div>
            <% } %>
            <div class="login-help">
                <a href="./login">Login</a></a>
            </div>
        </div>
    </body>
</html>
