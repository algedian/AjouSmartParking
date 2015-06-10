<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="jquery-1.11.3.min.js"></script>
	<script src="bootstrap.min.js"></script>
	<link rel="stylesheet" href="bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Smart Parking</title>
</head>

<body>

<div class="container-fluid">	
	<div class="row">
		<div class="col-md-10">
			<div class="jumbotron">
				<form action="Join" method="post">
				  <div class="form-group">
				    <label for="nameInput">Name</label>
				    <input type="text" class="form-control" id="nameInput" name="name" placeholder="Enter name">
				  </div>
				  <div class="form-group">
				    <label for="phoneNumInput">Phone Number</label>
				    <input type="tel" class="form-control" id="phoneNumInput" name="userID" value="${phoneNum}" disabled>
				  </div>
				  <div class="form-group">
				    <label for="paymentInput">결재정보 나중에</label>
				    <input type="text" class="form-control" id="paymaneInput" placeholder="paymentInput">
				  </div>
				  <input type="submit" value="Join" class="btn btn-primary btn-lg btn-block" >
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>