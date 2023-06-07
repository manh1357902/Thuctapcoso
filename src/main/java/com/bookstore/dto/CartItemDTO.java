package com.bookstore.dto;

public class CartItemDTO {
    private Long id;
    private int quantity;
    private double totalPrice;    
    private BookDTO book;
    private ShoppingCartDTO cart;
    private String convertPrice;
    
	public String getConvertPrice() {
		return convertPrice;
	}
	public void setConvertPrice(String convertPrice) {
		this.convertPrice = convertPrice;
	}
	public ShoppingCartDTO getCart() {
		return cart;
	}
	public void setCart(ShoppingCartDTO cart) {
		this.cart = cart;
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
	public BookDTO getBook() {
		return book;
	}
	public void setBook(BookDTO book) {
		this.book = book;
	}
    
}
