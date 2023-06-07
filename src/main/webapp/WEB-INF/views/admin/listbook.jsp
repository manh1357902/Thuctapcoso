<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
    <title>Danh sách sách</title>
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
             <h6 class="m-0 font-weight-bold text-primary">Sách</h6>
                 <div style="float:right;">           	
			      	<a href="<c:url value ="/admin/createBook"/>" class="btn btn-primary" style="margin-right:5px;">Thêm</a>
				 </div>
			</div>
             <div class="card-body">
                 <div class="table-responsive">
                     <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                         <thead>
							<tr>
								<th class="text-center">Hình ảnh</th>
								<th class="text-center">Tên sách</th>
								<th class="text-center">Tác giả</th>
								<th class="text-center">Thể loại</th>
								<th class="text-center">Nhà xuất bản</th>
								<th class="text-center">Số trang</th>
								<th class="text-center">Giá</th>
								<th class="text-center">Số lượng</th>
								<th class="text-center">Hành động</th>
							</tr>
             			</thead>
                         <tbody>
					          	<c:forEach var="item" items="${model}">
									<tr>
										<td><img src="<c:url value="/template/web/images/${item.img}"/>" width="108px" height="72px"></td>
										<td class="text-center">${item.title}</td>
										<td class="text-center">${item.author}</td>
										<td class="text-center">${item.categoryname}</td>
										<td class="text-center">${item.publisher}</td>
										<td class="text-center">${item.page}</td>
										<td class="text-center">${item.convertPrice}</td>
										<td class="text-center">${item.quantity}</td>	
										<td><a class="btn btn-primary" href="<c:url value ="/admin/createBook"><c:param name = "id" value="${item.id}"/></c:url>">Chỉnh sửa</a>
											<form action="<c:url value='/admin/deleteBook'/>" method="post">
												<input type="hidden" value="${item.id}" name = "id">
												<button type="submit" class="btn btn-danger" style="width:96.63px;">Xóa</button>
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
