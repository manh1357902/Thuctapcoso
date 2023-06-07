<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new" />
<c:url var="NewURL" value="/admin-new" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

 <div class="container-fluid">
	
		<c:if test="${not empty mess}">
			<div class="alert alert-${alert}">
				${mess}
			</div>
		</c:if>
         <div class="card shadow mb-4">
             <div class="card-header py-3">
             <h6 class="m-0 font-weight-bold text-primary">Người dùng</h6>
			</div>
                     <div class="card-body">
                         <div class="table-responsive">
                             <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                 <thead>
									<tr>
										<th>Tài khoản</th>
										<th>Tên đầy đủ</th>
										<th>Giới tính</th>
										<th>Số điện thoại</th>
										<th>Địa chỉ</th>
										<th>Chỉnh sửa</th>
									</tr>
				                 </thead>
                                 <tbody>
				 				<c:forEach var="item" items="${users}">
				 				<c:if test="${item.userName!='admin'}">
									<tr>
										<td>${item.userName}</td>
										<td>${item.fullName}</td>	
										<td>${item.gender}</td>
										<td>${item.phone}</td>
										<td>${item.address}</td>		
										<td><a href="<c:url value ="/admin/edit/user"><c:param name = "id" value="${item.id}"/></c:url>">Chỉnh sửa</a></td>								
									</tr>
								</c:if>
								</c:forEach>
                                 </tbody>
                             </table>
                         </div>
                     </div>
                 </div>

             </div>

<script>		

</script>
 <!-- Scroll to Top Button-->
 <a class="scroll-to-top rounded" href="#page-top">
     <i class="fas fa-angle-up"></i>
 </a>
