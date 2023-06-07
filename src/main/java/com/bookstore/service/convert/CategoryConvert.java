package com.bookstore.service.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookstore.dto.BookDTO;
import com.bookstore.dto.CategoryDTO;
import com.bookstore.entity.BookEntity;
import com.bookstore.entity.CategoryEntity;

@Component
public class CategoryConvert {
	
	@Autowired
	private BookConvert bookConvert;
	
	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO dto = new CategoryDTO();
		if(entity!=null) {
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			List<BookEntity> books = new ArrayList<>();
			books.addAll(entity.getBooks());
			List<BookDTO> books1 = new ArrayList<>();
			for(BookEntity x:books) {
				books1.add(bookConvert.toDto(x));
			}
			dto.setBooks(books1);
			return dto;	
		}
		return null;
	}
	
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		if(dto!=null) {
			if(dto.getId()!=null) {
				entity.setId(dto.getId());
			}
			entity.setName(dto.getName());
		}
		return entity;
	}
}
