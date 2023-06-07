<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.bookstore.util.SecurityUtils"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh toán</title>
</head>
<body>
   <main role="main" style="margin: 50px;">
        <div class="container mt-4">           
                <div class="text-center">
                    <i class="fa fa-credit-card fa-4x" style="margin: 6px;" aria-hidden="true"></i>
                    <h2 style="font-size:30px;">Thanh toán</h2>
                    <p class="lead">Vui lòng kiểm tra thông tin Khách hàng, thông tin Giỏ hàng trước khi Đặt hàng.</p>
                </div>
                 
                	<div class="row">
                    <div class="col-md-8">     
                    <form:form method="post" modelAttribute="user">                 
                        <div class="row">                        
                        <h1 class="form-group" style="font-size:20px;">Thông tin khách hàng</h1>
                            <div class="form-group">
                                <label style="font-size:18px; margin-bottom:5px">Họ tên</label>
                                <form:input type="text" class="form-control" path="fullName" readonly="true"/>
                            </div>
                            <div class="form-group">
                                <label style="font-size:18px; margin-bottom:5px" >Giới tính</label>
                                <form:input type="text" class="form-control" path="gender" readonly="true"/>
                            </div>
                            <div class="form-group">
                                <label style="font-size:18px; margin-bottom:5px">Địa chỉ</label>
                                <form:input type="text" class="form-control" path="address" readonly="true"/>
                            </div>
                            <div class="form-group">
                                <label style="font-size:18px; margin-bottom:5px">Điện thoại</label>
                                <form:input type="text" class="form-control" path="phone" readonly="true"/>
                            </div>
                            <div class="form-group">
                                <label style="font-size:18px; margin-bottom:5px">Ngày sinh</label>
                                <form:input type="date" class="form-control" path="dateOfBirth" readonly="true"/>
                            </div>
                        </div>
                       </form:form>
					<div class="row">
					<form action='<c:url value="/add-order"/>' method="post">
   	                 <h4 class=" form-group" style="font-size:20px;" >Hình thức thanh toán</h4>
                        <div class="form-group">
                            <label class="radio-inline">
							    <input type="radio" name="checkout" value="CASH" required="true"> Tiền mặt
							 </label>
							 <label class="radio-inline">
							    <input type="radio" name="checkout" value="VNPAY" required="true"> VNPAY
							 </label>
                        </div>
                        <hr class="mb-4">
                        <button class="btn btn-primary btn-lg btn-block" type="submit" name="btnDatHang">Đặt
                            hàng</button>   
                    </form>	
                    </div>
                      
                    </div>
                      <div class="col-md-4 order-md-2 mb-4">
                        <h4 class="d-flex justify-content-between align-items-center mb-3">
                            <span class="form-group" style="font-size:20px">Giỏ hàng</span>
                            <span class="badge badge-secondary badge-pill" style="padding-bottom: 2px;">${totalItems}</span>
                        </h4>
                        <c:forEach var="item" items="${cart.cartItem}">
                        <c:if test="${item.quantity>0}">
	                        <ul>
								<li class="list-group-item">
								  <div class="row">
								    <div class="col-xs-8">
								      <h4 class="list-group-item-heading">${item.book.title}</h4>
								      <p class="list-group-item-text text-muted">${item.book.convertPrice} x ${item.quantity}</p>
								    </div>
								    <div class="col-xs-4 text-right text-muted">
								      <h4>${item.convertPrice}</h4>
								    </div>
								  </div>
								</li>
	                        </ul>
                        </c:if>
                        </c:forEach>
                        <div style="margin-top: 4px;">
	                       	<h4 class="d-flex justify-content-between align-items-center mb-3">
	                            <span style="font-size:20px;">Tổng tiền:</span>
	                            <span style="font-size:20px;float:right;">${cart.converTotalPrices}</span>
	                        </h4>
                        </div>
                    </div>
                </div>
        
        </div>
    </main>


</body>
</html>