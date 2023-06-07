package com.bookstore.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class BookDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String title;
	private Double price;
	private String author;
	private String img;
	private MultipartFile img1;
	private String description;
	private int quantity;
	private Long page;
	private String publisher;
	private Long categoryId;
	private String categoryname;
	private String convertPrice;

	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getConvertPrice() {
		return convertPrice;
	}
	public void setConvertPrice(String convertPrice) {
		this.convertPrice = convertPrice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public MultipartFile getImg1() {
		return img1;
	}
	public void setImg1(MultipartFile img1) {
		this.img1 = img1;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
