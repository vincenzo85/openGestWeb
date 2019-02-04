package com.opengest.core.business.params;

/**
 * Interfaccia contenente costanti per query al db.
 */

public interface IApplicationConstants {

	/** Query per la gestione della tabella utenti */
	public static final String QUERY_FIND_USER_BY_USERNAME_PASSWORD = "select id_utente from utenti where username = ? and password = ?";
	public static final String QUERY_FIND_USER_BY_USERNAME = "select * from utenti where username = ?";
	public static final String QUERY_SAVE_USER = "insert into utenti (username,password,nome,cognome,email,id_provincia,id_regione) values(?,?,?,?,?,?,?)";
	public static final String QUERY_UPDATE_USER = "update utenti set username = ?,password = ?, email = ?,nome = ?,cognome = ? where id_utente = ?";
	public static final String QUERY_FIND_USER_BY_PRIMARY_KEY = "select * from utenti where id_utente = ?";
	public static final String QUERY_DELETE_USER_BY_PRIMARY_KEY = "delete from utenti where id_utente = ?";
	public static final String QUERY_FIND_All_USERS = "select * from utenti ";
	public static final String QUERY_EXIST_USERNAME = "SELECT id_utente FROM utenti WHERE username = ?";	
	
	/** Query per la gestione della tabella clienti */
	public static final String QUERY_SAVE_CUSTOMER = "insert into clienti (codice,rag_soc,piva) values(?,?,?)";
	public static final String QUERY_UPDATE_CUSTOMER = "update clienti set codice = ?,rag_soc = ?, piva = ? where id_cliente = ?";
	public static final String QUERY_FIND_CUSTOMER_BY_PRIMARY_KEY = "select * from clienti where id_cliente = ?";
	public static final String QUERY_DELETE_CUSTOMER_BY_PRIMARY_KEY = "delete from clienti where id_cliente = ?";
	public static final String QUERY_FIND_All_CUSTOMERS = "select * from clienti ";
	public static final String QUERY_EXIST_CUSTOMER_CODE = "SELECT id_cliente FROM clienti WHERE codice = ?";	
}

