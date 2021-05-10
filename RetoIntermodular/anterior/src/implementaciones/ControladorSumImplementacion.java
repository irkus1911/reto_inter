package implementaciones;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.ResourceBundle;

import logica.ControladorSum;
import logica.ReadException;
import modelo.Historico;
import modelo.Pedido;
import modelo.Stock;
import modelo.Util;

public class ControladorSumImplementacion implements ControladorSum {

	// Atributos
	private Connection con;
	private PreparedStatement stmt;
	private ResourceBundle configFile;
	private ResultSet rs;
	private String user, url, pass;

	private final String comprobarLogin = "SELECT * FROM suministrador WHERE id_sum = ? and clave = ?";
	private final String callValidar = "CALL aceptar_pedido_s(?,?,?)";
	private final String queryPedidos = "SELECT  id_com,fecha,estado,id_prod FROM pedidos_s WHERE id_com=?";
	private final String querySelectStock = "SELECT stock_sum.id_prod, stock_sum.cant, producto.nombre FROM stock_sum,producto WHERE producto.id_prod=stock_sum.id_prod AND stock_sum.id_sum=? ";
	private final String queryCall = "CALL add_stock_sum ('?', '?', '?') ";

	
	public ControladorSumImplementacion() {
		this.configFile = ResourceBundle.getBundle("modelo.config");
		this.url = this.configFile.getString("URL");
		this.user = this.configFile.getString("USER");
		this.pass = this.configFile.getString("PASSWORD");
	}

	
	//conect y disconect
		//con = Util.openConnection(user,url,pass,con);
		//Util.closeConnection(stmt,con);

	public Collection<Stock> stockSum(String id) {
		
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
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				System.out.println("Error en cierre del ResultSet");
			}
		}
		return sto;
	}

	public void validarPedidoSum(String id_s, String id_com, String id_prod, LocalDate fecha) {
		
		con = Util.openConnection(user,url,pass,con);
		try {
			stmt = con.prepareStatement(callValidar);
			stmt.setString(1, id_s);
			stmt.setString(2, id_com);
			stmt.setString(3, id_prod);
			stmt.setDate(4, Date.valueOf(fecha));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Util.closeConnection(stmt,con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void historicoComSum() {
		// TODO Auto-generated method stub

	}

	public boolean login(String id, String clave) throws ReadException {

		System.out.println("Login_Login");

		boolean encontrado = false;
		ResultSet rs = null;
		con = Util.openConnection(user,url,pass,con);
		try {

			stmt = con.prepareStatement(comprobarLogin);
			stmt.setString(1, id);
			stmt.setString(2, clave);
			rs = stmt.executeQuery();
			
			while (rs.next() && !encontrado) {
				System.out.println("While");
				encontrado = true;
			}

		} catch (Exception e) {
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

	public void anadirStock(String id_s, String id_p, int cant) {
		// TODO Auto-generated method stub
		con = Util.openConnection(user,url,pass,con);
		try {
			stmt = con.prepareStatement(queryCall);
			stmt.setString(1, id_s);
			stmt.setString(2, id_p);
			stmt.setInt(3, cant);
			stmt.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Util.closeConnection(stmt,con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Historico> historicoComSum(String id) throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

	private Collection<Pedido> listarPedidos(String id) {
		Collection<Pedido> ped = new HashSet<Pedido>();
		ResultSet rs = null;
		Pedido pedi;
		
		con = Util.openConnection(user,url,pass,con);
		
		try {
			stmt = con.prepareStatement(queryPedidos);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				pedi = new Pedido();
				pedi.setIdComprador(rs.getString("id_com"));
				pedi.setEstado(rs.getBoolean("estado"));
				pedi.setIdProd(rs.getString("id_prod"));
				ped.add(pedi);
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
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				System.out.println("Error en cierre del ResultSet");
			}
		}
		return ped;
	}

}
