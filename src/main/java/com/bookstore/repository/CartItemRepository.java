package com.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.BookEntity;
import com.bookstore.entity.CartItemEntity;
import com.bookstore.entity.ShoppingCartEntity;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {
	List<CartItemEntity> findByShoppingCart(ShoppingCartEntity shoppingCart);
	CartItemEntity findByBook(BookEntity book); 
}
