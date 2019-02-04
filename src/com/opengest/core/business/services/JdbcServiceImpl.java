/**
 * JdbcServiceImpl.java
 *
 * robgion
 * www.2clever.it
 * 
 * 05 lug 2017
 * For further information please write to info@2clever.it
 */
package com.opengest.core.business.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.webapp.web.utils.ConfigBean;

/**
 * @author robgion
 *
 *         Classe servizio per l'inzializzazione e gestione delle connessioni a
 *         database.
 */
class JdbcServiceImpl implements JdbcService {

	private static JdbcServiceImpl _instance = null;

	private static ConfigBean config = null;

	private JdbcServiceImpl(ConfigBean cb) throws RuntimeException {

		try {
			config = cb;
			Class.forName(cb.getDatabaseDriver());
			
		} catch (Exception e) {

			throw new RuntimeException("Errore durante il caricamento del driver", e);
		}
	}

	public static JdbcServiceImpl getInstance(ConfigBean cb) throws RuntimeException {
		if (_instance == null) {
			_instance = new JdbcServiceImpl(cb);
		}
		return _instance;
	}

	public static JdbcService getConfiguredInstance() throws RuntimeException {

		if (config == null)
			throw new RuntimeException("Configurazione mancante");

		if (_instance == null)
			throw new RuntimeException("Configurazione mancante");

		return _instance;
	}

	@Override
	public Connection getDatabaseConnection() throws SQLException {
		return DriverManager.getConnection(config.getDatabaseUrl(), config.getDatabaseUsername(),
				config.getDatabasePassword());
	}

	/* (non-Javadoc)
	 * @see it.webapp.model.services.DatabaseService#terminateServices()
	 */
	@Override
	public void terminateServices() {
		// TODO Auto-generated method stub
		
	}

}
