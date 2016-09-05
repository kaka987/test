package com.thoughtworks.toc.account.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thoughtworks.toc.account.model.User;

@Repository
@Transactional
public class UserDAO 
{
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<User> getAllUsers() 
	{
		
		List<User> users = manager.createQuery("SELECT u FROM User u", User.class).getResultList();
        return users;
	}
	
	public void save() {
		
		User user = new User("kkk","123333",12);
		manager.persist(user);
	}
	
	
}
