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
		<iframe src="https://www.google.com/maps/embed/v1/place?key=${googleAPIKey}&q=${latitude}%2C${longitude}"></iframe>
	</div>
	<div class="row">
		<div class="col-md-6">
		<a href="/ParkingLotList" class="btn btn-danger btn-lg btn-block" > Back </a>
		</div>
		<div class="col-md-6">
		<a href="/Reservation?lotID=${lotID}" class="btn btn-success btn-lg btn-block" > Next </a>
		</div>
	</div>
</div>
</body>
</html>