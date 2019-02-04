/**
 * <b> BusinessDelegate.java
 * 
 * <br/>
 * 
 * Classe delegate per il recupero dei servizi.
 * 
 */
package com.webapp.web;

import com.opengest.core.business.services.CustomerServiceImpl;
import com.opengest.core.business.services.CustomerSevice;
import com.opengest.core.business.services.UserSevice;
import com.opengest.core.business.services.UserServiceImpl;


/**
 * 
 * @author 2Clever.IT
 *
 */
public class BusinessDelegate {

	/**
	 * Recupera il servizio legato alle operazioni utente.
	 * @return
	 */
	public UserSevice retrieveUserService() {
		return new UserServiceImpl();
	}

	/**
	 * Recupera il servizio legato alle operazioni cliente.
	 * @return
	 */
	public CustomerSevice retrieveCustomerService() {
		return new CustomerServiceImpl();
	}
	
}
