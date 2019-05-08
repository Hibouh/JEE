package com.annuaire.service;

import com.annuaire.model.User;
/**
 * 
 * @author LE Dan
 *
 */
public interface UserService {
	/**
	 * save user in db
	 * @param user
	 */
    void save(User user);
    /**
     * find username 
     * @param username
     * @return
     */
    User findByUsername(String username);
}
