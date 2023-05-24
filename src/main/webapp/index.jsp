<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style type="text/css">
        .login {
            height: 230px;
            width: 300px;
            margin: auto;
            padding: 10px;
            border: 1px #CCC solid;

        }

        .login input {
            padding: 5px;
            margin: 5px;
            border-radius: 3px;
        }
        h1{
            text-align: center;
        }
    </style>

</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="/LoginServlet" method="get">
    <div class="login">
        <h2>Login</h2>
        <input type="text" name="username" size="15" placeholder="username"/>
        <input type="password" name="password" size="15" placeholder="password"/>
        <br>
        <input type="submit" value="Sign in"/>
    </div>
</form>
</body>
</html>