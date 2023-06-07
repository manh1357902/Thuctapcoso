<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>Đăng ký</title>

</head>
<body>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h2 class="text-center">ĐĂNG KÝ TÀI KHOẢN</h2>
			</div>
			<div class="panel-body">
			<c:if test="${not empty mess}">
				<div class="alert alert-danger">${mess}</div>
			</c:if>
			<form:form id="login-form" class="form" action="dang-ky" method="post" modelAttribute="user">
				<div class="form-group">
				  <label for="username">Tên đăng nhập:</label><br>
                  <form:input type="text" path="userName"  class="form-control" placeholder="Tên tải khoản" required="true"/>
				</div>
				<div class="form-group">
				  <label for="fullName">Tên đầy đủ: </label><br>
                  <form:input type="text" path="fullName" placeholder="Họ và tên" class="form-control" required="true"/>
				</div>
				<div class="form-group">
				  <label for="pwd">Mật khẩu:</label>
				  <form:input type="password" path="passWord" placeholder="Mật khẩu" class="form-control" required="true"/>
				</div>
				<div class="form-group">
				  <label for="confirmation_pwd">Xác nhận lại mật khẩu:</label>
				  <form:input type="password" path = "repassWord" placeholder="Xác nhận mật khẩu"  class="form-control" required="true"/>
				</div>
                <div class="form-group">
                   <label>Giới tính: </label>                            
                   <form:radiobutton path="gender" value="Nam" label="Nam" defaultValue="Nam" required="true"/>
				 	<form:radiobutton path="gender" value="Nữ" label="Nữ" defaultValue="Nữ" required="true"/>
                </div>
                <div class="form-group">
                   <label style="padding-top: 5px;">Ngày sinh: &nbsp; </label>                            
                   <form:input type="date" class="form-control" path="dateOfBirth" required="true"/>
	             </div>
				<div class="form-group">
				  <label for="phone">Số điện thoại:</label>
				  <form:input type="text" path="phone" id="phone" class="form-control" placeholder="Điện thoại" required="true"/>
				</div>
                <div class="form-group">
                     <label>Địa chỉ:</label>                            
                     <form:input type="text" cssClass="form-control" placeholder="Địa chỉ" path="address" required="true"/>
                 </div>
				
				<button type="submit" id="check" class="btn btn-success" style="width: 100%;">Đăng ký</button>
			</form:form>
			
			</div>
		</div>
	</div>


</body>
</htmsl>