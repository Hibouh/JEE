package com.annuaire.service;
import com.annuaire.model.Role;
import com.annuaire.model.User;
import com.annuaire.repo.RoleRepository;
import com.annuaire.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author LE Dan
 *
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
    	Set<Role> tmp = new HashSet<>();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        tmp.add(roleRepository.findByName(user.getRole()));
        user.setRoles(tmp);
        userRepository.save(user);
    }
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
