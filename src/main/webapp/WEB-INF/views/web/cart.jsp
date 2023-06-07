<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
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
			<h1 class="text-center" style="font-size: 60px;">Giỏ hàng</h1>
			</div>
			<div class="col-sm-9" > 
	               <div class="col col-md-12" style="width: 120%;">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>Ảnh đại diện</th>
                                <th>Tên sản phẩm</th>
                                <th>Số lượng</th>
                                <th>Đơn giá</th>
                                <th>Thành tiền</th>
                                <th>Hành động</th>
                            </tr>
                        </thead>
                        <tbody id="datarow">
                        	<c:forEach var="item" items="${shoppingCart.cartItem}" varStatus="status">
                            <tr>
                                <td class="text-center">${status.index+1}</td>
                                <td>
                                    <img src="<c:url value="/template/web/images/${item.book.img}"/>" class="hinhdaidien">
                                </td>
                                <td>${item.book.title}</td>
                                <form action="<c:url value='/gio-hang/update-and-delete'/>" method="post">
                                <input type="hidden" name = "id" value="${item.book.id}">
                                <td class="text-center">                             	                              
                                		<div class="counter">
                                        <span class="down" onClick='decreaseCount(event,
                                                this)'>-</span>
                                        <input type="text" style="height: 37.37px;" value="${item.quantity}" name="quantity" readonly="readonly">
                                        <span class="up" onClick='increaseCount(event,
                                                this)'>+</span>
                                    	</div>
                                   </td>                             
                                <td class="text-center">${item.book.convertPrice}</td>
                                <td class="text-center">${item.convertPrice}</td>
                                <td>
                                	<div class="text-center" >
	                                	<button type="submit" name="action" value="update" title="Update"
	                                            class="btn btn-primary" style="width: 80px; margin-bottom: 4px;">Chỉnh sửa
	                                    </button>
	                                  	<div>
	                                    <button type="submit" style="width: 80px;" name="action" value="delete" title="Delete"
	                                            class="btn btn-danger btn-delete-sanpham">Xóa
	                                    </button>
	                                    </div>
									</div>
                                </td>
                                </form>
                                                              
                            </tr>  
                            </c:forEach>              
         
                        </tbody>
                    </table>
                    
					<div style="margin-bottom: 20px;">
                    <a href="<c:url value='/trang-chu'/>" class="btn btn-warning btn-md"><i class="fa fa-arrow-left"
                            aria-hidden="true"></i>&nbsp;Quay
                        về trang chủ</a>
                    <a href="<c:url value='/thanh-toan'/>" class="btn btn-primary btn-md"><i
                            class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;Thanh toán</a>
          			</div>
			</div>
	</div>

</div>
</div>
</section>
</div>
    <script type="text/javascript">
        function increaseCount(a, b) {
            var input = b.previousElementSibling;
            var value = parseInt(input.value, 10);
            value = isNaN(value) ? 0 : value;
            value++;
            input.value = value;
        }

        function decreaseCount(a, b) {
            var input = b.nextElementSibling;
            var value = parseInt(input.value, 10);
            if (value > 1) {
                value = isNaN(value) ? 0 : value;
                value--;
                input.value = value;
            }
        }
    </script>
</body>