package com.bookstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dto.CategoryDTO;
import com.bookstore.entity.CategoryEntity;
import com.bookstore.repository.CategoryRepository;
import com.bookstore.service.ICategoryService;
import com.bookstore.service.convert.CategoryConvert;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryConvert categoryConvert;
	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryEntity> categories = categoryRepository.findAll();
		List<CategoryDTO> category = new ArrayList<>();
		for(CategoryEntity x:categories) {
			category.add(categoryConvert.toDTO(x));
		}
		return category;
	}
	@Override
	public CategoryDTO findOneByName(String name) {
		CategoryEntity category = categoryRepository.findOneByName(name);
		return categoryConvert.toDTO(category);
	}
	@Override
	public CategoryDTO findOne(Long id) {
		CategoryEntity category = categoryRepository.findOne(id);
		return categoryConvert.toDTO(category);
	}
	@Override
	@Transactional
	public CategoryDTO save(CategoryDTO category) {
		if(category.getId()==null) {
			CategoryEntity categoryEntity = categoryRepository.save(categoryConvert.toEntity(category));
			return categoryConvert.toDTO(categoryEntity);			
		}
		return null;
	}
	@Override
	@Transactional
	public void delete(Long id) {
		categoryRepository.delete(id);
		
	}
	@Override
	public List<String> findName() {
		List<CategoryEntity> categories = categoryRepository.findAll();
		List<String> name = new ArrayList<>();
		if(categories!=null) {
			for(CategoryEntity x: categories) {
				name.add(x.getName());
			}
		}
		return name;
	}
}
