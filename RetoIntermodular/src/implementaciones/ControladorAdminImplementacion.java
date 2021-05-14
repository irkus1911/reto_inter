package implementaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import logica.*;
import logica.exception.ConnectException;
import logica.exception.CreateException;
import logica.exception.ReadException;
import modelo.*;

public class ControladorAdminImplementacion implements ControladorAdmin {

	// Atributos
	private Connection con;
	private PreparedStatement stmt;
	private ConnectionOpenClose conection = new ConnectionOpenClose(); 

	// Sentencias
	private final String comprobarLogin = "SELECT clave FROM cliente WHERE id_clie = ? and clave = ?";
	private final String alta = "CALL `alta_usuario`(?,?,?,?,?)";

	@Override
	public boolean login(String id, String clave) throws ReadException , ConnectException {
	
		boolean encontrado = false;
		ResultSet rs = null;
		try {
			con = conection.openConnection();
		} catch (ConnectException e1) {
			e1.printStackTrace();
		}
		try {

			stmt = con.prepareStatement(comprobarLogin);
			stmt.setString(1, id);
			stmt.setString(2, clave);

			rs = stmt.executeQuery();

			while (rs.next() && !encontrado) {
				encontrado = true;
			}

		} catch (Exception e) {
			throw new ReadException(e.getMessage());
		}
		try {

			conection.closeConnection(stmt, con);
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				System.out.println("Error en cierre del ResultSet");
			}
		}
		return encontrado;
	}

	@Override
	public void alta(String nombre, String clave, String id, String tipoUsuario, String tipoComercio)
			throws CreateException {
		try {
			con = conection.openConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			stmt = con.prepareStatement(alta);
			stmt.setString(1, nombre);
			stmt.setString(2, id);
			stmt.setString(3, clave);
			stmt.setString(4, tipoUsuario);
			stmt.setString(5, tipoComercio);

			stmt.executeUpdate();

		} catch (Exception e) {
			throw new CreateException(e.getMessage());
		}
		try {
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
