package implementaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import logica.exception.ConnectException;
import logica.exception.ReadException;

public class ConnectionOpenClose {
	
	private ResourceBundle configFile;
	private String url, user,  pass;
	

	public ConnectionOpenClose() {
		configFile = ResourceBundle.getBundle("modelo.config");
		url = configFile.getString("URL");
		user = configFile.getString("USER");
		pass = configFile.getString("PASSWORD");
	}

	public Connection openConnection() throws ConnectException {

		Connection con= null;
		
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			throw new ConnectException( "Error al intentar Conectar la BD");
		}
		return con;
	}

	public void closeConnection(PreparedStatement stmt, Connection con) throws ConnectException {

		if (stmt != null || con != null) {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				throw new ConnectException( "Error al intentar Desconectar la BD");
			}
		}
	}

}
