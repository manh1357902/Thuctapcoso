package com.bookstore.dto;

import com.bookstore.entity.OrderEntity;

public class OrderDetailDTO {
	
    private Long id;   
    private int quantity;
    private double totalPrice;
    private double unitPrice;
    private OrderEntity order;
    private String convertTotalPrice;
    private String convertUnitPrice;
    private String nameBook;
    private String img;
    private Long idBook;
    
	public Long getIdBook() {
		return idBook;
	}
	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}
	public String getNameBook() {
		return nameBook;
	}
	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getConvertTotalPrice() {
		return convertTotalPrice;
	}
	public void setConvertTotalPrice(String convertTotalPrice) {
		this.convertTotalPrice = convertTotalPrice;
	}
	public String getConvertUnitPrice() {
		return convertUnitPrice;
	}
	public void setConvertUnitPrice(String convertUnitPrice) {
		this.convertUnitPrice = convertUnitPrice;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public OrderEntity getOrder() {
		return order;
	}
	public void setOrder(OrderEntity order) {
		this.order = order;
	}
    
}
