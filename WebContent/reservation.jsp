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

<div class="container-fluid">	
	<div class="row">
		<div class="col-md-10">
			<div class="panel panel-default">
			  <div class="panel-body">
			  	<%
			  	int row = 5;
			  	int col = 4;
			  	int cnt = 0;
			  	int max;
			  	boolean done = false;
			  	ArrayList<String> spaceList = (ArrayList<String>) request.getAttribute("spaceList");
				max = spaceList.size();
			  	//RequestDispatcher rd = request.getRequestDispatcher("/reservation.jsp");
				
				for(int i=0 ; i<row ; i++){
					%>
					<div class="row">
					<%
					if(done){
						break;
					}
					for(int j=0 ; j<col ; j++){
						if(cnt==max){
							done = true;
							break;
						}
						cnt++;
						if((i+j)% 2 == 0){
							%>
							<button type="button" class="btn btn-default btn-sm"><%=spaceList.get(cnt) %></button>
							<%
						}
						else{
							%>
							<button type="button" class="btn btn-warning btn-sm"><%=spaceList.get(cnt) %></button>
							<%
						}
					}
					%>
					</div> 
					<%
				}
			  	
			  	%>
			  </div>
			</div>
		</div>
	</div>
</div>

</body>
</html>