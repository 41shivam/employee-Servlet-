<body>
	<form name ="f1" action="/employee(Servlet)/LoginServlet" method="post" onSubmit="return validate1()">
		username<input type="text" name="username"><br>
		password<input type="password" name="password"><br>
		<input type="submit" value="Login"/><br>
	</form>
	New User <a href="register.jsp">Register</a>
	<script>
		function validate1() {
			let x1= document.f1.username.value;
			let x2= document.f1.password.value;
			if (x1 == null || x1 == " ") {
				alert("username should not be empty");
				return false;
			}
			if(x2 == null || x2 == " ") {
				alert("password should not be empty");
				return false
			}
			return true;
		}
	</script>
</body>