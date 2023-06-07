package com.bookstore.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.bookstore.dto.BookDTO;
import com.bookstore.entity.CategoryEntity;

public interface IBookService {
	List<BookDTO> findAll();
	BookDTO findById(Long id);
	BookDTO save(BookDTO bookDTO);
	Page<BookDTO> getBookByPage(int page, int size);
	void delete(Long x);
	int getTotalPages(int pageSize, int x);
	Page<BookDTO> getBookByCategory(int page, int size,CategoryEntity category);
	List<BookDTO> findByCategory(CategoryEntity category);
	Page<BookDTO> getBookByTitleOrAuthor(String keyword,int page, int size);
	List<BookDTO> findByTitleOrAuthor(String keyword); 
}
