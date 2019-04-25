package com.annuaire.service;


import javax.servlet.http.HttpServletRequest;

public interface ISecurityService {
	
	/**
	 * Login a given email/password after registration
	 * @param email
	 * @param password
	 * @param request
	 */
	void autologin(String email, String password, HttpServletRequest request);
}
