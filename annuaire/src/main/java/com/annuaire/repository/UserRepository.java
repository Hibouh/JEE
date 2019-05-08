package com.annuaire.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.annuaire.model.User;
/**
 * 
 * @author LE Dan
 *
 */

public interface UserRepository extends JpaRepository<User, Long>{
	/**
	 * search user with her username
	 * @param username entity username
	 * @return user found
	 */
    User findByUsername(String username);
    /**
     * create a list and add all user
     */
    List <User> findAll();
    /**
     * create list and add all users
     * @param roles entity roles
     * @return list user found
     */
    List<User> findByRoles(String roles);
    /**
     * Create a list and add user found by her role
     * @param o role
     * @return list user found
     */
    List<User> findByRole(String o);
    /**
     * Create a list and add user four by her firstname, lastname and role
     * @param name
     * @return list user found
     */
    @Query("SELECT u FROM User u where firstName=?1 or lastName=?1 or role=?1")
    List <User> findBySearch(String name);
}
