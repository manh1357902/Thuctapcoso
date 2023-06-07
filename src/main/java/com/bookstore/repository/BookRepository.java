package com.bookstore.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.BookEntity;
import com.bookstore.entity.CategoryEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
	Page<BookEntity> findAll(Pageable pageable);
	Page<BookEntity> findByCategory(CategoryEntity category,Pageable pageable);
	List<BookEntity> findByCategory(CategoryEntity category);
	Page<BookEntity> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String keyword1, String keyword2, Pageable pageable);
	List<BookEntity> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String keyword1, String keyword2);
}
