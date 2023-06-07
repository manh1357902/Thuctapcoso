package com.bookstore.service;

import java.util.List;

import com.bookstore.dto.UsersDTO;

public interface IUserService {
	List<UsersDTO> findAll();
	UsersDTO findOneById(Long id);
	UsersDTO findOneByUserName(String userName);
	UsersDTO save(UsersDTO user);
}
