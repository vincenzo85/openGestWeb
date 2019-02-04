package com.webapp.web.utils;

public interface IAppCostants {

	static final String CONTEXT_PATH_LOGIN = "/login";
	static final String CONTEXT_PATH_LOGOUT = "/logout";
	static final String CONTEXT_PATH_MENU_USERS = "/usersMenu";
	
	static final String REQUEST_PARAM_CUSTOMER_ID 	 = "customerid";
	static final String REQUEST_PARAM_CUSTOMER_LIST  = "customerList";

	/** Session parameters errors. */
	static final String SESSION_PARAM_LOGGED_USER 		= "loggedUser";
	static final String SESSION_PARAM_REQUEST_USER 		= "userdata";
	static final String SESSION_PARAM_REQUEST_USER_MOD 	= "userdatam";
	static final String SESSION_PARAM_REQUEST_PRODUCT  	= "product";
	static final String SESSION_PARAM_REQUEST_CUSTOMER 	= "customer";
	static final String SESSION_PARAM_REQUEST_ORDER  	= "order";
	
	/** Modulo Clienti */
	static final String CONTEXT_PATH_MENU_CUSTOMERS = "/customersMenu";
	static final String CONTEXT_PATH_CUSTOMERS_LIST = "/customers/list";
	static final String CONTEXT_PATH_CUSTOMERS_CREATE = "/customers/create";
	static final String CONTEXT_PATH_CUSTOMERS_DELETE = "/customers/delete";
	static final String CONTEXT_PATH_CUSTOMERS_CREATE_INIT = "/customers/createinit";
	static final String CONTEXT_PATH_CUSTOMERS_UPDATE_INIT = "/customers/updateinit";
	static final String CONTEXT_PATH_CUSTOMERS_UPDATE = "/customers/update";
	static final String CONTEXT_PATH_CUSTOMERS_UPDATE_FAILURE = "/WEB-INF/pages/customers/customer.jsp";
	static final String CONTEXT_PATH_CUSTOMERS_CREATE_FAILURE = "/WEB-INF/pages/customers/newCustomer.jsp";
}
