package com.annuaire.service;
import java.util.Collection;

import com.annuaire.model.Group;


public interface IGroupService {
	

	public Collection<Group> findAll();
	

	public Group findById(int id);
}