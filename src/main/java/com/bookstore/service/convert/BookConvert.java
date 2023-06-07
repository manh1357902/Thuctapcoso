package com.bookstore.service.convert;

import java.text.NumberFormat;

import org.springframework.stereotype.Component;

import com.bookstore.dto.BookDTO;
import com.bookstore.entity.BookEntity;

@Component
public class BookConvert {
	public BookDTO toDto(BookEntity entity) {
		if(entity!=null) {
			BookDTO result = new BookDTO();
			result.setAuthor(entity.getAuthor());
			result.setId(entity.getId());
			result.setTitle(entity.getTitle());
			result.setPrice(entity.getPrice());
			result.setImg(entity.getImg());
			result.setQuantity(entity.getQuantity());
			result.setDescription(entity.getDescription());
			result.setCategoryname(entity.getCategory().getName());
			result.setCategoryId(entity.getCategory().getId());
			NumberFormat numberFormat= NumberFormat.getNumberInstance();
			String price = numberFormat.format(entity.getPrice());
			result.setConvertPrice(price);
			result.setPage(entity.getPage());
			result.setPublisher(entity.getPublisher());
			return result;
		}
		return null;
	}
	
	public BookEntity toEntity(BookDTO dto) {
		BookEntity result = new BookEntity();
		result.setAuthor(dto.getAuthor());
		result.setId(dto.getId());
		result.setTitle(dto.getTitle());
		result.setPrice(dto.getPrice());
		result.setImg(dto.getImg());
		result.setQuantity(dto.getQuantity());
		result.setDescription(dto.getDescription());
		result.setPage(dto.getPage());
		result.setPublisher(dto.getPublisher());
		return result;
	}
	
	public BookEntity toEntity(BookEntity result,BookDTO dto) {
		result.setAuthor(dto.getAuthor());
		result.setId(dto.getId());
		result.setTitle(dto.getTitle());
		result.setPrice(dto.getPrice());
		result.setImg(dto.getImg());
		result.setQuantity(dto.getQuantity());
		result.setDescription(dto.getDescription());
		result.setPage(dto.getPage());
		result.setPublisher(dto.getPublisher());
		return result;
	}

}
