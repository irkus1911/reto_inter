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

import logica.ControladorSum;
import logica.ReadException;
import modelo.Historico;
import modelo.Pedido;
import modelo.Stock;


public class ControladorSumImplementacion implements ControladorSum {

	// Atributos
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	final String callValidar="CALL aceptar_pedido_s(?,?,?)";
	final String queryPedidos ="SELECT  id_com,fecha,estado,id_prod FROM pedidos_s WHERE id_com=?";
	final String querySelectStock="SELECT stock_sum.id_prod, stock_sum.cant, producto.nombre FROM stock_sum,producto WHERE producto.id_prod=stock_sum.id_prod AND stock_sum.id_sum=? ";
	final String queryCall="CALL add_stock_sum ('?', '?', '?') ";
	
	private void openConnection(){
	try {
	String url = "jdbc:mysql://localhost:3306/proyecto_final?serverTimezone=Europe/Madrid&usessl=false";
	con =  DriverManager.getConnection(url+"?" +"user=root &password=abcd*1234");
	} catch (SQLException e) {
	System.out.println("Error al intentar abrir la BD");
	}
	}
	private void closeConnection() throws SQLException {
	if (stmt != null) {
	stmt.close();
	}
	if(con != null)
	con.close();
	}


	public Collection<Stock> stockSum(String id) {
		// TODO Auto-generated method stub
		Collection<Stock> sto=new HashSet<Stock>();
		openConnection();
		try {
			Stock stock;
			
			stmt=con.prepareStatement(querySelectStock);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				stock=new Stock();
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

	public void validarPedidoSum(String id_s,String id_com,String id_prod,LocalDate fecha) {
		// TODO Auto-generated method stub
		openConnection();
		try {
			stmt=con.prepareStatement(callValidar);
			stmt.setString(1, id_s);
			stmt.setString(2, id_com);
			stmt.setString(3, id_prod);
			stmt.setDate(4, Date.valueOf(fecha));
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
		
	}

	public void historicoComSum() {
		// TODO Auto-generated method stub
		
	}

	public void login() {
		// TODO Auto-generated method stub
		
	}
	public void anadirStock(String id_s, String id_p, int cant) {
		// TODO Auto-generated method stub
		openConnection();
		try {
			stmt=con.prepareStatement(queryCall);
			stmt.setString(1, id_s);
			stmt.setString(2, id_p);
			stmt.setInt(3, cant);
			stmt.executeQuery();
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
	}
	@Override
	public boolean login(String id, String clave) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Collection<Historico> historicoComSum(String id) throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}
	private Collection<Pedido> listarPedidos(String id){
		Collection <Pedido> ped=new HashSet <Pedido>();
		openConnection();
		Pedido pedi;  
		try {
			stmt=con.prepareStatement(queryPedidos);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			while(rs.next()){
				pedi=new Pedido();
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
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ped;
	}
	

}
