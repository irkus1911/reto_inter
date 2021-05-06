package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import excepciones.*;

public class ControladorClieImplementacion implements ControladorClie {

	// Atributos
	private Connection con;
	private PreparedStatement stmt;
	// private InputStream inputStream;
	private ResourceBundle configFile;
	private String user, url, pass;

	// Sentencias
	private final String comprobarLogin = "EXISTS(SELECT clave FROM clientes WHERE id_clie = ? and clave = ?)";
	private final String mostrarPedidos = "SELECT comercio.id_com, comercio.nombre_com, producto.nombre, historico_c.fecha, historico_c.cant FROM comercio, producto, historico_c WHERE comercio.id_com = historico_c.id_com AND producto.id_prod = historico_c.id_prod AND historico_c.id_clie = ?";
	private final String hacerPedido = "CALL `add_pedido_com`(?,?,?,?,?)";
	private final String listarProductos = "SELECT * FROM producto";
	public ControladorClieImplementacion() {
		this.configFile = ResourceBundle.getBundle("modelo.config");
		this.url = this.configFile.getString("URL");
		this.user = this.configFile.getString("USER");
		this.pass = this.configFile.getString("PASSWORD");
	}

	public void openConnection() {

		try {

			con = DriverManager.getConnection(this.url, this.user, this.pass);
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
	public void crearPedidoClieCom(Pedido ped) throws CreateException {
		this.openConnection();
		try {
			stmt = con.prepareStatement(hacerPedido);
			stmt.setString(1, ped.getIdComprador());
			stmt.setString(2, ped.getIdVendedor());
			stmt.setString(3, ped.getIdProd());
			stmt.setInt(4,ped.getCant());
			stmt.setDate(5, Date.valueOf(ped.getFecha()));
			
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
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				hist = new Historico();
				hist.setIdComprador(id);
				hist.setIdVendedor(rs.getString("comercio.id_com"));
				hist.setVendedor(rs.getString("comercio.nombre_com"));
				hist.setProducto(rs.getString("producto.id_prod"));
				hist.setProducto(rs.getString("producto.nombre"));
				hist.setCant(rs.getInt("historico_c.cant"));
				hist.setFecha(rs.getDate("historico_c.fecha").toLocalDate());
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
		return historico;
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
				//prod = new Producto();
				prod.setId(rs.getString("id_prod"));
				prod.setNombre(rs.getString("nombre"));
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
		}
		return null;
	}

}
