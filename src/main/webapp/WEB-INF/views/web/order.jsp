<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đơn hàng</title>
</head>
<body>
<div style="min-height: 100vh; display: flex; flex-direction: column;">
<section class="detail-content">
	<div class="container" >
	<div class="row">
				<div class="col-sm-3">
				<div class="sidebar">
					<h3>Thể loại</h3>
					<h5 class="all-list">Tất cả</h5>
					<ul>
						<c:forEach var="item" items="${category}">
							<li><a href='<c:url value ="/trang-chu/${item.id}"/>'>${item.name}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div style="margin-bottom: 20px;">
			<h1 class="text-center" style="font-size: 60px;">Đơn hàng</h1>
			</div>
			<div class="col-sm-9" > 
	               <div class="col col-md-12" style="width: 120%;">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                            	<th style="width:40px;"></th>
                            	<th class="text-center" >Mã đơn hàng</th>
                                <th class="text-center" >Ngày đặt</th>
                                <th class="text-center">Ngày vận chuyển</th>
                                <th class="text-center">Ngày nhận</th>
                                <th class="text-center">Trạng thái</th>
                                <th class="text-center">Tổng tiền</th>
                                <th class="text-center">Phương thức thanh toán</th>
                                <th class="text-center">Hành động</th>
                              
                            </tr>
                        </thead>
                        <tbody id="datarow">
                         <c:forEach var="item" items="${orders}" varStatus="status">
                         	
                         	<tr>       
                         		<td><a class="" href="<c:url value='/chi-tiet-don-hang/${item.id}'/>">Chi tiết</a></td>  
                         		<td class="text-center">${item.id}</td>               		
                                <td class="text-center">${item.orderDay}</td>   
                                <td class="text-center">${item.deliveryDay}</td>
                                <td class="text-center">${item.dateReceive}</td>
                                <td class="text-center">${item.orderStatus}</td>      
                                <td class="text-center">${item.convertTotalPrice}</td>   
                                <td class="text-center">Tiền mặt</td>
                                 <td class="text-center">
                                 <c:if test="${item.orderStatus=='Đang chờ duyệt'}">
                                 <form action="<c:url value='/cancel-order'/>" method="post">
                                 	<input type="hidden" name = "id" value='${item.id}'>
                                 	<button type="submit" class="btn btn-info">Hủy</button>
                                </form>  
                                </c:if> 
                                </td>                                    
                            </tr>  
                          
                            </c:forEach>              
                        </tbody>
                    </table>
                    
					<div style="margin-bottom: 20px;">
                    <a href="<c:url value='/trang-chu'/>" class="btn btn-warning btn-md"><i class="fa fa-arrow-left"
                            aria-hidden="true"></i>&nbsp;Quay
                        về trang chủ</a>
          			</div>
			</div>
	</div>

</div>
</div>
</section>
</div>
</body>
</html>