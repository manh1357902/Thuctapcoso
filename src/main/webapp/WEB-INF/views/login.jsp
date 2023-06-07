<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<body>
 <div class="container">
     <div id="login-row" class="row justify-content-center align-items-center">
         <div id="login-column" class="col-md-6">
             <div id="login-box" class="col-md-12">
                 <h3 class="text-center text-info">Đăng nhập</h3>
                 	<c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">
						Tài khoản hoặc mật khẩu của bạn không đúng
					</div>
			        </c:if>
			        <c:if test="${param.khongcoquyentruynhap != null}">
					<div class="alert alert-danger">
						Bạn không có quyền truy cập trang này
					</div>
			        </c:if>
			        <c:if test="${not empty mess}">
					<div class="alert alert-success">
					  Đăng ký tài khoản thành công
					</div>
			        </c:if>
                 <form id="login-form" class="form" action="j_spring_security_check" method="post">
                     <div class="form-group">
                         <label for="username" class="text-info">Tên đăng nhập:</label><br>
                         <input type="text" name="j_username" class="form-control" placeholder="Tên đăng nhập">
                     </div>
                     <div class="form-group">
                         <label for="password" class="text-info">Mật khẩu:</label><br>
                         <input type="password" name="j_password" class="form-control" placeholder="Mật khẩu">
                     </div>
                     <div class="form-group">
                         <br>
                     	 <button type="submit" class="btn btn-info btn-md btn__login">Đăng nhập</button>
                  	
                     </div>
                     <div id="register-link" class="text-right">
                         <a href="<c:url value = '/dang-ky'/>" class="text-info">Đăng ký tại đây</a>
                     </div>
                 </form>
             </div>
         </div>
     </div>
 </div>

</body>
</html>

 
