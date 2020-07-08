package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.AllRepositories;
import com.example.demo.repository.UserDao;


@Service
@Transactional
public class AllInterfacesImpl implements AllInterfaces {
	
	
	private AllRepositories allR;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	public AllInterfacesImpl(AllRepositories allR) {
		this.allR = allR;
	}

	
	
	@Override
	public List<Product> findAll() {
		return allR.findAll();
	}

	@Override
	public Product findById(int theId) {
		 Optional<Product> optional =  allR.findById(theId);
		 Product user = optional.get();
		return user;
	}

	@Override
	public void save(Product product) {
		allR.save(product);
		
	}

	@Override
	public void deleteById(int theId) {
		allR.deleteById(theId);
	}

	@Override
	public List<Product> sortByIdAsc() {
        return allR.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<Product> sortByIdDesc() {
		 return allR.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	@Override
	public List<Product> sortByNameAsc() {
		return allR.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

	@Override
	public List<Product> sortByNameDesc() {
		return allR.findAll(Sort.by(Sort.Direction.DESC, "name"));
	}

	@Override
	public List<Product> sortByActualPriceAsc() {
		return allR.findAll(Sort.by(Sort.Direction.ASC, "actual_price"));
	}

	@Override
	public List<Product> sortByActualPriceDesc() {
		return allR.findAll(Sort.by(Sort.Direction.DESC, "actual_price"));
	}



	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password!");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}


	@Override
	@Transactional
	public User findByUserName(String username) {
		User user = userDao.findByName(username);
		return user;
	}


	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}


}
