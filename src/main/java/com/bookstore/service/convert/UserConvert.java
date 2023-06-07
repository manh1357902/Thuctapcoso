package com.bookstore.service.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bookstore.dto.UsersDTO;
import com.bookstore.entity.UserEntity;

@Component
public class UserConvert {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public UsersDTO toDto(UserEntity entity) {
		UsersDTO result = new UsersDTO();
		try {
			result.setUserName(entity.getUserName());
			result.setPassWord(entity.getPassword());
			try {
				result.setFullName(entity.getFullName());
				result.setId(entity.getId());
				result.setGender(entity.getGender());
				result.setPassWord(entity.getPassword());
				result.setPhone(entity.getPhone());
				result.setAddress(entity.getAddress()); 
				result.setDateOfBirth(entity.getDateOfBirth());
				}
			catch(Exception e) {				
			}
		}catch(Exception e) {

		}
		return result;
	}
	
	public UserEntity toEntity(UsersDTO dto) {
		UserEntity result = new UserEntity();
		result.setUserName(dto.getUserName());
		result.setFullName(dto.getFullName());
		result.setGender(dto.getGender());
		result.setDateOfBirth(dto.getDateOfBirth());
		if(dto.getPassWord().startsWith("$2a$10$"))
			result.setPassword(dto.getPassWord());			
		else
			result.setPassword(passwordEncoder.encode(dto.getPassWord()));
		result.setPhone(dto.getPhone());	
		result.setAddress(dto.getAddress());
		
		result.setDateOfBirth(dto.getDateOfBirth());
		return result;
	}
	public UserEntity toEntity1(UsersDTO dto) {
		UserEntity result = new UserEntity();
		result.setId(dto.getId());
		result.setUserName(dto.getUserName());
		result.setFullName(dto.getFullName());
		result.setGender(dto.getGender());
		result.setDateOfBirth(dto.getDateOfBirth());
		if(dto.getPassWord().startsWith("$2a$10$"))
			result.setPassword(dto.getPassWord());			
		else
			result.setPassword(passwordEncoder.encode(dto.getPassWord()));
		result.setPhone(dto.getPhone());	
		result.setAddress(dto.getAddress());
		result.setDateOfBirth(dto.getDateOfBirth());
		return result;
	}
	public UserEntity toEntity(UserEntity result, UsersDTO dto) {		
		result.setUserName(dto.getUserName());
		result.setFullName(dto.getFullName());
		result.setGender(dto.getGender());
		if(dto.getPassWord().startsWith("$2a$10$"))
			result.setPassword(dto.getPassWord());			
		else
			result.setPassword(passwordEncoder.encode(dto.getPassWord()));
		result.setPhone(dto.getPhone());
		result.setDateOfBirth(dto.getDateOfBirth());
		result.setAddress(dto.getAddress());
		return result;
	}

}
