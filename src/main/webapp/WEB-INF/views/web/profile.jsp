<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang = "vn">
<head>
	<meta charset="UTF-8">
	<title>Thông tin cá nhân</title>

</head>
<body>	
<section class="detail-content">
  <div class="container">
    <h1 class="text-center" style="font-size: 30px;">Chỉnh sửa thông tin người dùng</h1> 
    	<c:if test="${not empty mess}">
		<div class="alert alert-success">
		  ${mess}
		</div>
     </c:if>
    <form:form action="/bookstore/process-user" method="POST" modelAttribute="user">
      <div class="form-group">
        <label class="col-sm-2 control-label">Họ tên:</label>
        <div class="col-sm-10" style="margin-bottom:20px;">
          <form:input type="text" class="form-control" path="fullName"/>
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">Giới tính:</label>
        <div class="col-sm-10" style="margin-bottom:20px;">
          <form:radiobutton path="gender" value="Nam" label="Nam" defaultValue="Nam"/>
 		<form:radiobutton path="gender" value="Nữ" label="Nữ" defaultValue="Nữ"/>
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">Địa chỉ:</label>
        <div class="col-sm-10" style="margin-bottom:20px;">
          <form:input type="text" cssClass="form-control" id="address" path="address"/>
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">Ngày sinh:</label>
        <div class="col-sm-10" style="margin-bottom:20px;">
          <form:input type="date" class="form-control" path="dateOfBirth" placeholder="Ngày Sinh"/>
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">Số điện thoại:</label>
        <div class="col-sm-10" style="margin-bottom:20px;">
          <form:input type="text" cssClass="form-control" id="phone" path="phone"/>
        </div>
      </div>
      <form:hidden path="id" id = "id"/>
      <form:hidden path="userName"/>
      <form:hidden path="passWord"/>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-primary">Lưu</button>
        </div>
      </div>
    </form:form>
  </div>
  </section>
</body>