/**
 * DatabaseService.java
 *
 * robgion
 * www.2clever.it
 * 
 * 05 lug 2017
 * For further information please write to info@2clever.it
 */
package com.opengest.core.business.services;

/**
 * @author robgion
 *
 */
public interface DatabaseService<T> {

	public static final int TYPE_JDBC = 1; 
	public static final int TYPE_JPA = 2; 
	
	public T getDatabaseConnection() throws Exception;

	public void terminateServices();
}
