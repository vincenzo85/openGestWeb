/**
 * CustomerDao.java
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

import com.opengest.core.business.vo.Customer;

/**
 * @author robgion
 *
 */
public interface CustomerDao {

	/**
	 * Metodo finder per la ricerca del cliente tramite il suo id (primary key).
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	Customer findById(Long id) throws SQLException, Exception;

	/**
	 * Metodo per la cancellazione del cliente tramite il suo id (primary key).
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	void delete(Long id) throws SQLException;

	/**
	 * Metodo per la registrazione del cliente nella base dati.
	 * 
	 * @param product
	 *            void
	 * @throws Exception
	 *
	 */
	void save(Customer product) throws SQLException, Exception;

	/**
	 * Metodo per la modifica del cliente nella base dati.
	 * 
	 * @param product
	 *            void
	 * @throws Exception
	 *
	 */
	void update(Customer product) throws SQLException, Exception;

	/**
	 * Metodo finder per la ricerca di tutti i prodotti.
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	List<Customer> findAll() throws SQLException, Exception;

	/**
	 * Metodo per il controllo dell'esistenza di un codice cliente.
	 * 
	 * @param sql
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	boolean exist(String code) throws SQLException;

}