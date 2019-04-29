package com.annuaire.account.service;

import com.annuaire.account.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
