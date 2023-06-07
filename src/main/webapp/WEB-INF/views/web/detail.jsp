<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="vn">

<head>
    <meta charset="UTF-8">
    <title>Book</title>
</head>

<body>

    <section class="detail-content">
        <div class="container">
            <div class="detail">
                <div class="row">
                    <div class="col-sm-3">
                        <img src="<c:url value='/template/web/images/${book.img}'/>"
                        class="detail-img" width="200" height="310"
                        alt="player">
                        
                    </div>

                    <div class="col-sm-9">
                        <div class="detail-description">
                            <h3>${book.title}</h3>
                            <p>${book.description}</p>
                        </div>
                        <div class="price-add">
                            <span class="our-price">Giá:</span>
                            <span class="price-int">${book.convertPrice}
                                VNĐ</span>
                            <c:if test="${book.quantity!=0}">
                                <form action="<c:url value='/gio-hang/add'/>" method="post">
                                    <div class="counter">
                                    	<input type="hidden" value="${book.id}" name = "id">
                                        <p>Số lượng:</p>
                                        <span class="down" onClick='decreaseCount(event,
                                                this)'>-</span>
                                        <input style="height:26.6px;" type="text" value="1" name="quantity">
                                        <span class="up" onClick='increaseCount(event,
                                                this)'>+</span>
                                        <p class="quantity">${book.quantity}
                                            sản phẩm có sẵn</p>
                                    </div>
                                    <button type="submit" class="button-cart">Thêm vào
                                        giỏ hàng</button>
                                </form>
                            </c:if>
                            <c:if test="${book.quantity==0}">
                                <div class="counter">
                                    <p>Hết hàng</p>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="tab-section">
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="sidebar">
                        <h3>Thể loại</h3>
                        <h5 class="all-list">Tất cả</h5>
                        <ul>
                            <c:forEach var="item" items="${category}">
                                <li><a href='<c:url
                                        value="/trang-chu/${item.id}"/>'>${item.name}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-9">
                    <div class="wrapper">
                        <div class="tabs">
                            <span class="tab">Thông tin sản phẩm</span>
                        </div>
                        <div class="tab_content">
                            <div class="tab_item">
                                <p>Tác giả: <span>${book.author}</span></p>
                                <p>Số trang: <span> ${book.page}</span></p>
                                <p>Nhà xuất bản: <span>${book.publisher}</span></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
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