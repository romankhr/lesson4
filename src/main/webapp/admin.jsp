<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="css/login.css" rel="stylesheet">
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Admin</title>
        <link href="css/login.css" rel="stylesheet">
    </head>
    <body>
    <div class="logOut" align="right">
        <form action="./logOut" method="post">
            <input type="submit" name="logOut"  value="Log out">
        </form>
    </div>


    <h1>Admin page</h1>
    <br>
    <h2>The list of journals</h2>
    <br>
    <table border="1" cellpadding="2" cellspacing="2">
            <tr>
                <th>name</th>
                <th>publication</th>
                <th>year</th>
                <th>month</th>
                <th>price</th>
            </tr>
            <c:forEach items="${journals}" var="journal">
                <tr>
                    <td bgcolor="aqua">${journal.name}</td>
                    <td>${journal.publication}</td>
                    <td>${journal.year}</td>
                    <td align="center">${journal.month}</td>
                    <td align="center" bgcolor="#7fff00"><p>${journal.price}</p></td>
                    <td>
                    <form action="./removeJournal" method="post">
                    <input type="submit" name="delete"  value="Delete"><input type="hidden" name="id"  value="${journal.name}">
                    </form>
                    </td>
                </tr>
            </c:forEach>
        </table>


    <div class="add-container">
        <h2>Add a new journal</h2><br>
        <form action="./add" method="post">
            <input type="text" name="name" placeholder="Name of Journal">
            <input type="text" name="publication" placeholder="Publication of Journal">
            <input type="text" name="year" placeholder="year">
            <input type="text" name="month" placeholder="month">
            <input type="text" name="price" placeholder="price">
            <input type="submit" name="NewJournal" value="Add Journal">
        </form>
    </div>
    </body>
</html>