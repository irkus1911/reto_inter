package implementaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionOpenClose {

	public static Connection openConnection(String user, String url, String pass, Connection con) {

		try {
			con = DriverManager.getConnection(url, user, pass);

			System.out.println("Coneccion OK");
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		}
		return con;
	}

	public static void closeConnection(PreparedStatement stmt, Connection con) throws SQLException {

		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
	}

}
