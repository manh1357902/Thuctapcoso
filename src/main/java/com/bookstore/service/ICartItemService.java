package com.bookstore.service;

import java.util.Set;

import com.bookstore.entity.CartItemEntity;

public interface ICartItemService {
	CartItemEntity findBookToCart(Set<CartItemEntity> items, Long bookid);
	void deleteItem(Long id,String username);
}
