<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang = "vn">
<head>
	<meta charset="UTF-8">
	<title><dec:title default="Trang chủ" /></title>
	<link type = "text/css" rel= "stylesheet" href="<c:url value='/template/web/libs/bootstrap.min.css' />" />
	<link  rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
	<link type = "text/css" rel="stylesheet" href="<c:url value='/template/web/libs/jquery.bxslider.css' />" />
	<link type = "text/css" rel="stylesheet" href="<c:url value='/template/web/css/style1.css' />" />
	<link type = "text/css" rel="stylesheet" href="<c:url value='/template/web/css/cart.css' />" />
	<link type = "text/css" rel="stylesheet" href="<c:url value='/template/web/css/reset.css' />" />
	<link type = "text/css" rel="stylesheet" href="<c:url value='/template/web/css/media.css' />" />
</head>
<body>
	<%@ include file = "/common/web/header.jsp" %>
	<dec:body/>
	<%@ include file = "/common/web/footer.jsp" %>
	<script src="<c:url value ='https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'/>"></script>
	<script src="<c:url value ='/template/web/libs/jquery.bxslider.js'/>"></script>
	<script src="<c:url value ='/template/web/libs/bootstrap.min.js'/>"></script>
	<script src="<c:url value ='/template/web/js/main.js'/>"></script>

</body>
</html>