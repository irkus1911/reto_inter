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
import logica.exception.ConnectException;
import logica.exception.CreateException;
import logica.exception.ReadException;
import logica.exception.UpdateException;
import modelo.*;

public class ControladorSumImplementacion implements ControladorSum {

	// Atributos
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private ConnectionOpenClose conection = new ConnectionOpenClose(); 
	private String admin;
	
	// Sentencias
	private final String comprobarLogin = "SELECT * FROM suministrador WHERE id_sum = ? and clave = ?";
	private final String callValidar = "CALL `aceptar_pedido_s`(?,?,?,?)";
	private final String mostrarPedidos = "SELECT comercio.id_com, producto.id_prod, pedidos_s.cant, pedidos_s.fecha,pedidos_s.estado FROM comercio, producto, pedidos_s WHERE comercio.id_com = pedidos_s.id_com AND producto.id_prod = pedidos_s.id_prod AND pedidos_s.id_sum = ? ";
	private String mostrarPedidosHist = "SELECT  comercio.nombre_com, comercio.id_com, producto.id_prod, producto.nombre, historico_s.cant, historico_s.fecha FROM comercio, producto, historico_s WHERE comercio.id_com = historico_s.id_com AND producto.id_prod = historico_s.id_prod AND historico_s.id_sum = ?";
	private final String querySelectStock = "SELECT stock_sum.id_prod, stock_sum.cant, producto.nombre FROM stock_sum,producto WHERE producto.id_prod=stock_sum.id_prod AND stock_sum.id_sum=? ";
	private final String queryCall = "CALL `add_prod`(?,?,?,?)";



	public Collection<Stock> stockSum(String id) throws ReadException, ConnectException {

		ResultSet rs = null;
		Collection<Stock> sto = new HashSet<Stock>();
		try {
			con = conection.openConnection();
		} catch (ConnectException e) {
			throw new ConnectException(e.getMessage());
		}
		
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
			} catch (Exception e) {
				throw new ReadException(e.getMessage());
			}
		}
		return sto;
	}

	public void validarPedidoSum(String id_s, String id_com, String id_prod, LocalDateTime fecha) throws UpdateException, ConnectException {
		
		try {
			con = conection.openConnection();
		} catch (ConnectException e) {
			throw new ConnectException(e.getMessage());
		}
		try {
			stmt = con.prepareStatement(callValidar);
			stmt.setString(1, id_s);
			stmt.setString(2, id_com);
			stmt.setString(3, id_prod);
			stmt.setTimestamp(4, Timestamp.valueOf(fecha));
			stmt.executeUpdate();

		} catch (Exception e) {
			throw new UpdateException(e.getMessage());
		}

		try {
			conection.closeConnection(stmt, con);
		} catch (ConnectException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	
	@Override
	public boolean login(String id, String clave) throws ReadException, ConnectException {
		
		boolean encontrado = false;
		ResultSet rs = null;
		
		try {
			con = conection.openConnection();
		} catch (ConnectException e) {
			throw new ConnectException(e.getMessage());
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
			} catch (Exception e) {
				throw new ReadException(e.getMessage());
			}
		}
		return encontrado;
	}

	@Override
	public Collection<Historico> historicoSumCom(String id) throws ReadException, ConnectException {
		
		Historico hist;
		Collection<Historico> historico = new HashSet<Historico>();
		ResultSet rs = null;
		if(id.equals("ADMIN")) {
			admin = " AND comercio.id_com = 'ADMIN'";
			
		} else {
			admin =  " AND comercio.id_com != 'ADMIN'";
		}
		mostrarPedidosHist+=admin;
		try {
			con = conection.openConnection();
		} catch (ConnectException e) {
			throw new ConnectException(e.getMessage());
		}
		try {
			stmt = con.prepareStatement(mostrarPedidosHist);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
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
			} catch (Exception e) {
				throw new ReadException(e.getMessage());
			}
		}

		return historico;
	}

	public Collection<Pedido> listarPed(String id) throws ReadException, ConnectException {
		
		Pedido ped;
		Collection<Pedido> pedidos = new HashSet<Pedido>();
		ResultSet rs = null;

		try {
			con = conection.openConnection();
		} catch (ConnectException e) {
			throw new ConnectException(e.getMessage());
		}
		try {
			stmt = con.prepareStatement(mostrarPedidos);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
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
			} catch (Exception e) {
				throw new ReadException(e.getMessage());
			}
		}
		return pedidos;
	}

	@Override
	public void anadirProd(String id_s, String id_p, int cant, String nombre) throws CreateException, ConnectException {
		
		try {
			con = conection.openConnection();
		} catch (ConnectException e) {
			throw new ConnectException(e.getMessage());
		}
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
			conection.closeConnection(stmt, con);
		} catch (ConnectException e) {
			throw new ConnectException(e.getMessage());
		}
	}

}
