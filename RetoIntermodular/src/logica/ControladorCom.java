package logica;

import java.time.LocalDateTime;
import java.util.Collection;

import logica.exception.ConnectException;
import logica.exception.CreateException;
import logica.exception.ReadException;
import logica.exception.UpdateException;
import modelo.*;

public interface ControladorCom {
	
	public boolean login(String id, String clave) throws ReadException, ConnectException;
	public void crearPedidoComSum(String id_comp, String id_ven, String id_prod, int cant) throws CreateException, ConnectException;
	public void validarPedidoCom(String id, String id_com, String id_prod, LocalDateTime fecha) throws UpdateException, ConnectException;
	public Collection<Historico> historicoClieCom(String id) throws ReadException, ConnectException;
	public Collection<Historico> historicoComSum(String id) throws ReadException, ConnectException;
	public Collection<Stock> stockCom(String id) throws ReadException, ConnectException;
	public Collection<Producto> listarProd() throws ReadException, ConnectException;
	public Collection<Suministrador> listarVendedor(String id_prod, String id_sum) throws ReadException, ConnectException;
	public Integer listarCant(String id_sum, String id_prod) throws ReadException, ConnectException;
	public Collection<Pedido> listarPed(String id) throws ReadException, ConnectException;
	

	
}
