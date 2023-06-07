package com.bookstore.service;

import com.bookstore.dto.ShoppingCartDTO;
import com.bookstore.entity.UserEntity;

public interface IShoppingCartService {
	ShoppingCartDTO addToCart(Long bookID, int quantity, String username);
	ShoppingCartDTO update(Long bookID, int quantity, String username);
	ShoppingCartDTO findByUser(UserEntity user);

}
