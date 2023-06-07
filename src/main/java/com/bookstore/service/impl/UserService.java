package com.bookstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.dto.UsersDTO;
import com.bookstore.entity.RoleEntity;
import com.bookstore.entity.UserEntity;
import com.bookstore.repository.RoleRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.IUserService;
import com.bookstore.service.convert.UserConvert;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserConvert userConvert;
	@Autowired 
	private RoleRepository roleRepository;
	@Override
	public List<UsersDTO> findAll() {
		List<UsersDTO> users = new ArrayList<>();
		List<UserEntity> list = userRepository.findAll();
		for(UserEntity item:list) {
			UsersDTO user = new UsersDTO();
			user = userConvert.toDto(item);
			users.add(user);
		}
		return users;
	}
	@Override
	@Transactional
	public UsersDTO save(UsersDTO user) {
		UserEntity userEntity = new UserEntity();
		if (user.getId() != null) {
			UserEntity oldUser = userRepository.findOne(user.getId());
			userEntity = userConvert.toEntity(oldUser, user);
		} else {
			userEntity = userConvert.toEntity(user);
			List<RoleEntity> roles = new ArrayList<>();
			roles.add(roleRepository.findOneByCode("USER"));
			userEntity.setRoles(roles);
		}
		return userConvert.toDto(userRepository.save(userEntity));
	}
	@Override
	public UsersDTO findOneByUserName(String userName) {
		UserEntity userEntity = userRepository.findOneByUserName(userName);
		return userConvert.toDto(userEntity);
	}
	@Override
	public UsersDTO findOneById(Long id) {
		return userConvert.toDto(userRepository.findOne(id));
	}





}
