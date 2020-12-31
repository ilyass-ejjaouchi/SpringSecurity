<!DOCTYPE html>
<%@ taglib prefix="sec" uri = "http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<center>
    <h1>Welcome to ENSA Spring Boot Security</h1>
    <h2>Login Page</h2>
    <form method="POST" action="/login">
        User Name : <input type="text" name="username" value="user"/><br><br>
        Password : <input type="password" name="password"
                          value="password"/><br><br>
        <input type="submit" name="submit"/>
        <sec:csrfInput />
    </form>
</center>
</body>
</html>