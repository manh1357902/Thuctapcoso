package com.bookstore.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.CartItemEntity;
import com.bookstore.entity.ShoppingCartEntity;
import com.bookstore.entity.UserEntity;
import com.bookstore.repository.CartItemRepository;
import com.bookstore.repository.ShoppingCartRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.ICartItemService;

@Service
public class CartItemService implements ICartItemService{
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	@Override
	public CartItemEntity findBookToCart(Set<CartItemEntity> items, Long bookid) {
		if(items==null) {
			return null;
		}
		CartItemEntity  item = new CartItemEntity();
		for(CartItemEntity x: items) {
			if(x.getBook().getId()==bookid) {
				item = x;
			}
		}
		return item;
	}

	@Override
	public void deleteItem(Long bookId,String username) {
		UserEntity user = userRepository.findOneByUserName(username);
		ShoppingCartEntity cart = shoppingCartRepository.findOneByUser(user);
		Set<CartItemEntity> cartItem = new  HashSet<>();
		if(cart!=null) {
			cartItem.addAll(cart.getCartItem());
		}
		CartItemEntity item = findBookToCart(cartItem, bookId);
		cartItemRepository.delete(item);		
		cartItem.remove(item);
		List<CartItemEntity> item1 = new ArrayList<>();
		item1.addAll(cartItem);
		cart.setCartItem(item1);
		int totalItems = 0;
		double totalPrice = 0;
		for(CartItemEntity x:item1) {
			totalItems += x.getQuantity();
			totalPrice += x.getTotalPrice(); 
		}	
		cart.setTotalItems(totalItems);
		cart.setTotalPrices(totalPrice);
		shoppingCartRepository.save(cart);
	}
	

}
