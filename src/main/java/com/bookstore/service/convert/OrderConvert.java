package com.bookstore.service.convert;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookstore.dto.OrderDTO;
import com.bookstore.dto.OrderDetailDTO;
import com.bookstore.entity.OrderDetailEntity;
import com.bookstore.entity.OrderEntity;


@Component
public class OrderConvert {
	@Autowired
	private UserConvert userconvert;

	@Autowired
	private OrderDetailConvert detailConvert;
	
	public OrderDTO toDTO(OrderEntity entity) {
		OrderDTO dto = new OrderDTO();
		dto.setId(entity.getId());
		dto.setDeliveryDate(entity.getDeliveryDate());
		List<OrderDetailDTO> details = new ArrayList<>();
		for(OrderDetailEntity detail:entity.getOrderDetail()) {
			OrderDetailDTO x = detailConvert.toDTO(detail);
			details.add(x);
		}
		dto.setDetails(details);
		dto.setNotes(entity.getNotes());
		dto.setOrderDate(entity.getOrderDate());
		dto.setOrderStatus(entity.getOrderStatus());
		dto.setTotalPrice(entity.getTotalPrice());
		dto.setUser(userconvert.toDto(entity.getUser()));
		SimpleDateFormat dfm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(entity.getOrderDate()!=null) {
			String orderDay = dfm.format(entity.getOrderDate());
			dto.setOrderDay(orderDay);
		}
		if(entity.getDeliveryDate()!=null) {
			String deliveryDay = dfm.format(entity.getDeliveryDate());
			dto.setDeliveryDay(deliveryDay);
		}
		if(entity.getOrderReceive()!=null) {
			String dateReceive = dfm.format(entity.getOrderReceive());
			dto.setDateReceive(dateReceive);
		}
		NumberFormat numberFormat= NumberFormat.getNumberInstance();
		String totalprice = numberFormat.format(entity.getTotalPrice());
		dto.setConvertTotalPrice(totalprice);
		
		return dto;
	}
//	public OrderEntity toEntity(OrderDTO dto) {
//		OrderEntity entity = new OrderEntity();
//		entity.setOrderDate(dto.getOrderDate());
//		entity.setDeliveryDate(dto.getDeliveryDate());
//		entity.setNotes(dto.getNotes());
//		entity.setTotalPrice(dto.getTotalPrice());
//		entity.setUser(userconvert.toEntity(dto.getUser()));
//		entity.setOrderStatus(dto.getOrderStatus());
//		List<OrderDetailEntity> details = new ArrayList<>();
//		for(OrderDetailDTO x: dto.getDetails()) {
//			details.add(x);
//		}
//		entity.setOrderDetai();
//		return entity;
//	}
}
