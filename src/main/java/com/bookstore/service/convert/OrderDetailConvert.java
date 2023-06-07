package com.bookstore.service.convert;

import java.text.NumberFormat;

import org.springframework.stereotype.Component;

import com.bookstore.dto.OrderDetailDTO;
import com.bookstore.entity.OrderDetailEntity;

@Component
public class OrderDetailConvert {
	
	public OrderDetailDTO toDTO(OrderDetailEntity entity) {
		OrderDetailDTO dto = new OrderDetailDTO();
		dto.setId(entity.getId());
		dto.setQuantity(entity.getQuantity());
		dto.setTotalPrice(entity.getTotalPrice());
		dto.setUnitPrice(entity.getUnitPrice());
		NumberFormat numberFormat= NumberFormat.getNumberInstance();
		String totalprice = numberFormat.format(entity.getTotalPrice());
		String unitprice = numberFormat.format(entity.getUnitPrice());
		dto.setConvertTotalPrice(totalprice);
		dto.setConvertUnitPrice(unitprice);
		dto.setNameBook(entity.getNameBook());
		dto.setImg(entity.getImg());
		dto.setIdBook(entity.getIdBook());
		return dto;		
	}
	

}
