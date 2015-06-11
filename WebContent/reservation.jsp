<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.*" %>
<%@ page import="smartparking.DB" %>
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
<div>

<div class="container-fluid" style="position: relative; height: 50%; margin: 2.5% 0 2.5% 0;">
	<div class="row" style="height: 100%;">
		<div class="col-xs-12" style="height: 100%;">
			<iframe width="100%" src="https://www.google.com/maps/embed/v1/directions?key=AIzaSyB4RKax8jdIYM7__cAMShZWDp3B9GZDiiQ&origin=${latitude}%2C${longitude}&destination=${lotLatitude}%2C${lotLongitude}&mode=driving"></iframe>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row">
	<div class="col-xs-12">
		<h2 class="text-center">${authInfo.authKey}</h2>
		<h4 class="text-center">${expireTime}<small>까지</small></h4>
	</div>		
	</div>
	<div class="row">
		<div class="col-xs-12">
		<a href="CancelReservation" class="btn btn-danger btn-lg btn-block" > Cancel </a>
		</div>
	</div>
</div>

</div>
</body>
</html>