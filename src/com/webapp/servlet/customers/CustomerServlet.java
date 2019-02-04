/**
 * <b>CustomerServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione delle operazioni clienti.
 * 
 */
package com.webapp.servlet.customers;

/**
 * 
 * @author Roberto Giontella
 *
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opengest.core.business.dto.CustomerDto;
import com.opengest.core.business.services.CustomerSevice;
import com.webapp.web.BusinessDelegate;
import com.webapp.web.utils.IAppCostants;

/**
 * Servlet implementation class CustomerServlet
 */

public class CustomerServlet extends HttpServlet {
	
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

		String customerId = request.getParameter(IAppCostants.REQUEST_PARAM_CUSTOMER_ID);
		
		BusinessDelegate bd = new BusinessDelegate();
		CustomerSevice customerService = bd.retrieveCustomerService();
		
		if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_CUSTOMERS_UPDATE_INIT)) {
			
			// Richiesta modifica cliente.
			try {
				CustomerDto customer = customerService.findCustomerById(new Long(customerId));
				request.setAttribute(IAppCostants.SESSION_PARAM_REQUEST_CUSTOMER, customer);
				getServletContext().getRequestDispatcher("/WEB-INF/pages/restricted/customer/customer.jsp").forward(request, response);
			} catch (Exception e) {
				try {
					request.setAttribute("errorMsg", "Errore durante il caricamento della cliente." +
							"Contattare HelpDesk.");
					getServletContext().getRequestDispatcher("/WEB-INF/pages/restricted/customers/customerList.jsp").forward(request, response);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_CUSTOMERS_DELETE)) {
			
			// Richiesta eliminazione cliente.
			try {
					customerService.deleteCustomer(new Long(customerId));
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_CUSTOMERS_LIST).forward(request, response);
			} catch (Exception e) {
				try {
					request.setAttribute("errorMsg", "Errore durante il caricamento della cliente." +
							"Contattare HelpDesk.");
					getServletContext().getRequestDispatcher("/WEB-INF/pages/restricted/customers/customerList.jsp").forward(request, response);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_CUSTOMERS_UPDATE)) {
			
			// Richiesta modifica cliente.
			try {
				CustomerDto customer = registerCustomerforUpdate(request);
				customerService.updateCustomer(customer);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_CUSTOMERS_LIST).forward(request, response);
			}catch (Exception e) {
				try {
					request.setAttribute("errorMsg", "Errore durante il caricamento della cliente." +
							"Contattare HelpDesk.");
					getServletContext().getRequestDispatcher("/WEB-INF/pages/restricted/customers/customerList.jsp").forward(request, response);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_CUSTOMERS_CREATE_INIT)) {
			
			// Richiesta creazione cliente.
			try {
				CustomerDto customer = new CustomerDto();
				request.setAttribute(IAppCostants.SESSION_PARAM_REQUEST_CUSTOMER, customer);
				getServletContext().getRequestDispatcher("/WEB-INF/pages/customers/newCustomer.jsp").forward(request, response);
			} catch (Exception e) {
				try {
					request.setAttribute("errorMsg", "Errore durante il caricamento della cliente." +
							"Contattare HelpDesk.");
					getServletContext().getRequestDispatcher("/WEB-INF/pages/restricted/customers/customerList.jsp").forward(request, response);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_CUSTOMERS_CREATE)) {
			
			// Richiesta creazione cliente
			CustomerDto customer = registerCustomerforUpdate(request);
			try {
					customerService.saveCustomer(customer);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_CUSTOMERS_LIST).forward(request, response);
			} catch (Exception e) {
				try {
					request.setAttribute("errorMsg", "Errore durante il caricamento della cliente." +
							"Contattare HelpDesk.");
					getServletContext().getRequestDispatcher("/WEB-INF/pages/restricted/customers/customerList.jsp").forward(request, response);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		}
		
	}
	
    public CustomerDto registerCustomerforUpdate(HttpServletRequest request) {
    	
		String id = request.getParameter("customerid");
		CustomerDto cust = null;
		CustomerSevice customerSevice = new BusinessDelegate().retrieveCustomerService();
		try {
			cust = customerSevice.findCustomerById(new Long(id));
			cust.setCode(request.getParameter("code"));
			cust.setRagsoc(request.getParameter("ragsoc"));
			cust.setPiva(new Long(request.getParameter("piva")));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	return cust;
} 
}
