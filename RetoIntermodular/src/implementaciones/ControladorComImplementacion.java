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
	private final String querySelectStock = "SELECT stock_sum.id_prod, stock_sum.cant, producto.nombre FROM stock_sum,producto WHERE producto.id_prod=stock_sum.id_prod AND stock_sum.id_sum=? ";
	private final String listarProductos = "SELECT * FROM producto";
	private final String hacerPedido = "CALL `add_pedido_com`(?,?,?,?,?)";
	private final String listarVendedores = "SELECT suministrador.id_sum, suministrador.nombre_sum FROM  suministrador,stock_sum WHERE stock_sum.id_sum = suministrador.id_sum AND stock_sum.id_prod = ?";
	private final String leerCant = "SELECT stock_sum.cant FROM stock_sum WHERE stock_sum.id_sum = ? AND stock_sum.id_prod = ?";


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
	public Collection<Producto> listarProd() throws ReadException {
		// TODO Auto-generated method stub
		Producto prod;
		Collection<Producto> producto = new HashSet<>();
		ResultSet rs = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(listarProductos);
			rs = stmt.executeQuery();
			while (rs.next()) {
				prod = new Producto();
				prod.setId(rs.getString("id_prod"));
				prod.setNomProducto(rs.getString("nombre"));
				producto.add(prod);
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
		return producto;
	}

	@Override
	public Collection<Suministrador> listarVendedor(String id_prod) throws ReadException {
		// TODO Auto-generated method stub
		Suministrador sum;
		Collection<Suministrador> suministradores = new HashSet<>();
		ResultSet rs = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(listarVendedores);
			stmt.setString(1, id_prod);
			rs = stmt.executeQuery();
			while (rs.next()) {
				sum = new Suministrador();
				sum.setCifSum(rs.getString("suministrador.id_sum"));
				sum.setNombreSum(rs.getString("suministrador.nombre_sum"));
				sum.setClaveSum(null);
				suministradores.add(sum);
				
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
		return suministradores;
	}

	@Override
	public Integer listarCant(String id_sum, String id_prod) throws ReadException {
		// TODO Auto-generated method stub
		int cant = 0;

		ResultSet rs = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(leerCant);
			stmt.setString(1, id_sum);
			stmt.setString(2, id_prod);
			rs = stmt.executeQuery();
			while (rs.next()) {
				cant = rs.getInt("stock_sum.cant");
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
		return cant;
	}

	
	@Override
	public void crearPedidoComSum(String id_com, String id_ven, String id_prod, int cant) throws CreateException {
		// TODO Auto-generated method stub
		this.openConnection();
		try {
			stmt = con.prepareStatement(hacerPedido);
			stmt.setString(1, id_com);
			stmt.setString(2, id_ven);
			stmt.setString(3, id_prod);
			stmt.setInt(4, cant);
			stmt.setDate(5, Date.valueOf(LocalDate.now()));

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

	@Override
	public Collection<Historico> historicoComSum(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Stock> stockCom(String id) {
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
