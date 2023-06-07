package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.ShoppingCartEntity;
import com.bookstore.entity.UserEntity;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Long> {
	ShoppingCartEntity findOneByUser(UserEntity user);
}
