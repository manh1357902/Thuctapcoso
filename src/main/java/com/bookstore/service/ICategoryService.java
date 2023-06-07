package com.bookstore.service;



import java.util.List;

import com.bookstore.dto.CategoryDTO;

public interface ICategoryService {
	List<CategoryDTO> findAll();
	CategoryDTO findOneByName(String name);
	CategoryDTO findOne(Long id);
	CategoryDTO save(CategoryDTO category);
	List<String> findName();
	void delete(Long id);
}

