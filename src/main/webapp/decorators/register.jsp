<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title><dec:title default="Đăng ký" /></title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<style type="text/css">
		body{
			background-color: #17a2b8;
		}
		.container{
			margin-top:4%;
			border: 1px solid #9C9C9C;
		  	background-color: #EAEAEA;
			max-width: 600px;
			border-radius: 10px;
			position: absolute;
			top: 50%;
			left: 50%;
			border: 1px solid #9C9C9C;
			transform: translate(-50%,-50%);
			height: 115%;
			padding: 20px 40px 0;
		}
		.container h2{
			margin-top: 16px;
		}
		.container .btn-success{
			margin-top: 16px;
			margin-bottom: 16px;
		}
	</style>

</head>

<body>
		<dec:body/>
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</body>

</html>