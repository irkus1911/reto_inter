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

	
	//login del admin local
	@Override
	public boolean login(String id, String clave) throws ReadException, ConnectException {

		boolean encontrado = false;
		ResultSet rs = null;
		try {
			con = conection.openConnection();
		} catch (ConnectException e1) {
			throw new ConnectException(e1.getMessage());
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
			throw new ConnectException(e.getMessage());
		}
		
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {
				throw new ReadException(ex.getMessage());
			}
		}
		return encontrado;
	}

	//alta de los usuarios de parte del admin
	@Override
	public void alta(String nombre, String clave, String id, String tipoUsuario, String tipoComercio) throws CreateException, ConnectException {
		try {
			con = conection.openConnection();
		} catch (ConnectException e1) {
			throw new ConnectException(e1.getMessage());
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
		} catch (ConnectException e) {
			throw new ConnectException(e.getMessage());
		}

	}

}
