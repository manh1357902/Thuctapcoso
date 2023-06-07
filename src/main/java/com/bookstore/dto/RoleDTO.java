package com.bookstore.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import com.bookstore.entity.UserEntity;

public class RoleDTO {
	private Long id;
	private String name;	
	@Column(name = "code")
	private String code;
    private List<UserEntity> users = new ArrayList<>();
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
}
