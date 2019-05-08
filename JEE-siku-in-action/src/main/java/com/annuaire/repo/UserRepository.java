package com.annuaire.repo;


import com.annuaire.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 * 
 * @author LE Dan
 *
 */

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
    List <User> findAll();
    
    List<User> findByRoles(String roles);
    List<User> findByRole(String o);
    
    @Query("SELECT u FROM User u where username=?1 or firstName=?1 or lastName=?1 or role=?1")
    List <User> findBySearch(String name);
}
