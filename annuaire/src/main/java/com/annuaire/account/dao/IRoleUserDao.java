package com.annuaire.account.dao;

import com.annuaire.account.model.Role;
import com.annuaire.account.model.User;


public interface IRoleUserDao {
	void saveRole(Role g);
	void saveUser(User p);
}
