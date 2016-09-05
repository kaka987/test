<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<form method="POST" action="/test/doLogin" >
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ">

            <input name="username" type="text" class="form-control" placeholder="Username" />
            <input name="password" type="password" class="form-control" placeholder="Password" />

            <input type="submit" value="submit" />
            
        </div>

    </form>
</body>
</html>