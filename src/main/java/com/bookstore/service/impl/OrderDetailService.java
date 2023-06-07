package com.bookstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dto.OrderDetailDTO;
import com.bookstore.entity.OrderDetailEntity;
import com.bookstore.entity.OrderEntity;
import com.bookstore.repository.OrderDetailRepository;
import com.bookstore.repository.OrderRepository;
import com.bookstore.service.IOrderDetailService;
import com.bookstore.service.convert.OrderDetailConvert;

@Service
public class OrderDetailService implements IOrderDetailService {
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private OrderDetailConvert orderConvert;
	@Autowired 
	private OrderRepository orderRepository;
	@Override
	public List<OrderDetailDTO> findByOrder(Long id) {
		List<OrderDetailDTO> detailDTO = new ArrayList<>();
		OrderEntity order = orderRepository.findOne(id);
		List<OrderDetailEntity> detail = orderDetailRepository.findByOrder(order);
		for(OrderDetailEntity x: detail) {
			OrderDetailDTO detail1 =  orderConvert.toDTO(x);
			detailDTO.add(detail1);
		}
		return detailDTO;
	}
}
