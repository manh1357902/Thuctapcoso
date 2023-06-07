package com.bookstore.service.convert;

import java.text.NumberFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookstore.dto.CartItemDTO;
import com.bookstore.entity.CartItemEntity;

@Component
public class CartItemConvert {
	
	@Autowired
	private BookConvert bookConvert;
	
	public CartItemDTO toDTO(CartItemEntity entity) {
		CartItemDTO dto = new CartItemDTO();
		dto.setId(entity.getId());
		dto.setQuantity(entity.getQuantity());
		dto.setTotalPrice(entity.getTotalPrice());
		NumberFormat numberFormat= NumberFormat.getNumberInstance();
		String price = numberFormat.format(entity.getTotalPrice());
		dto.setConvertPrice(price);
		dto.setBook(bookConvert.toDto(entity.getBook()));
		return dto;		
	}
	
	public CartItemEntity toEntity(CartItemDTO dto) {
		CartItemEntity entity = new CartItemEntity();
		entity.setBook(bookConvert.toEntity(dto.getBook()));
		entity.setQuantity(dto.getQuantity());
		entity.setTotalPrice(dto.getTotalPrice());
		return entity;
	}
	
	public CartItemEntity toEntity(CartItemEntity entity, CartItemDTO dto) {
		entity.setBook(bookConvert.toEntity(dto.getBook()));
		entity.setQuantity(dto.getQuantity());
		entity.setTotalPrice(dto.getTotalPrice());
		return entity;
	}
}
