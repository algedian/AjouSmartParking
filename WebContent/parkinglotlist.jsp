<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.ArrayList" %>
<%@page import="smartparking.ParkingLot" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="panel panel-default">
	  <div class="panel-body">
	    <% 
		ArrayList<ParkingLot> lotList = new ArrayList<ParkingLot>();
		lotList = (ArrayList<ParkingLot>)request.getAttribute("lotList");
		
		for(int i=0 ; i<lotList.size() ; i++){
		%>
		<li class="list-group-item"><a href="LotDetail.jsp?lotID=<%=lotList.get(i).getLotID()%>" >
		<%=lotList.get(i).getName() %> </a></li>
		
		<%
		}
		%>
	  </div>
	</div>
</body>
</html>