/**
 * <b>AppBaseServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione dei metodi di base comuni.
 * 
 */
package com.webapp.servlet.core;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class AppBaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String BUNDLE_NAME_PREFIX = "i18n.messages";
	
	/**
	 * Recupera un messaggio dal resource bundle
	 * 
	 * @param bundleKey
	 * @param currentLocale
	 * @return
	 */
	protected String getMessageFromBundle(String bundleKey, Locale currentLocale) {
		String message = "";
		message = getCurrentBundle(currentLocale).getString(bundleKey);
		return message;
	}
	
	/**
	 * Recupera un messaggio dal resource bundle con gestione dei parametri
	 * 
	 * @param key
	 * @param currentLocale
	 * @param params
	 * @return
	 */
	public String getMessageFromBundle(String key, Locale currentLocale, Object... params  ) {
        try {
            return MessageFormat.format(getCurrentBundle(currentLocale).getString(key), params);
        } catch (MissingResourceException e) {
            return "!!!" + key + "!!!";
        }
    }
	
	/**
	 * Recupero del ResourceBundle corrente, default in caso di non gestione della lingua utente.
	 * @param currentLocale
	 * @return
	 */
	private ResourceBundle getCurrentBundle(Locale currentLocale) {
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME_PREFIX, currentLocale);
		if(bundle == null) {
			bundle = ResourceBundle.getBundle(BUNDLE_NAME_PREFIX, Locale.ENGLISH);
		}
		return bundle;
	}
	
	/**
	 * Metodo che gestisce gli errori applicativi:
	 * 1. log.
	 * 2. gestione della redirect in seguito all'errore.
	 * 
	 * @param request
	 * @param response
	 * @param errorPage
	 * @param ex
	 */
	protected void manageErrors(HttpServletRequest request, HttpServletResponse response, 
								String errorPage, Exception ex, String errorMessage) {
		try {
			
			request.setAttribute("errorMsg", errorMessage);
			getLogger().error(errorMessage);
			getLogger().error(this.getClass());
			getLogger().error(ex.getLocalizedMessage());
			getServletContext().getRequestDispatcher(errorPage).forward(request, response);
			
		} catch (Exception e) {
			getLogger().error(e);
		}
	}
	
	/**
	 * Metodo che restituisce il logger dell'applicazione.
	 * @return
	 */
	protected Log getLogger() {
		return LogFactory.getLog(this.getClass());
	}
}
