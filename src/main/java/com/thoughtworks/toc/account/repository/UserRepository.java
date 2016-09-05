package com.thoughtworks.toc.account.repository;

import com.thoughtworks.toc.account.model.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByUsername(String username);
}
