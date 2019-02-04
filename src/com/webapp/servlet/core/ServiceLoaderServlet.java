/**
 * <b>ServiceLoaderServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per il caricamento dei servizi dell'applicazione.
 * 
 */
package com.webapp.servlet.core;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.opengest.core.business.services.DatabaseServiceFactory;
import com.webapp.web.utils.ConfigBean;

/**
 * 
 * @author 2Clever.IT
 *
 */
public class ServiceLoaderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// 1. Creazione del bean di configurazione
		
		ConfigBean cb = new ConfigBean();
		
		// 2. Recupero dei paramentri di configurazione da file esterno
		String driver = getInitParameter("DATABASE_DRIVER");
		String url = getInitParameter("DATABASE_URL");
		String username = getInitParameter("DATABASE_USERNAME");
		String password = getInitParameter("DATABASE_PASSWORD");
		String jpaPU = getInitParameter("JPA_PRESISTENCE_UNIT");
		
		cb.setDatabaseDriver(driver);
		cb.setDatabaseUrl(url);
		cb.setDatabaseUsername(username);
		cb.setDatabasePassword(password);
		cb.setJpaName(jpaPU);
		
		// 3. Attivazione e configurazione dei servizi DB.
		try {
			DatabaseServiceFactory.initServices(cb);
			
		} catch (Exception e) {
			System.err.println("Errore grave durante la configurazione del database.");
			e.printStackTrace();
		}
		
	}

	@Override
	public void destroy() {
		
		// Terminazione del servizio.
	}
}
