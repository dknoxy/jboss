<%@ page info="Login Test using JAAS" %>

<html>
	<head><title>Login</title></head>
	<body bgcolor="#ffffff" background="images/nature-wallpaper-75.jpg">

		<form method="POST" action="j_security_check">
			User: <input type="text" name="j_username"/>
			Password: <input type="password" name="j_password"/>
			<input type="submit" value="Submit"/>
		</form>
	
	</body>
</html>
