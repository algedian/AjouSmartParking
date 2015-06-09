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
			<form>
			  <div class="form-group">
			    <label for="exampleInputEmail1">ID</label>
			    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter ID">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Password</label>
			    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
			  </div>
			  <p><%=link_to "Login",  welcome_select_path, class: "btn btn-primary btn-lg btn-block"%></p>
			</form>
		</div>
	</div>
</div>



</body>
</html>