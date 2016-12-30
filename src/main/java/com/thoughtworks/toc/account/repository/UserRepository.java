package com.thoughtworks.toc.account.repository;

import com.thoughtworks.toc.account.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByUsername(String username);

    List<User> findAll();
}
