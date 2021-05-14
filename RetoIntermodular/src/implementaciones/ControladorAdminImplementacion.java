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
import modelo.*;

public class ControladorAdminImplementacion implements ControladorAdmin {

	// Atributos
	private Connection con;
	private PreparedStatement stmt;
	// private InputStream inputStream;
	private ResourceBundle configFile;
	private String user, url, pass;

	// Sentencias
	private final String comprobarLogin = "SELECT clave FROM cliente WHERE id_clie = ? and clave = ?";
	private final String alta = "CALL `alta_usuario`(?,?,?,?,?)";



	public ControladorAdminImplementacion() {
		this.configFile = ResourceBundle.getBundle("modelo.config");
		this.url = this.configFile.getString("URL");
		this.user = this.configFile.getString("USER");
		this.pass = this.configFile.getString("PASSWORD");
	}

	public void openConnection() {

		try {

			con = DriverManager.getConnection(this.url, this.user, this.pass);

			System.out.println("Coneccion OK");

		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		}
	}

	public void closeConnection() throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
	}


	@Override
	public boolean login(String id, String clave) throws ReadException {
		boolean encontrado = false;
		ResultSet rs = null;
		this.openConnection();
		try {

			stmt = con.prepareStatement(comprobarLogin);
			stmt.setString(1, id);
			stmt.setString(2, clave);

			// PETA AQUI
			rs = stmt.executeQuery();
			System.out.println("TRY5");
			while (rs.next() && !encontrado) {
				System.out.println("While");
				encontrado = true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block

			throw new ReadException(e.getMessage());
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				System.out.println("Error en cierre del ResultSet");
			}
		}

		return encontrado;
	}

	@Override
	public void alta(String nombre, String clave, String id, String tipoUsuario, String tipoComercio) throws CreateException {
		this.openConnection();
		try {
			stmt = con.prepareStatement(alta);
			stmt.setString(1, nombre);
			stmt.setString(2, id);
			stmt.setString(3, clave);
			stmt.setString(4, tipoUsuario);
			stmt.setString(5, tipoComercio);
			

			stmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block

			throw new CreateException(e.getMessage());
		}
		try {
			this.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
