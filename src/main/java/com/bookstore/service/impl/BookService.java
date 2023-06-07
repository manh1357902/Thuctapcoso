package com.bookstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.dto.BookDTO;
import com.bookstore.entity.BookEntity;
import com.bookstore.entity.CategoryEntity;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CategoryRepository;
import com.bookstore.service.IBookService;
import com.bookstore.service.convert.BookConvert;

@Service
public class BookService implements IBookService{
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookConvert bookConvert;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<BookDTO> findAll() {
		List<BookDTO> models = new ArrayList<>();
		List<BookEntity> entities = bookRepository.findAll();
		for (BookEntity item: entities) {
			BookDTO bookDTO = bookConvert.toDto(item);
			models.add(bookDTO);
		}
		return models;
	}
	@Override
	public BookDTO findById(Long id) {
		BookEntity bookEntity = bookRepository.findOne(id);
		return bookConvert.toDto(bookEntity);
	}
	@Override
	@Transactional
	public BookDTO save(BookDTO bookDTO) {
		BookEntity bookEntity = new BookEntity();
		CategoryEntity category =  categoryRepository.findOneByName(bookDTO.getCategoryname());
		if(category==null) {
			category = new CategoryEntity();
			category.setName(bookDTO.getCategoryname());
			categoryRepository.save(category);
			category =  categoryRepository.findOneByName(bookDTO.getCategoryname());
		}
		if(bookDTO.getId()!=null) {
			BookEntity oldBook = bookRepository.findOne(bookDTO.getId());
			oldBook.setCategory(category);
			bookEntity = bookConvert.toEntity(oldBook, bookDTO);
		}
		else {
			bookEntity = bookConvert.toEntity(bookDTO);
			bookEntity.setCategory(category);;
		}
		return bookConvert.toDto(bookRepository.save(bookEntity));
	}
	@Override
	@Transactional
	public void delete(Long x) {
		bookRepository.delete(x);			
	}
	@Override
	public Page<BookDTO> getBookByPage(int page, int size) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		Page<BookEntity> books = bookRepository.findAll(pageRequest);
		List<BookDTO> book1 = new ArrayList<>();
		for(BookEntity x: books.getContent()) {
			book1.add(bookConvert.toDto(x));
		}
		Page<BookDTO> book2 = new PageImpl<>(book1, pageRequest, book1.size());
		return book2;
	}
	@Override
    public int getTotalPages(int pageSize, int totalItems) {
        return (int) Math.ceil((double) totalItems / pageSize);
    }
	@Override
	public Page<BookDTO> getBookByCategory(int page, int size, CategoryEntity category) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		Page<BookEntity> books = bookRepository.findByCategory(category,pageRequest);
		List<BookDTO> book1 = new ArrayList<>();
		for(BookEntity x: books.getContent()) {
			book1.add(bookConvert.toDto(x));
		}
		Page<BookDTO> book2 = new PageImpl<>(book1, pageRequest, book1.size());
		return book2;
	}
	@Override
	public List<BookDTO> findByCategory(CategoryEntity category) {
		List<BookDTO> models = new ArrayList<>();
		List<BookEntity> entities = bookRepository.findByCategory(category);
		for (BookEntity item: entities) {
			BookDTO bookDTO = bookConvert.toDto(item);
			models.add(bookDTO);
		}
		return models;
	}
	@Override
	public Page<BookDTO> getBookByTitleOrAuthor(String keyword, int page, int size) {
		PageRequest pageRequest = new PageRequest(page-1, size);
		Page<BookEntity> books = bookRepository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(keyword, keyword, pageRequest);
		List<BookDTO> book1 = new ArrayList<>();
		for(BookEntity x: books.getContent()) {
			book1.add(bookConvert.toDto(x));
		}
		Page<BookDTO> book2 = new PageImpl<>(book1, pageRequest, book1.size());
		return book2;
	}
	@Override
	public List<BookDTO> findByTitleOrAuthor(String keyword) {
		List<BookDTO> models = new ArrayList<>();
		List<BookEntity> books = bookRepository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(keyword, keyword);
		for (BookEntity item: books) {
			BookDTO bookDTO = bookConvert.toDto(item);
			models.add(bookDTO);
		}
		return models;
	}




}
