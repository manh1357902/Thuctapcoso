<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VNPAY</title>
</head>
<body>
<div style="min-height: 100vh; display: flex; flex-direction: column;">
<section class="detail-content">
	<div class="container" >
	<div class="row">
				<div class="col-sm-3">
				<div class="sidebar">
					<h3>Thể loại</h3>
					<h5 class="all-list">Tất cả</h5>
					<ul>
						<c:forEach var="item" items="${category}">
							<li><a href='<c:url value ="/trang-chu/${item.id}"/>'>${item.name}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div style="margin-bottom: 20px;">
			<h1 class="text-center" style="font-size: 60px;">VNPAY</h1>
			<h1 class="text-center" style="font-size: 20px;">Tính năng đang phát triển vui lòng quay lại sau</h1>
			</div>
			<div class="col-sm-9" > 
	               <div class="col col-md-12" style="width: 120%;">
                    
					<div style="margin-bottom: 20px;">
                    <a href="<c:url value='/trang-chu'/>" class="btn btn-warning btn-md"><i class="fa fa-arrow-left"
                            aria-hidden="true"></i>&nbsp;Quay
                        về trang chủ</a>                  
			</div>
	</div>

</div>
</div>
</section>
</div>
</body>
</html>