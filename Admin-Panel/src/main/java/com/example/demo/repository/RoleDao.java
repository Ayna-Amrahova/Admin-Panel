package com.example.demo.repository;

import com.example.demo.entity.Role;

public interface RoleDao {
	
	public Role findByName(String theRoleName);

}
