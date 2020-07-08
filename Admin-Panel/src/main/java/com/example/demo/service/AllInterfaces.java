package com.example.demo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;


public interface AllInterfaces extends UserDetailsService{

	public List<Product> findAll();
	public Product findById(int theId);
	public void save(Product product);
	public void deleteById(int theId);
	public List<Product> sortByIdAsc();
	public List<Product> sortByIdDesc();
	public List<Product> sortByNameAsc();
	public List<Product> sortByNameDesc();
	public List<Product> sortByActualPriceAsc();
	public List<Product> sortByActualPriceDesc();
	public User findByUserName(String username);

}
