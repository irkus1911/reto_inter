package implementaciones;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.ResourceBundle;

import logica.*;
import modelo.*;
public class ControladorSumImplementacion implements ControladorSum {

	// Atributos
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private ResourceBundle configFile;
	private String user, url, pass;

	// Sentencias
	private final String comprobarLogin = "SELECT * FROM suministrador WHERE id_sum = ? and clave = ?";
	private final String callValidar = "CALL `aceptar_pedido_s`(?,?,?,?)";
	private final String mostrarPedidos = "SELECT comercio.id_com, producto.id_prod, pedidos_s.cant, pedidos_s.fecha,pedidos_s.estado FROM comercio, producto, pedidos_s WHERE comercio.id_com = pedidos_s.id_com AND producto.id_prod = pedidos_s.id_prod AND pedidos_s.id_sum = ? ";
	private final String mostrarPedidosHist = "SELECT  comercio.nombre_com, comercio.id_com, producto.id_prod, producto.nombre, historico_s.cant, historico_s.fecha FROM comercio, producto, historico_s WHERE comercio.id_com = historico_s.id_com AND producto.id_prod = historico_s.id_prod AND historico_s.id_sum = ?";
	private final String querySelectStock = "SELECT stock_sum.id_prod, stock_sum.cant, producto.nombre FROM stock_sum,producto WHERE producto.id_prod=stock_sum.id_prod AND stock_sum.id_sum=? ";
	private final String queryCall = "CALL `add_prod`(?,?,?,?)";

	public ControladorSumImplementacion() {
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

	public Collection<Stock> stockSum(String id) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
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
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				System.out.println("Error en cierre del ResultSet");
			}
		}
		return sto;
	}

	public void validarPedidoSum(String id_s, String id_com, String id_prod, LocalDateTime fecha) throws UpdateException {
		// TODO Auto-generated method stub
		openConnection();
		try {
			stmt = con.prepareStatement(callValidar);
			stmt.setString(1, id_s);
			stmt.setString(2, id_com);
			stmt.setString(3, id_prod);
			stmt.setTimestamp(4, Timestamp.valueOf(fecha));
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UpdateException(e.getMessage());
		}

		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@Override
	public boolean login(String id, String clave) throws ReadException {

		System.out.println("Login_Login");

		boolean encontrado = false;
		ResultSet rs = null;
		this.openConnection();
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
			this.closeConnection();
		} catch (SQLException e) {

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
	public Collection<Historico> historicoComSum(String id) throws ReadException {
		// TODO Auto-generated method stub
		Historico hist;
		Collection<Historico> historico = new HashSet<Historico>();
		ResultSet rs = null;

		this.openConnection();
		try {
			stmt = con.prepareStatement(mostrarPedidosHist);
			stmt.setString(1, id);
			System.out.println("query");
			rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("while");
				hist = new Historico();
				hist.setIdComprador(id);
				hist.setComprador("");
				hist.setIdVendedor(rs.getString("comercio.id_com"));
				hist.setVendedor(rs.getString("comercio.nombre_com"));
				hist.setIdProd(rs.getString("producto.id_prod"));
				hist.setProducto(rs.getString("producto.nombre"));
				hist.setCant(rs.getInt("historico_s.cant"));
				hist.setFecha(rs.getTimestamp("historico_s.fecha").toLocalDateTime());
				historico.add(hist);
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
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				System.out.println("Error en cierre del ResultSet");
			}
		}

		return historico;
	}

	public Collection<Pedido> listarPed(String id) throws ReadException {
		Pedido ped;
		Collection<Pedido> pedidos = new HashSet<Pedido>();
		ResultSet rs = null;

		this.openConnection();
		try {
			stmt = con.prepareStatement(mostrarPedidos);
			stmt.setString(1, id);
			System.out.println("query");
			rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("while");
				ped = new Pedido();
				ped.setIdComprador(rs.getString("comercio.id_com"));
				ped.setIdVendedor(id);
				ped.setIdProd(rs.getString("producto.id_prod"));
				ped.setCant(rs.getInt("pedidos_s.cant"));
				ped.setFecha(rs.getTimestamp("pedidos_s.fecha").toLocalDateTime());
				ped.setEstado(rs.getBoolean("pedidos_s.estado"));
				pedidos.add(ped);
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
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				System.out.println("Error en cierre del ResultSet");
			}
		}

		return pedidos;
	}

	@Override
	public void anadirProd(String id_s, String id_p, int cant, String nombre) throws CreateException {
		// TODO Auto-generated method stub
		openConnection();
		try {
			stmt = con.prepareStatement(queryCall);
			stmt.setString(1, id_s);
			stmt.setString(2, id_p);
			stmt.setInt(3, cant);
			stmt.setString(4, nombre);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new CreateException(e.getMessage());
		}

		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
