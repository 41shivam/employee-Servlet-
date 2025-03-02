<body>
	<form name="f2" action="/employee(Servlet)/RegisterServlet" method="post" onSubmit="return validate2()">
	Name<input type="text" name="name"/><br>
	username<input type="text" name="username"><br>
	password<input type="password" name="password"><br>
	Retype Password<input type="password" name="repassword"><br>
	 <input type="submit" value="Register">
	</form>
	<script >
		function validate2() {
			let x1 = document.f2.name.value;
			let x2 = document.f2.username.value;
			let x3 = document.f2.password.value;
			let x4 = document.f2.repassword.value;

			if(x1 == null || x1 == " ") {
				alert("Name should not be empty");
				return false;
			}
			if(x2 == null || x2 == " ") {
				alert("username should not be empty");
				return false;
			}
			if(x3 == null || x3 == " ") {
				alert("password should not be empty");
				return false;
			}
			if(x3 != x4) {
				alert("password and retype should match");
				return false;
			}
			
			return true;
		}
	</script>
</body>
