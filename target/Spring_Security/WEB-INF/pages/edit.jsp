<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>

<form:form modelAttribute="editUser" action="/edit" method="post">
    <p><form:hidden placeholder="${editUser.id}" path="id"/></p>
    <p><label>
        <input placeholder="${editUser.id}" />
    </label></p>
    <p><form:input path="name"/></p>
    <p><form:input path="username"/></p>
    <p><form:input path="password"/></p>
    <p><form:checkbox path="roles" value="ROLE_ADMIN" label="admin"/></p>
    <p><form:checkbox path="roles" value="ROLE_USER" label="user"/></p>
    <div>
        <button>Update</button>
    </div>

</form:form>
</body>
</html>
