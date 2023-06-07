package com.bookstore.dto;

import java.util.List;

public class ShoppingCartDTO {
    private Long id;  
    private int totalItems;
    private double totalPrices;
    private String converTotalPrices;
    private UsersDTO user;
    private List<CartItemDTO> cartItem;
    
	public String getConverTotalPrices() {
		return converTotalPrices;
	}
	public void setConverTotalPrices(String converTotalPrices) {
		this.converTotalPrices = converTotalPrices;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public double getTotalPrices() {
		return totalPrices;
	}
	public void setTotalPrices(double totalPrices) {
		this.totalPrices = totalPrices;
	}
	public UsersDTO getUser() {
		return user;
	}
	public void setUser(UsersDTO user) {
		this.user = user;
	}
	public List<CartItemDTO> getCartItem() {
		return cartItem;
	}
	public void setCartItem(List<CartItemDTO> cartItem) {
		this.cartItem = cartItem;
	}

}
