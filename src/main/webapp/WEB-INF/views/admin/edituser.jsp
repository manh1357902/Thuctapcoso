<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>

<html>
<head>
    <title>Chỉnh sửa thông tin người dùng</title>
</head>
<body>
	<div class = "container-fluid">
    <div class="main-content-inner">
	<c:if test="${not empty mess}">
		<div class="alert alert-success">
		  ${mess}
		</div>
     </c:if>
	<div class="card">
                <div class="card-body">
                  <h4 class="card-title">Chỉnh sửa thông tin người dùng</h4>
            <div class="row">
                <div class="col-12 grid-margin stretch-card">
                      <form:form action="/bookstore/admin/edit/process-user" modelAttribute="user">
                          <div class="form-group">
                              <label>Tên người dùng</label>
                              <form:input type="text" cssClass="form-control" id="userName" path="userName" readonly="true"/>
                          </div>
                          <div class="form-group">
                              <label>Mật khẩu</label>                              
                                  <form:input type="password" cssClass="form-control" id="passWord" path="passWord"/>
                          </div>
                         <div class="form-group"> 
                         <label">Tên đầy đủ</label>                      
								<form:input type="text" cssClass="form-control" id= "fullName" path="fullName"/>
							</div>		

                          <div class="form-group">
                              <label>Giới tính: </label>                            
                              <form:radiobutton path="gender" value="Nam" label="Nam" defaultValue="Nam"/>
 							 <form:radiobutton path="gender" value="Nữ" label="Nữ" defaultValue="Nữ"/>
                          </div>
                          <div class="form-group">
                              <label>Địa chỉ</label>                            
                              <form:input type="text" cssClass="form-control" id="address" path="address"/>
                          </div>
                          <div class="input-group mb-3">
			                   <label style="padding-top: 5px;">Ngày sinh: &nbsp; </label>                            
			                   <form:input type="date" class="form-control" path="dateOfBirth" placeholder="Ngày Sinh" required="true"/>
			                </div>
                          <div class="form-group">
                              <label>Số điện thoại</label>                            
                              <form:input type="text" cssClass="form-control" id="phone" path="phone"/>
                          </div>
                          <form:hidden path="id" id = "id"/>
                          <button type="submit" class="btn btn-primary me-2">Chỉnh sửa</button>
                          <a class="btn btn-danger" href="<c:url value='/admin/list/user'/>" style="color:white;">Hủy</a>
                      </form:form>
                </div>
            </div>
        </div>
    </div>
    </div>
    </div>
</body>
</html>
