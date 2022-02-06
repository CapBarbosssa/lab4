<%-- 
    Document   : login
    Created on : Feb. 2, 2022, 12:42:52 p.m.
    Author     : peony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
     
     
        <form action="login" method="post">
            <p>
            <label for="username"> User name:</label>
            <input type="text" name="username" id="username" >
            </p>
            <p>
            <label for="password"> Password:</label>
            <input type="password" name="password" id="password" >
            </p>
            <button type="submit">Login</button>
            
        </form>
        <p>${message}</p>
    </body>
</html>
