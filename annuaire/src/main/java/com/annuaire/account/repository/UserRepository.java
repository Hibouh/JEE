package com.annuaire.account.repository;

import com.annuaire.account.model.User;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
    List <User> findAll();
}
