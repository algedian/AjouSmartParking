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

<div class="panel panel-default">
  <div class="panel-body">
  	<h4>Your auth key is</h4>
	<h1 class="text-center">2519</h1>
		<br>
		<p>
		<button type="button" class="btn btn-danger btn-lg btn-block" data-toggle="modal" data-target=".bs-example-modal-sm">Cancel</button>

		<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-sm">
		    <div class="modal-content">
		    	<div class="modal-header">
		        <h4 class="modal-title">Reservation Cancel</h4>
			      </div>
			      <div class="modal-body">
        <p>Really Cancel?</p>
      </div>
		    	<div class="modal-footer">	
		      <%=link_to "OK", welcome_index_path, class: "btn btn-danger btn-lg btn-block" %>
		      <button type="button" class="btn btn-primary btn-lg btn-block" data-dismiss="modal">Close</button>
		  </div>
		    </div>
		  </div>
		</div>
	</p>
	<p>
		<%=link_to "Back to Main", welcome_index_path, class: "btn btn-primary btn-lg btn-block" %>
	</p>
  </div>
</div>
</div>
</div>

</body>
</html>