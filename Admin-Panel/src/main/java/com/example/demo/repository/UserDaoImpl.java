package com.example.demo.repository;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private EntityManager entityManager;


	@Override
	public User findByName(String theUserName) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query <User> theQuery = currentSession.createQuery("from User where username=:uName", User.class);
		theQuery.setParameter("uName", theUserName);
		
		User theuser = null;
		
		try {
			theuser = theQuery.getSingleResult();
		}catch(Exception e) {
			theuser = null;
		}
		
		return theuser;
	}

}
