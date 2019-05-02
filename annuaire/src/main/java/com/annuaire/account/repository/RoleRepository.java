package com.annuaire.account.repository;

import com.annuaire.account.model.Role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
    List <Role> findAll();
}
