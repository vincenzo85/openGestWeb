/**
 * <b> UserDaoImpl.java
 * 
 * <br>
 * 
 *  Classe bo per l'accesso ai dati della tabella utente.
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
import com.opengest.core.business.vo.Company;
import com.opengest.core.business.vo.User;

/**
 * @author 2Clever.IT
 * 
 */
public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
	}

	/**
	 * Metodo che controlla l'autorizzazione dell'utente durante il login.
	 * 
	 * @param username
	 * @param password
	 * @return boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 *
	 */
	@Override
	public boolean authorization(String username, String password) throws SQLException {

		boolean authorized = false;

		Connection connection = null;

		try {
			connection = DatabaseServiceFactory.getJdbcDatabaseService().getDatabaseConnection();
			PreparedStatement pstmt = connection
					.prepareStatement(IApplicationConstants.QUERY_FIND_USER_BY_USERNAME_PASSWORD);

			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				// Riga trovata, quindi l'utente ha accesso all'applicazione.
				authorized = true;
			} else {
				// Riga non trovata, quindi l'utente non ancora registrato o i
				// dati
				// inseriti non sono validi.
				authorized = false;
			}
		} finally {
			if (connection != null)
				connection.close();
		}
		return authorized;
	}

	@Override
	public User findByUsername(String username) throws SQLException {

		User retuser = new User();

		// Ricerca della presenza dei dati di login inseriti.
		Connection connection = null;
		try {
			connection = DatabaseServiceFactory.getJdbcDatabaseService().getDatabaseConnection();
			PreparedStatement pstmt = connection.prepareStatement(IApplicationConstants.QUERY_FIND_USER_BY_USERNAME);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					retuser.setUsername(rs.getString("username"));
					retuser.setPassword(rs.getString("password"));
					retuser.setEmail(rs.getString("email"));
					retuser.setNome(rs.getString("nome"));
					retuser.setCognome(rs.getString("cognome"));
					retuser.setId(rs.getLong("id_utente"));
				}
			}
		} finally {
			if (connection != null)
				connection.close();
		}
		return retuser;
	}

	/**
	 * Metodo finder per la ricerca dell'utente tramite il suo id (primary key).
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	@Override
	public User findById(Long id) throws SQLException {

		User retuser = null;

		Connection connection = null;

		try {
			connection = DatabaseServiceFactory.getJdbcDatabaseService().getDatabaseConnection();
			PreparedStatement pstmt = connection.prepareStatement(IApplicationConstants.QUERY_FIND_USER_BY_PRIMARY_KEY);

			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				retuser = new User();
				while (rs.next()) {
					retuser.setUsername(rs.getString("username"));
					retuser.setPassword(rs.getString("password"));
					retuser.setEmail(rs.getString("email"));
					retuser.setNome(rs.getString("nome"));
					retuser.setCognome(rs.getString("cognome"));
					retuser.setId(rs.getLong("id_utente"));

					Company cVo = new Company();
					cVo.setIdCompany(rs.getLong("company"));
					retuser.setCompany(cVo);
				}
			}
		} finally {
			if (connection != null)
				connection.close();
		}
		return retuser;
	}

	/**
	 * Metodo per la cancellazione dell'utente tramite il suo id (primary key).
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
					.prepareStatement(IApplicationConstants.QUERY_DELETE_USER_BY_PRIMARY_KEY);

			pstmt.setLong(1, id);
			pstmt.executeUpdate();
			
			connection.commit();

		} catch (SQLException e) {

			connection.rollback();
			throw e;

		} finally {
			if (connection != null)
				connection.close();
		}
	}

	/**
	 * Metodo per la registrazione dell'utente nella base dati.
	 * 
	 * @param user
	 *            void
	 * @throws Exception
	 *
	 */
	@Override
	public void save(User user) throws SQLException {

		Connection connection = null; 
		try {

			connection = DatabaseServiceFactory.getJdbcDatabaseService().getDatabaseConnection();
			connection.setAutoCommit(false);
			
			// Recupero della lista delle stringhe delle città.
			PreparedStatement pst = connection.prepareStatement(IApplicationConstants.QUERY_SAVE_USER);

			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getNome());
			pst.setString(4, user.getCognome());
			pst.setString(5, user.getEmail());

			// Censimento dell'utente nel database.
			int numRowsChanged = pst.executeUpdate();
			
			connection.commit();
			System.out.println("Aggiornati utenti: " + numRowsChanged);

		} catch (SQLException e) {

			connection.rollback();
			throw e;

		} finally {

			connection.close();
		}
	}

	/**
	 * Metodo per la modifica dell'utente nella base dati.
	 * 
	 * @param user
	 *            void
	 * @throws Exception
	 *
	 */
	@Override
	public void update(User user) throws SQLException {

		Connection connection = null;

		try {
			connection = DatabaseServiceFactory.getJdbcDatabaseService().getDatabaseConnection();
			connection.setAutoCommit(false);
			
			PreparedStatement pst = connection.prepareStatement(IApplicationConstants.QUERY_UPDATE_USER);

			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getNome());
			pst.setString(5, user.getCognome());
			pst.setLong(6, user.getId());

			// Censimento dell'utente nel database.
			int numRowsChanged = pst.executeUpdate();
			connection.commit();
			
			System.out.println("Aggiornati utenti: " + numRowsChanged);

		} catch (SQLException e) {

			connection.rollback();
			throw e;

		} finally {
			if (connection != null)
				connection.close();
		}
	}

	/**
	 * Metodo finder per la ricerca di tutti gli utenti.
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	@Override
	public List<User> findAll() throws SQLException {

		List<User> retuserList = null;

		Connection connection = null;

		try {
			connection = DatabaseServiceFactory.getJdbcDatabaseService().getDatabaseConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(IApplicationConstants.QUERY_FIND_All_USERS);
			if (rs != null) {
				retuserList = new ArrayList<User>();
				while (rs.next()) {
					User retuser = new User();
					retuser.setId(rs.getLong("id_utente"));
					retuser.setUsername(rs.getString("username"));
					retuser.setPassword(rs.getString("password"));
					retuser.setEmail(rs.getString("email"));
					retuser.setNome(rs.getString("nome"));
					retuser.setCognome(rs.getString("cognome"));
					retuserList.add(retuser);
				}
			}

		} finally {
			if (connection != null)
				connection.close();
		}
		return retuserList;
	}

	/**
	 * Metodo per il controllo dell'esistenza di uno username
	 * 
	 * @param sql
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean exist(String username) throws SQLException, Exception {
		ResultSet resultSet = null;
		boolean exist = false;

		Connection connection = null;

		try {
			connection = DatabaseServiceFactory.getJdbcDatabaseService().getDatabaseConnection();
			PreparedStatement pst = connection.prepareStatement(IApplicationConstants.QUERY_EXIST_USERNAME);
			pst.setString(1, username);
			resultSet = pst.executeQuery();
			exist = resultSet.next();
		} finally {
			if (connection != null)
				connection.close();
		}
		return exist;
	}

}
