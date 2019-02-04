/**
 * <b> CustomerDto.java
 * 
 * <br/>
 * 
 * DTO le utilit� riguardanti il modulo di amministrazione clienti.
 * 
 */
package com.opengest.core.business.dto;

import com.opengest.core.business.vo.Customer;

/**
 * @author Roberto Giontella
 * 
 */
public class CustomerDto {

	private Customer customerBean;

	private Long id;
	private String code;
	private String ragsoc;
	private Long piva;
	
	public CustomerDto() {
		this.customerBean = new Customer();
	}
	
	public CustomerDto(Customer cbean) {
		this.customerBean = cbean;
		this.id = this.customerBean.getId();
		this.code = this.customerBean.getCode();
		this.ragsoc = this.customerBean.getRagsoc();
		this.piva = this.customerBean.getPiva();
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Customer getCustomerBean() {
		return populateVO();
	}

	public Long getId() {
		return id;
	}

	public String getRagsoc() {
		return ragsoc;
	}

	public void setRagsoc(String ragsoc) {
		this.ragsoc = ragsoc;
	}

	public Long getPiva() {
		return piva;
	}

	public void setPiva(Long piva) {
		this.piva = piva;
	}

	public Customer populateVO() {
		this.customerBean.setCode(code);
		this.customerBean.setRagsoc(ragsoc);
		this.customerBean.setPiva(piva);
		return this.customerBean;
	}
}
