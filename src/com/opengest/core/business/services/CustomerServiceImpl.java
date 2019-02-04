/**
 * <b> CustomerServiceImpl.java
 * 
 * <br/>
 * 
 * Classe facade per la gestione delle operazioni del modulo clienti.
 * 
 */
package com.opengest.core.business.services;

import java.util.List;

import com.opengest.core.business.dao.CustomerDaoImpl;
import com.opengest.core.business.dao.UserDaoImpl;
import com.opengest.core.business.dto.CustomerDto;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.vo.Customer;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class CustomerServiceImpl implements CustomerSevice {

	
	public CustomerDto findCustomerById(Long id) throws BusinessException {
		Customer product;
		try {
			product = new CustomerDaoImpl().findById(id);
			
		} catch (Exception e) {
			throw new BusinessException("[UserServiceImpl.authorization]", e);
		}
		return new CustomerDto(product);
	}
	
	public void deleteCustomer(Long id) throws BusinessException {
		try {
			new CustomerDaoImpl().delete(id); 
			
		} catch (Exception e) {
			throw new BusinessException("[UserServiceImpl.authorization]", e);
		}
	}

	public void saveCustomer(CustomerDto customer) throws BusinessException {
		try {
			new CustomerDaoImpl().save(customer.getCustomerBean());
		} catch (Exception e) {
			throw new BusinessException("[UserServiceImpl.authorization]", e);
		}
	}
	
	public void updateCustomer(CustomerDto customer) throws BusinessException {
		try {
			new CustomerDaoImpl().update(customer.getCustomerBean());
		} catch (Exception e) {
			throw new BusinessException("[UserServiceImpl.authorization]", e);
		}
	}

	public List<Customer> listCustomers() throws BusinessException {
		try {
			return new CustomerDaoImpl().findAll();
			
		} catch (Exception e) {
			throw new BusinessException("[UserServiceImpl.authorization]", e);
		}
	}

	public boolean existCode(String code) throws BusinessException {
		try {
			return new CustomerDaoImpl().exist(code);
			
		} catch (Exception e) {
			throw new BusinessException("[UserServiceImpl.authorization]", e);
		}
	}


}
