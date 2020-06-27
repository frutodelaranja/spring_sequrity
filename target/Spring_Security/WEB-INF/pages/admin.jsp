<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<html>
<head>
    <title>Admin</title>
    <style>
        table {
            width: 50%;
        }

        table, th, td {
            border: 2px solid MediumSlateBlue;
            border-collapse: collapse;
        }

        th, td {
            padding: 15px;
            text-align: left;
        }

        table#t01 tr:nth-child(even) {
            background-color: #eee;
            color: SaddleBrown;
        }

        table#t01 tr:nth-child(odd) {
            background-color: #fff;
            color: SaddleBrown;
        }

        table#t01 th {
            background-color: MediumSlateBlue;
            color: white;
        }
    </style>
</head>
<body>

<table id="t01">
    <tr>
        <th>User</th>
        <th>ID</th>
        <th>Name</th>
        <th>Login</th>
        <th>Pass</th>
        <th>Portal</th>
        <th>Portal</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
                <c:forEach var="role" items="${user.roles}">
                <c:out value="${role.name}"/>
                </c:forEach>
            </td>
            <td>
                <c:out value="${user.id}"/>
            </td>
            <td>
                <c:out value="${user.name}"/>
            </td>
            <td>
                <c:out value="${user.username}"/>
            </td>
            <td>
                <c:out value="${user.password}"/>
            </td>
            <td>
                <form action="edit" method="get">
                    <button type="submit" onclick=input name="id" value="${user.id}" >EDIT</button>
                </form>
            </td>
            <td>
                <form action="delete" method="get">
                    <button type="submit" onclick=input name="id" value="${user.id}" >DELETE</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>


<form:form modelAttribute="newUser" action="save" method="post">
    <p><form:hidden path="id" placeholder="ID" /></p>
    <p><form:input path="name" placeholder="Name" /></p>
    <p><form:input path="username" placeholder="Login" /></p>
    <p><form:input path="password" placeholder="Password"/></p>
    <div>
        <button>Save</button>
    </div>

</form:form>
<div class="w3-container w3-center">
    <div class="w3-bar w3-padding-large w3-padding-24">
        <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='logout'">Logout <i
                class='fa fa-home'></i></button>
    </div>
</div>
</body>
</html>
