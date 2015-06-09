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
<div class="list-group">
	<li class="list-group-item"></li>
	Lavida Parking Tower<span class="pull-right">1km away</span>
	<% end %>
	<%=link_to welcome_reservation_path, class: "list-group-item" do%>
	Ruby Parking Lot<span class="pull-right">1.4km away</span>
	<% end %>
	<%=link_to welcome_reservation_path, class: "list-group-item" do%>
	Raspberry Parking<span class="pull-right">5km away</span>
	<% end %>
	<%=link_to welcome_reservation_path, class: "list-group-item" do%>
	Donghae Parking Tower<span class="pull-right">17km away</span>
	<% end %>
	<%=link_to welcome_reservation_path, class: "list-group-item" do%>
	Suwon Parking Centerr<span class="pull-right">30km away</span>
	<% end %>
</div>
</div>
</div>

</body>
</html>