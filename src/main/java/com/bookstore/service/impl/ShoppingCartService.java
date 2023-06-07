package com.bookstore.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.dto.ShoppingCartDTO;
import com.bookstore.entity.BookEntity;
import com.bookstore.entity.CartItemEntity;
import com.bookstore.entity.ShoppingCartEntity;
import com.bookstore.entity.UserEntity;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CartItemRepository;
import com.bookstore.repository.ShoppingCartRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.ICartItemService;
import com.bookstore.service.IShoppingCartService;
import com.bookstore.service.convert.ShoppingCartConvert;
@Service
public class ShoppingCartService implements IShoppingCartService{
	
	@Autowired
	private ICartItemService cartItemService;
	
	@Autowired
	private ShoppingCartConvert shoppingCartConvert;
	
	@Autowired
	private CartItemRepository itemRepository;
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
		
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public ShoppingCartDTO addToCart(Long bookId, int quantity, String username) {
		UserEntity user = userRepository.findOneByUserName(username);
		ShoppingCartEntity cart = shoppingCartRepository.findOneByUser(user);
		List<CartItemEntity> items = new ArrayList<>();
		if(cart==null) {
			cart = new ShoppingCartEntity();
		}else {
			items.addAll(cart.getCartItem());
		}
		Set<CartItemEntity> cartItems = new HashSet<>();
		if(items.size()!=0)
			cartItems.addAll(items);	
		CartItemEntity cartItem = cartItemService.findBookToCart(cartItems, bookId);
		if(items.size() == 0) {
			if(cartItem.getBook()==null) {
				cartItem = new CartItemEntity();
				BookEntity book = bookRepository.findOne(bookId);
				cartItem.setBook(book);
				cartItem.setQuantity(quantity);
				cartItem.setShoppingCart(cart);
				cartItem.setTotalPrice(quantity*book.getPrice());
				cartItems.add(cartItem);
				itemRepository.save(cartItem);
			}
		}
		else {
			if(cartItem.getId()==null) {
				cartItem = new CartItemEntity();
				BookEntity book = bookRepository.findOne(bookId);
				cartItem.setBook(book);
				cartItem.setQuantity(quantity);
				cartItem.setTotalPrice(quantity*book.getPrice());
				cartItems.add(cartItem);
				cartItem.setShoppingCart(cart);
				itemRepository.save(cartItem);
			}
			else {
				BookEntity book = bookRepository.findOne(bookId);
				int quantityNew = cartItem.getQuantity()+quantity;
				cartItem.setQuantity(quantityNew);
				cartItem.setTotalPrice(quantityNew*book.getPrice());
				itemRepository.save(cartItem);
			}
		}
		List<CartItemEntity> cart1 = new ArrayList<>();
		cart1.addAll(cartItems);
		cart.setCartItem(cart1);
		int totalItems = 0;
		double totalPrice = 0;
		for(CartItemEntity item:cart1) {
			totalItems += item.getQuantity();
			totalPrice += item.getTotalPrice(); 
		}		
		cart.setTotalItems(totalItems);
		cart.setTotalPrices(totalPrice);
		cart.setUser(user);
		return shoppingCartConvert.toDTO(shoppingCartRepository.save(cart));
	}

	@Override
	@Transactional	
	public ShoppingCartDTO update(Long bookID, int quantity, String username) {
		UserEntity user = userRepository.findOneByUserName(username);
		ShoppingCartEntity cart = shoppingCartRepository.findOneByUser(user);
		List<CartItemEntity> items = cart.getCartItem();
		Set<CartItemEntity> cartItems = new HashSet<>();
		if(items.size()!=0)
			cartItems.addAll(items);	
		CartItemEntity cartItem = cartItemService.findBookToCart(cartItems, bookID);
		BookEntity book = bookRepository.findOne(bookID);
		cartItem.setQuantity(quantity);
		cartItem.setTotalPrice(quantity*book.getPrice());
		itemRepository.save(cartItem);
		List<CartItemEntity> cart1 = new ArrayList<>();
		cart1.addAll(cartItems);
		int totalItems = 0;
		double totalPrice = 0;
		for(CartItemEntity item:cart1) {
			totalItems += item.getQuantity();
			totalPrice += item.getTotalPrice(); 
		}		
		cart.setTotalItems(totalItems);
		cart.setTotalPrices(totalPrice);
		return shoppingCartConvert.toDTO(shoppingCartRepository.save(cart));
	}

	
	@Override
	public ShoppingCartDTO findByUser(UserEntity user) {
		ShoppingCartEntity cart = shoppingCartRepository.findOneByUser(user); 
		return shoppingCartConvert.toDTO(cart);
	}
	
}
