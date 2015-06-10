<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.ArrayList" %>
<%@page import="smartparking.ParkingLot" %>
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
		<div class="panel panel-default">
		  <div class="panel-body">
		    <ul class="list-group">
		    <% 
			ArrayList<ParkingLot> lotList = new ArrayList<ParkingLot>();
			lotList = (ArrayList<ParkingLot>)request.getAttribute("lotList");
			
			for(int i=0 ; i<lotList.size() ; i++){
			%>
			<li class="list-group-item"><a href="LotDetail?lotID=<%=lotList.get(i).getLotID()%>" >
			<%=lotList.get(i).getName() %> 
			<span class="pull-right"><%=lotList.get(i).getDistance()%>m</span></a></li>
			
			<%
			}
			%>
			</ul>
		  </div>
		</div>
	</div>
</div>
</body>
</html>