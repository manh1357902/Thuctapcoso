<%@include file="/common/taglib.jsp"%>
<%@page import="com.bookstore.util.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header>
	<div class="header-top">
		<div class="container">
			<nav class="nav-top">
				<ul>
				<security:authorize access ="isAnonymous()">
					<li><a href="<c:url value = '/dang-nhap'/>">Đăng nhập</a></li>
					<li><a href="<c:url value = '/dang-ky'/>">Đăng ký</a></li>
				</security:authorize>
				<security:authorize access ="isAuthenticated()">
					<li><a href="<c:url value='/thong-tin-ca-nhan'/>">Xin chào, <%=SecurityUtils.getPrincipal().getFullName() %></a></li>
					<li><a href="<c:url value = '/thoat'/>">Thoát</a></li>
				</security:authorize>
					
				</ul>
			</nav>
		</div>
	</div>
	<div class="header-middle">
		<div class="container">
			<div class="left-column-block">
				<a href="<c:url value='/trang-chu'/>"><img src="<c:url value ='/template/web/images/logo.png'/>" alt="logo" style="width: 32;" /></a>
			</div>
							
			<div class="shop-checkout" style="margin-left: 8%;">
				<div class="shop">
					<a href="<c:url value='/gio-hang'/>"><img src="<c:url value ='/template/web/images/shop.png'/>" style="width: 32px;height: 29px"></a>
					<c:if test="${totalItems != null}">
						<div class="notice">${totalItems}</div>
					</c:if>					 				
					<span class="your-cart">Giỏ hàng</span>
					
					<a class="order" style="margin-left:30px;" href="<c:url value='/don-hang'/>">Đơn hàng</a>
				</div>
				<div class="checkout">
					<span>Tổng tiền:</span>
					<span>${totalPrices}</span>
					<a href="<c:url value="/thanh-toan"/>">Thanh toán</a>
				</div>
			</div>

			<div class="phone">
				<div style="float:right;">
				<h5>Liên hệ với chúng tôi:</h5>
				<p>0347303670</p>
				</div>			
			</div>
			<form class="navbar-form navbar-right left-column-block" action="<c:url value='/xu-ly-tim-kiem'/>" method="post">
				<input type="text" name="keyword" charset="UTF-8">
				<button type="submit"><i class="fa fa-search sear" aria-hidden="true"></i>Search</button>
		    </form>	
		</div>
	</div>
</header>