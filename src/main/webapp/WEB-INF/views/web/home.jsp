<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang = "vn">
<head>
	<meta charset="UTF-8">
	<title>Trang chủ</title>

</head>
<body>	
	<section id="slider-section">
		<div class="container">
			<ul class="bxslider">
				<li><img src="<c:url value='/template/web/images/banner01.png'/>" class="img-responsive"></li>
				<li><img src="<c:url value='/template/web/images/banner02.png'/>" class="img-responsive"></li>
				<li><img src="<c:url value='/template/web/images/banner03.png'/>" class="img-responsive"></li>
				<li><img src="<c:url value='/template/web/images/banner04.png'/>" class="img-responsive"></li>
			</ul>
		</div>
	</section>
	<section class="main-content">
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="sidebar">
					<h3 style="color:black;">Thể loại</h3>
					<h5 class="all-list"><a href='<c:url value ="/trang-chu"/>'>Tất cả</a></h5>
					<ul>
						<c:forEach var="item" items="${category}">
							<li><a href='<c:url value ="/trang-chu/${item.id}"/>'>${item.name}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="col-sm-9"> 			
					<div class="sidebar-left">
						<div class="row">
								<c:forEach var="item" items="${books}">
								<div class="col-sm-3 col-md-3">
								<div class="thumbnail">
									<a href="<c:url value='/chi-tiet/${item.id}'/>"><img src="<c:url value="/template/web/images/${item.img}"/>" alt="Book" style="width: 121px; height: 181px;"></a>
									<div class="caption">
										<p style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;"><a href="<c:url value="/chi-tiet/${item.id}"/>" >${item.title}</a></p>
										<p class="price">${item.convertPrice}</p>
									</div>
									      <div class="text-center">
									        <a class="btn btn-primary" href="<c:url value='/chi-tiet/${item.id}'/>"> Xem ngay</a>
									      </div>
								</div>
								</div>
								</c:forEach>
						</div>
							<br>
								<div class = "text-center">
								    <c:if test="${currentPage > 1}">
								        <a style="color:black;border: solid 1px black" class="btn btn-light" href="?page=${currentPage - 1}">Previous</a>
								    </c:if>
								    <span>${currentPage} / ${totalPages}</span>
								    <c:if test="${currentPage < totalPages}">
								        <a style="color:black;border: solid 1px black" class="btn btn-light" href="?page=${currentPage + 1}">Next</a>
								    </c:if>
								</div>
					</div>	
				</div>
			</div>	
		</div>					
</section>
</body>