package com.annuaire.service;
/**
 * 
 * @author LE Dan
 *
 */
public interface SecurityService {
	/**
	 * Search log in username
	 * @return
	 */
    String findLoggedInUsername();
    /**
     * auto log in
     * @param username
     * @param password
     */
    void autologin(String username, String password);
}
