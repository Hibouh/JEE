package com.annuaire.service;

import com.annuaire.model.Role;
import com.annuaire.model.User;
/**
 * 
 * @author LE Dan
 *
 */
public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
