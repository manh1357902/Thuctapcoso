package com.bookstore.dto;

import java.util.Date;
import java.util.List;

public class OrderDTO {
	
    private Long id;
    
    private Date orderDate;
    private String orderDay;
    private Date deliveryDate;
    private String deliveryDay;
    private double totalPrice;
    private String orderStatus;
    private String notes;
    private UsersDTO user;
    private List<OrderDetailDTO> details;
    private String convertTotalPrice;
    private Date orderReceive;
    private String dateReceive;
    
	public Date getOrderReceive() {
		return orderReceive;
	}

	public void setOrderReceive(Date orderReceive) {
		this.orderReceive = orderReceive;
	}

	public String getDateReceive() {
		return dateReceive;
	}

	public void setDateReceive(String dateReceive) {
		this.dateReceive = dateReceive;
	}

	public String getDeliveryDay() {
		return deliveryDay;
	}

	public void setDeliveryDay(String deliveryDay) {
		this.deliveryDay = deliveryDay;
	}

	public String getConvertTotalPrice() {
		return convertTotalPrice;
	}

	public void setConvertTotalPrice(String convertTotalPrice) {
		this.convertTotalPrice = convertTotalPrice;
	}

	public String getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(String orderDay) {
		this.orderDay = orderDay;
	}

	public List<OrderDetailDTO> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetailDTO> details) {
		this.details = details;
	}

	public UsersDTO getUser() {
		return user;
	}

	public void setUser(UsersDTO user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

    
}
