<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="bootstrap.min.js"></script>
<link rel="stylesheet" href="bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Smart Parking</title>
</head>
<body>


<div class="row">
	<div class="col-md-10">
	<div class="jumbotron">
	  <h1>Parking Helper</h1>
	  <p>help parking</p>

	  <p><%=link_to "Login",  welcome_login_path, class: "btn btn-primary btn-lg btn-block"%></p>
	  <p><%=link_to "Sign up", welcome_signup_path, class: "btn btn-default btn-lg btn-block"%></p>
	</div>
	</div>
</div>

</body>
</html>