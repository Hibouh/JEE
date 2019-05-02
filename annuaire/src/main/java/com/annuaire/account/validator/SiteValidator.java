package com.annuaire.account.validator;

import java.net.URL;

public class SiteValidator {
public boolean isValid(String url) {

    try { 
        new URL(url).toURI(); 
        return true; 
    } 
      
    catch (Exception e) { 
        return false; 
    } 
}
}
