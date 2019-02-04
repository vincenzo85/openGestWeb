/**
 * JdbcService.java
 *
 * robgion
 * www.2clever.it
 * 
 * 29 nov 2017
 * For further information please write to info@2clever.it
 */
package com.opengest.core.business.services;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author robgion
 *
 */
public interface JdbcService extends DatabaseService<Connection>{

	Connection getDatabaseConnection() throws SQLException;

}