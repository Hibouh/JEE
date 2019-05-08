package com.annuaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annuaire.model.Role;
/**
 * 
 * @author LE Dan
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
	/**
	 * Create list and add all role
	 */
    List <Role> findAll();
    /**
     * search a name in object role
     * @param element name research
     * @return list
     */
    Role findByName(Object element);
    
    /**
     * Search a id in object role
     * @param element long id
     * @return role
     */
    Role findById(Object element);
}
