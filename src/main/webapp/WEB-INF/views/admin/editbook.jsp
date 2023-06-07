<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>

<html>
<head>
    <title>Chỉnh sửa sách</title>
    <meta charset="UTF-8">
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
                <c:if test="${not empty book.id}">
                  <h4 class="card-title">Chỉnh sửa sách</h4>
                 </c:if>
                <c:if test="${empty book.id}">
                  	<h4 class="card-title">Thêm sách</h4>
                </c:if>
            <div class="row">
                <div class="col-12 grid-margin stretch-card">
                      <form:form action="/bookstore/admin/createBook" method="post" modelAttribute="book" enctype="multipart/form-data" accept-charset="UTF-8">
                          <form:input type="hidden" path="id" value="${book.id}"/>
                          <div class="form-group">
                              <label>Tên sách</label>
                              <form:input type="text" cssClass="form-control" id="title" path="title" charset="UTF-8"/>
                          </div>
                          <div class="form-group">
                              <label>Tác giả</label>                              
                                  <form:input type="text" cssClass="form-control" id="author" path="author" charset="UTF-8"/>
                          </div>
                         <div class="form-group"> 
                         	<label>Thể loại</label> <br>       
                       		<form:select path="categoryname" class="browser-default custom-select" charset="UTF-8">
                       			<form:option class="text-center" value=""> --Lựa chọn--</form:option>
                       			<form:options class="text-center" items="${categories}"></form:options>
                       		</form:select>              
						</div>		
						<div class="form-group"> 	
							<label>Hình ảnh</label>				
							<div class="custom-file">
							    <input type="file" class="custom-file-input" id = "img1" name="img1"/>
							    <label class="custom-file-label">Chọn file</label>
							    <form:input type="hidden" path="img"/>
							  </div>
						</div>
						 <div class="form-group"> 
                         <label>Số trang</label>                      
								<form:input type="text" cssClass="form-control" id= "page" path="page" charset="UTF-8"/>
						</div>		
						<div class="form-group"> 
                         <label>Nhà xuất bản</label>                      
								<form:input type="text" cssClass="form-control" id= "publisher" path="publisher" charset="UTF-8"/>
						</div>		
                          <div class="form-group">
                              <label>Mô tả</label>                            
                              <form:textarea rows="5" cssClass="form-control" id="description" path="description" charset="UTF-8"/>
                          </div>
                          <div class="form-group">
                              <label>Giá</label>                            
                              <form:input type="text" cssClass="form-control" id="price" path="price" charset="UTF-8"/>
                          </div>
                          <div class="form-group">
                              <label>Số lượng</label>                            
                              <form:input type="text" cssClass="form-control" id="quantity" path="quantity" charset="UTF-8"/>
                          </div>
                     
                          <c:if test="${not empty book.id}">
                          	<button type="submit" class="btn btn-primary me-2">Chỉnh sửa</button>
                          </c:if>
                          <c:if test="${empty book.id}">
                          	<button type="submit" class="btn btn-primary me-2">Thêm</button>
                          </c:if>
                           <c:url var="listBook" value="/admin/list/book"/>
                          <button type="button" class="btn btn-light" onclick="window.location.href='${listBook}'">Hủy</button>
                      </form:form>
                </div>
            </div>
        </div>
    </div>
    </div>
    </div>
</body>
</html>
