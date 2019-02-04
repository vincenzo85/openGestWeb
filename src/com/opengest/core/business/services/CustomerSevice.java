/**
 * <b> CustomerSevice.java
 * 
 * <br/>
 * 
 * Interfaccia facade per la gestione delle operazioni del modulo clienti.
 * 
 */
package com.opengest.core.business.services;

import java.util.List;

import com.opengest.core.business.dto.CustomerDto;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.vo.Customer;


/**
 * @author Roberto Giontella
 * 
 */
public interface CustomerSevice {
	
	
	CustomerDto findCustomerById(Long id) throws BusinessException;
	
	void saveCustomer(CustomerDto product) throws BusinessException;
	
	void updateCustomer(CustomerDto product) throws BusinessException;
	
	List<Customer> listCustomers() throws BusinessException;
	
	void deleteCustomer(Long id) throws BusinessException;
	
	boolean existCode(String code) throws BusinessException;;
}
