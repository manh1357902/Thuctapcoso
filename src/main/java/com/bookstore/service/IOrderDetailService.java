package com.bookstore.service;

import java.util.List;

import com.bookstore.dto.OrderDetailDTO;

public interface IOrderDetailService {
	List<OrderDetailDTO> findByOrder(Long id);
	
}
