/**
 * UserDao.java
 *
 * robgion
 * www.2clever.it
 * 
 * 30 nov 2017
 * For further information please write to info@2clever.it
 */
package com.opengest.core.business.dao;

import java.sql.SQLException;
import java.util.List;

import com.opengest.core.business.vo.User;

/**
 * @author robgion
 *
 */
public interface UserDao {

	/**
	 * Metodo che controlla l'autorizzazione dell'utente durante il login.
	 * 
	 * @param username
	 * @param password
	 * @return boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 *
	 */
	boolean authorization(String username, String password) throws SQLException;

	User findByUsername(String username) throws SQLException;

	/**
	 * Metodo finder per la ricerca dell'utente tramite il suo id (primary key).
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	User findById(Long id) throws SQLException;

	/**
	 * Metodo per la cancellazione dell'utente tramite il suo id (primary key).
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	void delete(Long id) throws SQLException;

	/**
	 * Metodo per la registrazione dell'utente nella base dati.
	 * 
	 * @param user
	 *            void
	 * @throws Exception
	 *
	 */
	void save(User user) throws SQLException;

	/**
	 * Metodo per la modifica dell'utente nella base dati.
	 * 
	 * @param user
	 *            void
	 * @throws Exception
	 *
	 */
	void update(User user) throws SQLException;

	/**
	 * Metodo finder per la ricerca di tutti gli utenti.
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	List<User> findAll() throws SQLException;

	/**
	 * Metodo per il controllo dell'esistenza di uno username
	 * 
	 * @param sql
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	boolean exist(String username) throws SQLException, Exception;

}