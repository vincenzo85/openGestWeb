/**
 * <b>UserListServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione della lista degli utenti.
 * 
 */
package com.webapp.servlet.users;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opengest.core.business.services.UserSevice;
import com.opengest.core.business.vo.User;
import com.webapp.servlet.core.AppBaseServlet;
import com.webapp.web.BusinessDelegate;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class UserListServlet extends AppBaseServlet {


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

		BusinessDelegate bd = new BusinessDelegate();
		UserSevice userService = bd.retrieveUserService();
		
		try {
			List<User> userList = userService.listUsers();
			Vector<User> vector = new Vector<User>(userList);
			request.setAttribute("userList", vector);
			getServletContext().getRequestDispatcher("/WEB-INF/pages/restricted/users/userList.jsp").forward(request, response);
			
		} catch (Exception e) {
			manageErrors(request, response, "/WEB-INF/pages/restricted/users/userInit.jsp", e, "Errore durante il caricamento della lista utenti.");
		}
	}
}
