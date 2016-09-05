package com.thoughtworks.toc.account.service;

import com.thoughtworks.toc.account.model.User;
import com.thoughtworks.toc.account.dao.UserDAO;
import com.thoughtworks.toc.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class  UserService {
    @Autowired
    private UserDAO dao;
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
		return dao.getAllUsers();
	}
    
    public void save() {
    	dao.save();
    }
    
}

