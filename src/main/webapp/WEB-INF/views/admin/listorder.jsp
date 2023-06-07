<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
    <title>Danh sách đơn hàng</title>
</head>
<body>
 <div class="container-fluid">
         <div class="card shadow mb-4">
             <div class="card-header py-3">
             <h6 class="m-0 font-weight-bold text-primary">Đơn hàng</h6>
			</div>
             <div class="card-body">
                 <div class="table-responsive">
                     <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                         <thead>
							<tr>
								<th>Mã đơn</th>
								<th>Người đặt</th>
								<th>Ngày đặt</th>
								<th>Ngày vận chuyển</th>
								<th>Ngày nhận</th>
								<th>Trạng thái</th>
								<th>Tổng tiền</th>
								<th>Phương thức thanh toán</th>
								<th>Hành động</th>
							</tr>
             			</thead>
                         <tbody>
					          	<c:forEach var="item" items="${orders}">
									<tr>
										<td class="text-center">${item.id}</td> 
										<td class="text-center">${item.user.userName}</td>   
										<td class="text-center">${item.orderDay}</td>   
		                                <td class="text-center">${item.deliveryDay}</td>
		                                <td class="text-center">${item.dateReceive}</td>
		                                <td class="text-center">${item.orderStatus}</td>      
		                                <td class="text-center">${item.convertTotalPrice}</td>   
		                                <td class="text-center">Tiền mặt</td>	
		                                <td class="text-center">
	                                		<c:if test="${item.orderStatus=='Đang chờ duyệt'}">
		                                	<div>
		                                	<form action="<c:url value='/admin/process-order'/>" method="post">
			                                	<input type="hidden" name ="id" value="${item.id}">
			                                	<input type="hidden" name="action" value="duyet">
			                                	<button type="submit" class="btn btn-primary" style="margin-bottom: 3px;">Duyệt</button>
		                                	</form>
		         							</div>
		         							</c:if>
		         							<c:if test="${item.orderStatus=='Đang vận chuyển'}">
		                                	<div>
		                                	<form action="<c:url value='/admin/process-order'/>" method="post">
			                                	<input type="hidden" name ="id" value="${item.id}">
			                                	<input type="hidden" name="action" value="receive">
			                                	<button type="submit" class="btn btn-primary" style="margin-bottom: 3px;">Xác nhận</button>
		                                	</form>
		         							</div>
		         							</c:if>
		         							<c:if test="${item.orderStatus!='Đã nhận'}">
		         							<div>		         							
		                                     <form action="<c:url value='/admin/process-order'/>" method="post">
			                                	<input type="hidden" name ="id" value="${item.id}">
			                                	<input type="hidden" name="action" value="huy">
			                                	<button type="submit" class="btn btn-primary" style="width: 68.79px;">Hủy</button>
		                                	</form>
		                                	</div>
		                                	</c:if>

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
<script type="text/javascript"></script>
</body>
</html>
