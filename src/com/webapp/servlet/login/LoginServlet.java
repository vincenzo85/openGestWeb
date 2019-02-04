/**
 * <b>LoginServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione del login applicativo.
 * 
 */
package com.webapp.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opengest.core.business.dto.UserDto;
import com.opengest.core.business.services.UserSevice;
import com.webapp.servlet.core.AppBaseServlet;
import com.webapp.web.BusinessDelegate;
import com.webapp.web.utils.IAppCostants;


/**
 * 
 * @author 2Clever.IT
 *
 */
public class LoginServlet extends AppBaseServlet {
	
	private static final long serialVersionUID = 1L;
       
	private long sessionsCount = 0l;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		++this.sessionsCount;
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.removeAttribute("loggedUser");
			session.invalidate();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_LOGIN)) {
		
			// Richiesto login.
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			BusinessDelegate bd = new BusinessDelegate();
			UserSevice userService = bd.retrieveUserService();
			
			try {
				if(userService.authorization(username, password)) {
					UserDto user = userService.findByUsername(username);
					
					HttpSession session = request.getSession(true);
					session.setAttribute("loggedUser", user);
					
					++this.sessionsCount;
					
					Cookie counterCookie = new Cookie("SESSION_COUNT", String.valueOf(this.sessionsCount));
					counterCookie.setMaxAge(10);
					response.addCookie(counterCookie);
					getServletContext().getRequestDispatcher("/WEB-INF/pages/restricted/welcome.jsp").forward(request, response);
				} else {
					String message = getMessageFromBundle("errors.invalid", request.getLocale(), "Login");
					request.setAttribute("errorMsg", message);
					getServletContext().getRequestDispatcher("/WEB-INF/pages/login/login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMsg", "Errore durante la procedura di login.\n " +
						"Contattare HelpDesk.");
			}
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_LOGOUT)) {
			// Richiesto logout.
			HttpSession currentSession = request.getSession(false);
			if(currentSession != null) {
				currentSession.removeAttribute("loggedUser");
				currentSession.invalidate();
			}
			getServletContext().getRequestDispatcher("/WEB-INF/pages/login/login.jsp").forward(request, response);
		}
	}

	
}
