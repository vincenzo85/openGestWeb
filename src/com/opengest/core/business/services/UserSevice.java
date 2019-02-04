/**
 * <b> UserSevice.java
 * 
 * <br/>
 * 
 * Interfaccia di servizio per le utilit� riguardanti il modulo di amministrazione utenti.
 * 
 */
package com.opengest.core.business.services;

import java.util.List;

import com.opengest.core.business.dto.UserDto;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.vo.User;


/**
 * @author 2Clever.IT
 * 
 */
public interface UserSevice {
	
	boolean authorization(String username, String password) throws Exception ;
	
	UserDto findUserById(Long id) throws BusinessException;
	
	void saveUser(UserDto user) throws BusinessException;
	
	void updateUser(UserDto user) throws BusinessException;
	
	List<User> listUsers() throws BusinessException;
	
	void deleteUser(Long id) throws BusinessException;

	boolean existUsername(String username) throws BusinessException;
	
	public UserDto findByUsername(String username) throws BusinessException;
}
