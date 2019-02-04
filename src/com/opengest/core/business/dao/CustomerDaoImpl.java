/**
 * <b> CustomerDaoImpl.java</b>
 * 
 * <br>
 * 
 *  Classe bo per l'accesso ai dati della tabella clienti.
 * 
 */
package com.opengest.core.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.opengest.core.business.params.IApplicationConstants;
import com.opengest.core.business.services.DatabaseServiceFactory;
import com.opengest.core.business.vo.Customer;

/**
 * @author Roberto Giontella
 * 
 */
public class CustomerDaoImpl implements CustomerDao {

	public CustomerDaoImpl() {
	}

	/**
	 * Metodo finder per la ricerca del cliente tramite il suo id (primary key).
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	@Override
	public Customer findById(Long id) throws SQLException, Exception {

		Customer product = null;

		Connection connection = null;

		try {
			connection = DatabaseServiceFactory.getJdbcDatabaseService().getDatabaseConnection();
			PreparedStatement pstmt = connection
					.prepareStatement(IApplicationConstants.QUERY_FIND_CUSTOMER_BY_PRIMARY_KEY);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				product = new Customer();
				while (rs.next()) {
					product.setId(rs.getLong(1));
					product.setCode(rs.getString(2));
					product.setRagsoc(rs.getString(3));
					product.setPiva(rs.getLong(4));
				}
			}
		} finally {
			connection.close();
		}
		return product;
	}

	/**
	 * Metodo per la cancellazione del cliente tramite il suo id (primary key).
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	@Override
	public void delete(Long id) throws SQLException {

		Connection connection = null;
		try {
			connection = DatabaseServiceFactory.getJdbcDatabaseService().getDatabaseConnection();
			connection.setAutoCommit(false);

			PreparedStatement pstmt = connection
					.prepareStatement(IApplicationConstants.QUERY_DELETE_CUSTOMER_BY_PRIMARY_KEY);
			pstmt.setLong(1, id);
			pstmt.executeUpdate();

			connection.commit();

		} catch (SQLException e) {
			if (connection != null)
				connection.rollback();
			throw e;
		} finally {

			connection.close();
		}
	}

	/**
	 * Metodo per la registrazione del cliente nella base dati.
	 * 
	 * @param product
	 *            void
	 * @throws Exception
	 *
	 */
	@Override
	public void save(Customer product) throws SQLException, Exception {

		Connection connection = null;
		try {
			connection = DatabaseServiceFactory.getJdbcDatabaseService().getDatabaseConnection();
			connection.setAutoCommit(false);

			// Recupero della lista delle stringhe delle citt�.
			PreparedStatement pst = connection.prepareStatement(IApplicationConstants.QUERY_SAVE_CUSTOMER);

			pst.setString(1, product.getCode());
			pst.setString(2, product.getRagsoc());
			pst.setLong(3, product.getPiva());

			// Censimento del cliente nel database.
			int numRowsChanged = pst.executeUpdate();
			System.out.println("Aggiornati prodotti: " + numRowsChanged);

		} catch (SQLException e) {
			if (connection != null)
				connection.rollback();
			throw e;
		} finally {

			connection.close();
		}
	}

	/**
	 * Metodo per la modifica del cliente nella base dati.
	 * 
	 * @param product
	 *            void
	 * @throws Exception
	 *
	 */
	@Override
	public void update(Customer product) throws SQLException, Exception {

		Connection connection = null;
		try {
			connection = DatabaseServiceFactory.getJdbcDatabaseService().getDatabaseConnection();
			connection.setAutoCommit(false);

			PreparedStatement pst = connection.prepareStatement(IApplicationConstants.QUERY_UPDATE_CUSTOMER);

			pst.setString(1, product.getCode());
			pst.setString(2, product.getRagsoc());
			pst.setLong(3, product.getPiva());
			pst.setLong(4, product.getId());

			// Censimento del cliente nel database.
			int numRowsChanged = pst.executeUpdate();
			System.out.println("Aggiornati clienti: " + numRowsChanged);

		} catch (SQLException e) {
			if (connection != null)
				connection.rollback();
			throw e;
		} finally {

			connection.close();
		}
	}

	/**
	 * Metodo finder per la ricerca di tutti i prodotti.
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	@Override
	public List<Customer> findAll() throws SQLException, Exception {

		List<Customer> retlist = null;
		Connection connection = null;
		try {
			connection = DatabaseServiceFactory.getJdbcDatabaseService().getDatabaseConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(IApplicationConstants.QUERY_FIND_All_CUSTOMERS);
			if (rs != null) {
				retlist = new ArrayList<Customer>();
				while (rs.next()) {
					Customer prod = new Customer();
					prod.setId(rs.getLong(1));
					prod.setCode(rs.getString(2));
					prod.setRagsoc(rs.getString(3));
					prod.setPiva(rs.getLong(4));
					retlist.add(prod);
				}
			}
		} finally {
			if (connection != null)
				connection.close();
		}
		return retlist;
	}

	/**
	 * Metodo per il controllo dell'esistenza di un codice cliente.
	 * 
	 * @param sql
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean exist(String code) throws SQLException {
		ResultSet resultSet = null;
		boolean exist = false;

		Connection connection = null;
		try {
			connection = DatabaseServiceFactory.getJdbcDatabaseService().getDatabaseConnection();
			PreparedStatement pst = connection.prepareStatement(IApplicationConstants.QUERY_EXIST_CUSTOMER_CODE);
			pst.setString(1, code);
			resultSet = pst.executeQuery();
			exist = resultSet.next();

		} finally {
			if (connection != null)
				connection.close();
		}
		return exist;
	}
}
