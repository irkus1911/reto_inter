package implementaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.ResourceBundle;

import logica.*;
import modelo.*;

public class ControladorComImplementacion implements ControladorCom {

	// Atributos
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	// private InputStream inputStream;
	private ResourceBundle configFile;
	private String user, url, pass;

	// Sentencias
	private final String comprobarLogin = "EXISTS(SELECT clave FROM clientes WHERE id_clie = ? and clave = ?)";
	final String querySelectStock = "SELECT stock_sum.id_prod, stock_sum.cant, producto.nombre FROM stock_sum,producto WHERE producto.id_prod=stock_sum.id_prod AND stock_sum.id_sum=? ";

	public ControladorComImplementacion() {
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
			rs = stmt.executeQuery();
			while (rs.next() && !encontrado) {
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
		}

		return encontrado;
	}

	@Override
	public Collection<Historico> historicoClieCom(String id) throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validarPedidoCom() {
		// TODO Auto-generated method stub

	}

	@Override
	public void crearPedidoComSum(String id_comp, String id_ven, String id_prod, int cant) throws CreateException {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Historico> historicoComSum(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Stock> stockCom(String id) {

		Collection<Stock> sto = new HashSet<Stock>();
		openConnection();
		try {
			Stock stock;

			stmt = con.prepareStatement(querySelectStock);
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				stock = new Stock();
				stock.setId_usu(id);
				stock.setId_prod(rs.getString("stock_sum.id_prod"));
				stock.setCantidad(rs.getInt("stock_sum.cant"));
				stock.setNomProducto(rs.getString("producto.nombre"));
				sto.add(stock);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sto;

	}

}
