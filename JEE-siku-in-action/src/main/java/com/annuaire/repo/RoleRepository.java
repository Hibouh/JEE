package com.annuaire.repo;

import com.annuaire.model.Role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 
 * @author LE Dan
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
    List <Role> findAll();
    Role findByName(Object element);
    Role findById(long id);
}
