package com.bookstore.service.convert;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookstore.dto.CartItemDTO;
import com.bookstore.dto.ShoppingCartDTO;
import com.bookstore.entity.CartItemEntity;
import com.bookstore.entity.ShoppingCartEntity;

@Component
public class ShoppingCartConvert {
	
	@Autowired
	private UserConvert userConvert;
	@Autowired
	private CartItemConvert cartConvert;

	public ShoppingCartDTO toDTO(ShoppingCartEntity entity) {
		ShoppingCartDTO dto = new ShoppingCartDTO();
		if(entity!=null) {
			dto.setId(entity.getId());
			dto.setTotalItems(entity.getTotalItems());
			NumberFormat numberFormat= NumberFormat.getNumberInstance();
			String price = numberFormat.format(entity.getTotalPrices());
			dto.setConverTotalPrices(price);
			dto.setTotalPrices(entity.getTotalPrices());
			dto.setUser(userConvert.toDto(entity.getUser()));
			List<CartItemEntity> cartitems = new ArrayList<>();
			cartitems.addAll(entity.getCartItem());
			List<CartItemDTO> carts = new ArrayList<>();
			for(CartItemEntity x:cartitems) {
				carts.add(cartConvert.toDTO(x));
			}
			dto.setCartItem(carts);
			return dto;
		}
		return null;		
	}
	public ShoppingCartEntity toEntity(ShoppingCartDTO dto) {
		ShoppingCartEntity entity = new ShoppingCartEntity();
		List<CartItemDTO> carts = dto.getCartItem();
		List<CartItemEntity> cartEntity = new ArrayList<>();
		for(CartItemDTO item: carts) {
			CartItemEntity cart1 = cartConvert.toEntity(item);
			cartEntity.add(cart1);
		}
		entity.setCartItem(cartEntity);
		entity.setTotalItems(dto.getTotalItems());
		entity.setUser(userConvert.toEntity(dto.getUser()));
		return entity;
	}
}
