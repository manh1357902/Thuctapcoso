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
		<div class="alert alert-danger">
		  ${mess}
		</div>
     </c:if>
	<div class="card">
                <div class="card-body">
                  <h4 class="card-title">Thể loại</h4>
            <div class="row">
                <div class="col-12 grid-margin stretch-card">
                      <form:form action="/bookstore/admin/createCategory" method="post" modelAttribute="category">
                          <div class="form-group">
                              <label>Thể loại</label>
                              <form:input type="text" cssClass="form-control" path="name"/>
                          </div>
                          <button type="submit" class="btn btn-primary me-2">Thêm</button>
                          <a class="btn btn-danger" href="<c:url value='/admin/list/category'/>" style="color:white;">Hủy</a>
                      </form:form>
                </div>
            </div>
        </div>
    </div>
    </div>
    </div>
</body>
</html>
