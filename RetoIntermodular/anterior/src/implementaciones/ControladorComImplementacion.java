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
	private final String comprobarLogin = "SELECT clave FROM comercio WHERE id_com = ? and clave = ?";
	final String querySelectStock = "SELECT stock_sum.id_prod, stock_sum.cant, producto.nombre FROM stock_sum,producto WHERE producto.id_prod=stock_sum.id_prod AND stock_sum.id_sum=? ";

	public ControladorComImplementacion() {
		this.configFile = ResourceBundle.getBundle("modelo.config");
		this.url = this.configFile.getString("URL");
		this.user = this.configFile.getString("USER");
		this.pass = this.configFile.getString("PASSWORD");
	}

	
	//conect y disconect
	//con = Util.openConnection(user,url,pass,con);
	//Util.closeConnection(stmt,con);

	@Override
	public boolean login(String id, String clave) throws ReadException {

		boolean encontrado = false;
		ResultSet rs = null;
		con = Util.openConnection(user,url,pass,con);
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
			Util.closeConnection(stmt,con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		ResultSet rs = null;
		Collection<Stock> sto = new HashSet<Stock>();
		con = Util.openConnection(user,url,pass,con);
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
			Util.closeConnection(stmt,con);
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
		return sto;

	}

}
