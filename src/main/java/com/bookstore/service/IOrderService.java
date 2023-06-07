package com.bookstore.service;

import java.util.List;

import com.bookstore.dto.OrderDTO;
import com.bookstore.entity.UserEntity;

public interface IOrderService {
	void save(String username);
	List<OrderDTO> findAll();
	OrderDTO findById(Long id);
	List<OrderDTO> findByUser(UserEntity user);
	void delete(Long id);
	void processOrder(Long id);
	void receive(Long id);
}
