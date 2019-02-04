/**
 * <b>CustomerListServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione della lista dei clienti.
 * 
 */
package com.webapp.servlet.customers;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opengest.core.business.services.CustomerSevice;
import com.opengest.core.business.vo.Customer;
import com.webapp.web.BusinessDelegate;
import com.webapp.web.utils.IAppCostants;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class CustomerListServlet extends HttpServlet {


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
		CustomerSevice customerService = bd.retrieveCustomerService();
		
		try {
			List<Customer> customerList = customerService.listCustomers();
			Vector<Customer> vector = new Vector<Customer>(customerList);
			request.setAttribute("customerList", vector);
			getServletContext().getRequestDispatcher("/WEB-INF/pages/restricted/customers/customerList.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("errorMsg", "Errore durante il caricamento della lista clienti." +
					"Contattare HelpDesk.");
			try {
				getServletContext().getRequestDispatcher("/WEB-INF/pages/restricted/customers/customerList.jsp").forward(request, response);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
