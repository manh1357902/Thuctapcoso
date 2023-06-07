<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
    <title>Thể loại</title>
</head>
<body>
 <div class="container-fluid">
		<c:if test="${not empty mess}">
			<div class="alert alert-${alert}">
				${mess}
			</div>
		</c:if>
         <div class="card shadow mb-4">
             <div class="card-header py-3">
             <h6 class="m-0 font-weight-bold text-primary">Thể loại</h6>
                 <div style="float:right;">           	
			      	<a href="<c:url value ="/admin/edit/category"/>" class="btn btn-primary" style="margin-right:5px;">Thêm</a>
				 </div>
			</div>
             <div class="card-body">
                 <div class="table-responsive">
                     <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                         <thead>
							<tr>
								<th class="text-center">STT</th>
								<th class="text-center">Tên</th>
								<th class="text-center">Hành động</th>
							</tr>
             			</thead>
                         <tbody>
					          	<c:forEach var="item" items="${categories}" varStatus="status">
									<tr>
										<td class="text-center">${status.index + 1}</td>
										<td class="text-center">${item.name}</td>
										<td class = "text-center">
											<form action="<c:url value='/admin/deleteCategory'/>" method="post">
											<input type="hidden" name="id" value="${item.id}">
											<button type="submit" class = "btn btn-danger">Xóa</button>
											</form>
										</td>   
									</tr>
								</c:forEach>
                       </tbody>
                   </table>
               </div>
           </div>
       </div>

   </div>
 <!-- Scroll to Top Button-->
 <a class="scroll-to-top rounded" href="#page-top">
     <i class="fas fa-angle-up"></i>
 </a>

</body>
</html>
 