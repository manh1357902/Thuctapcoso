<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title><dec:title default="Trang chủ" /></title>
	<link rel="stylesheet" href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css' />" />
	<link rel="stylesheet" href="<c:url value='/template/admin/css/sb-admin-2.min.css' />" />
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.min.css' />" />
   	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="<c:url value='/template/admin/css/sweetalert2.min.css' />" />
    	<script src="<c:url value='/template/admin/js/sweetalert2.min.js' />"></script>
</head>
<body id="page-top">
	<div id="wrapper">
		<!-- menu -->
	    <%@ include file="/common/admin/menu.jsp" %>
	    <!-- header -->
	    <div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
		    	<%@ include file="/common/admin/header.jsp" %>
				<dec:body/>
		</div>
		
	</div>
    	
	</div>	
	
	<!-- page specific plugin scripts -->
	<script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
	<script src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>
	<script src="<c:url value='/template/admin/js/sb-admin-2.min.js'/>"></script>
	<script src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	<script src="<c:url value='/template/admin/vendor/datatables/jquery.dataTables.min.js'/>"></script>
	<script src="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.min.js'/>"></script>
	<script src="<c:url value='/template/admin/js/demo/datatables-demo.js'/>"></script>

</body>
</html>