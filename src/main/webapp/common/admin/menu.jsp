<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
			<div style="margin-bottom:10%;"></div>
            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<c:url value ='/admin/trang-chu'/>">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Admin</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value ='/admin/list/category'/>">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Quản lý thể loại</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value ='/admin/list/book'/>">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Quản lý sách</span></a>
            </li>
			<li class="nav-item active">
                <a class="nav-link" href="<c:url value ='/admin/list/user'/>">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Quản lý người dùng</span></a>
            </li>
			<li class="nav-item active">
                <a class="nav-link" href="<c:url value='/admin/list/order'/>">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Quản lý đơn hàng</span></a>
            </li>
            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
        </ul>