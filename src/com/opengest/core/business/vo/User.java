/**
 * <b> User.java
 * 
 * <br>
 * 
 *  Classe vo per il trasporto dei dati degli utenti.
 * 
 */
package com.opengest.core.business.vo;

import java.io.Serializable;

/**
 * 
 * @author 2Clever.IT
 *
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private String email;
	private String codfisc;
	
	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User() {
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodfisc() {
		return codfisc;
	}

	public void setCodfisc(String codfisc) {
		this.codfisc = codfisc;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public void setEmail(String email) {
	this.email = email;
		
	}

	
}
