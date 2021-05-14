package logica;

import java.time.LocalDate;
import java.util.Collection;

import modelo.*;

public interface ControladorCom {
	
	public boolean login(String id, String clave) throws ReadException;
	public void crearPedidoComSum(String id_comp, String id_ven, String id_prod, int cant) throws CreateException;
	public void validarPedidoCom(String id, String id_com, String id_prod, LocalDate fecha);
	public Collection<Historico> historicoClieCom(String id) throws ReadException;
	public Collection<Historico> historicoComSum(String id) throws ReadException;
	public Collection<Stock> stockCom(String id) throws ReadException;
	public Collection<Producto> listarProd() throws ReadException;
	public Collection<Suministrador> listarVendedor(String id_prod) throws ReadException;
	public Integer listarCant(String id_sum, String id_prod) throws ReadException;
	public Collection<Pedido> listarPed(String id) throws ReadException;
	

	
}
