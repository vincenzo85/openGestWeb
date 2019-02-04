/**
 * <b>UserServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione delle operazioni utenti.
 * 
 */
package com.webapp.servlet.users;

/**
 * 
 * @author 2Clever.it
 *
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opengest.core.business.dto.UserDto;
import com.opengest.core.business.services.UserSevice;
import com.webapp.servlet.core.AppBaseServlet;
import com.webapp.web.BusinessDelegate;

/**
 * Servlet implementation class UserServlet
 */

public class UserServlet extends AppBaseServlet {
	
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {

		String userid = request.getParameter("userId");
		
		BusinessDelegate bd = new BusinessDelegate();
		UserSevice userService = bd.retrieveUserService();
		HttpSession session = request.getSession(false);
		
		if(request.getServletPath().equals("/users/createinit")) {
			
			// Richiesta creazione utente
			try {
				UserDto user = new UserDto();
				session.setAttribute("userdata", user);
				getServletContext().getRequestDispatcher("/WEB-INF/pages/restricted/users/newuser.jsp").forward(request, response);
				
			} catch (Exception e) {
				manageErrors(request, response, "/users/create", e, "Errore durante il caricamento dell'utente.");
			}
			
		} else if(request.getServletPath().equals("/users/create")) {
			
			// Richiesta creazione utente
			UserDto user = new UserDto();
			String username = request.getParameter("username");
			user.setUsername(username);
			String password = request.getParameter("password");
			user.setPassword(password);
			String email = request.getParameter("email");
			user.setEmail(email);
			String nome = request.getParameter("nome");
			user.setNome(nome);
			String cognome = request.getParameter("cognome");
			user.setCognome(cognome);
			
			try {
					userService.saveUser(user);
					getServletContext().getRequestDispatcher("/users/list").forward(request, response);
			} catch (Exception e) {
				request.setAttribute("form", user);
				manageErrors(request, response, "/users/list", e, "Errore durante la creazione dell'utente.");
			}
			
		} else if(request.getServletPath().equals("/users/updateinit")) {
			
			// Richiesta modifica utente.
			try {
				UserDto user = userService.findUserById(new Long(userid));
				session.setAttribute("userdata", user);
				getServletContext().getRequestDispatcher("/WEB-INF/pages/restricted/users/user.jsp").forward(request, response);
			} catch (Exception e) {
				manageErrors(request, response, "/users/list", e, "Errore durante il caricamento dell'utente.");
			}
			
		} else if(request.getServletPath().equals("/users/update")) {
			
			// Richiesta modifica utente.
			UserDto user = new UserDto();
			String userId = request.getParameter("userid");
			user.setId(new Long(userId));
			String username = request.getParameter("username");
			user.setUsername(username);
			String password = request.getParameter("password");
			user.setPassword(password);
			String email = request.getParameter("email");
			user.setEmail(email);
			String nome = request.getParameter("nome");
			user.setNome(nome);
			String cognome = request.getParameter("cognome");
			user.setCognome(cognome);
			try {
					userService.updateUser(user);
					getServletContext().getRequestDispatcher("/users/list").forward(request, response);
			}catch (Exception e) {
				request.setAttribute("form", user);
				manageErrors(request, response, "/WEB-INF/pages/restricted/users/user.jsp", e, "Errore durante la modifica dell'utente.");
			}
			
		} else if(request.getServletPath().equals("/users/delete")) {
			
			// Richiesta eliminazione utente.
			try {
					userService.deleteUser(new Long(userid));
					getServletContext().getRequestDispatcher("/users/list").forward(request, response);
			} catch (Exception e) {
				manageErrors(request, response, "/users/list", e, "Errore durante l'eliminazione dell'utente.");
			}
			
		} 
		
	}
	

}
