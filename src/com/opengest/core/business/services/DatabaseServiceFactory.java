package com.opengest.core.business.services;

import com.webapp.web.utils.ConfigBean;

public class DatabaseServiceFactory {

	private static JdbcService _jdbcService;

	public static void initServices(ConfigBean configs) {

		_jdbcService = JdbcServiceImpl.getInstance(configs);
	}

	public static void terminateServices() throws RuntimeException {
		
		_jdbcService.terminateServices();
	}

	/**
	 * restituisce una istanza del servizio database tramite JDBC.
	 * 
	 * @return
	 */
	public static JdbcService getJdbcDatabaseService() {

		if (_jdbcService == null)
			throw new RuntimeException("Servizio non disponibile");

		return _jdbcService;
	}
}
