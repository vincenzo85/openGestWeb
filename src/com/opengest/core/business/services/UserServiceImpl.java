/**
 * <b> UserServiceImpl.java
 * 
 * <br/>
 * 
 * Classe facade per la gestione delle operazioni del modulo utente.
 * 
 */
package com.opengest.core.business.services;

import java.util.List;

import com.opengest.core.business.dao.UserDaoImpl;
import com.opengest.core.business.dto.UserDto;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.vo.User;
import com.webapp.web.utils.UserUtils;

/**
 * 
 * @author 2Clever.IT
 *
 */
public class UserServiceImpl implements UserSevice {

	/**
	 * Metodo per l'autorizzaizone dell'utente nella sessione di login.
	 */
	public boolean authorization(String username, String password) throws BusinessException {
		try {
			return new UserDaoImpl().authorization(username, password);
		} catch (Exception e) {
			throw new BusinessException("[UserServiceImpl.authorization]", e);
		}
	}

	/**
	 * Metodo finder per la ricerca dell'utente tramite il suo id (primary key).
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserDto findUserById(Long id) throws BusinessException {
		try {
			UserDto dto = UserUtils.fromUserVoToDto(new UserDaoImpl().findById(id));

			return dto;
		} catch (Exception e) {
			throw new BusinessException("[UserServiceImpl.findById]", e);
		}
	}

	/**
	 * Metodo finder per la ricerca dell'utente tramite il suo id (primary key).
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void deleteUser(Long id) throws BusinessException {
		try {
			new UserDaoImpl().delete(id);
		} catch (Exception e) {
			throw new BusinessException("[UserServiceImpl.delete]", e);
		}
	}

	/**
	 * Metodo per la registrazione dell'utente nella base dati.
	 * 
	 * @param dto
	 *            void
	 *
	 */
	public void saveUser(UserDto dto) throws BusinessException {
		try {
			new UserDaoImpl().save(UserUtils.fromUserDtoToVo(dto));

		} catch (Exception e) {
			throw new BusinessException("[UserServiceImpl.save]", e);
		}
	}

	/**
	 * Metodo per la modifica dell'utente nella base dati.
	 * 
	 * @param user
	 *            void
	 *
	 */
	public void updateUser(UserDto dto) throws BusinessException {
		try {
			new UserDaoImpl().update(UserUtils.fromUserDtoToVo(dto));
		} catch (Exception e) {
			throw new BusinessException("[UserServiceImpl.update]", e);
		}
	}

	/**
	 * Metodo per la registrazione dell'utente nella base dati.
	 * 
	 * @param user
	 *            void
	 *
	 */
	public List<User> listUsers() throws BusinessException {
		try {
			return new UserDaoImpl().findAll();
		} catch (Exception e) {
			throw new BusinessException("[UserServiceImpl.findAll]", e);
		}
	}

	/**
	 * Metodo per il controllo sull'esistenza di uno username.
	 * 
	 * @param username
	 * @return
	 * @throws BusinessException
	 */
	public boolean existUsername(String username) throws BusinessException {
		try {
			return new UserDaoImpl().exist(username);
		} catch (Exception e) {
			throw new BusinessException("[UserServiceImpl.existUsername]", e);
		}
	}

	/**
	 * Metodo per la ricerca dello user in base allo username.
	 * 
	 * @param username
	 * @return
	 * @throws BusinessException
	 */
	public UserDto findByUsername(String username) throws BusinessException {
		try {
			UserDto dto = UserUtils.fromUserVoToDto(new UserDaoImpl().findByUsername(username));
			return dto;
		} catch (Exception e) {
			throw new BusinessException("[UserServiceImpl.findByUsername]", e);
		}
	}

}
