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

public class ControladorClieImplementacion implements ControladorClie {

	// Atributos
	private Connection con;
	private PreparedStatement stmt;
	// private InputStream inputStream;
	private ResourceBundle configFile;
	private String user, url, pass;

	// Sentencias

	// modificado select de cliente
	private final String comprobarLogin = "SELECT clave FROM cliente WHERE id_clie = ? and clave = ?";
	private final String mostrarPedidos = "SELECT  comercio.nombre_com, comercio.id_com, producto.id_prod, producto.nombre, historico_c.cant, historico_c.fecha FROM comercio, producto, historico_c WHERE comercio.id_com = historico_c.id_com AND producto.id_prod = historico_c.id_prod AND historico_c.id_clie = ?";
	private final String hacerPedido = "CALL `add_pedido_com`(?,?,?,?,?)";
	private final String listarProductos = "SELECT * FROM producto";
	private final String listarVendedores = "SELECT comercio.id_com,comercio.nombre_com, comercio.tipo_com FROM  comercio,stock_com WHERE stock_com.id_com = comercio.id_com AND stock_com.id_prod = ?";
	private final String leerCant = "SELECT stock_com.cant FROM stock_com WHERE stock_com.id_com = ? AND stock_com.id_prod = ?";

	public ControladorClieImplementacion() {
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
	public void crearPedidoClieCom(String id_clie, String id_com, String id_prod, int cant) throws CreateException {
		this.openConnection();
		try {
			stmt = con.prepareStatement(hacerPedido);
			stmt.setString(1, id_clie);
			stmt.setString(2, id_com);
			stmt.setString(3, id_prod);
			stmt.setInt(4, cant);
			System.out.println(LocalDateTime.now());
			stmt.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));

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
	public Collection<Historico> historicoClieCom(String id) throws ReadException {
		Historico hist;
		Collection<Historico> historico = new HashSet<Historico>();
		ResultSet rs = null;

		this.openConnection();
		try {
			stmt = con.prepareStatement(mostrarPedidos);
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
				hist.setCant(rs.getInt("historico_c.cant"));
				hist.setFecha(rs.getTimestamp("historico_c.fecha").toLocalDateTime());
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
		}if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				System.out.println("Error en cierre del ResultSet");
			}
		}
		
		return historico;
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
	public Collection<Comercio> listarVendedor(String id_prod) throws ReadException {
		// TODO Auto-generated method stub
		Comercio com;
		Collection<Comercio> comercios = new HashSet<>();
		ResultSet rs = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(listarVendedores);
			stmt.setString(1, id_prod);
			rs = stmt.executeQuery();
			while (rs.next()) {
				com = new Comercio();
				com.setCifCom(rs.getString("comercio.id_com"));
				com.setNombreCom(rs.getString("comercio.nombre_com"));
				com.setTipoCom(rs.getString("comercio.tipo_com"));
				com.setClaveCom(null);
				comercios.add(com);
				
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
		return comercios;
	}

	@Override
	public Integer listarCant(String id_com, String id_prod) throws ReadException {
		// TODO Auto-generated method stub
		int cant = 0;

		ResultSet rs = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(leerCant);
			stmt.setString(1, id_com);
			stmt.setString(2, id_prod);
			rs = stmt.executeQuery();
			while (rs.next()) {
				cant = rs.getInt("stock_com.cant");
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

}
