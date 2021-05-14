package logica;

import java.util.Collection;

import logica.exception.ConnectException;
import logica.exception.CreateException;
import logica.exception.ReadException;
import modelo.*;

public interface ControladorClie {
	
	public boolean login(String id, String clave) throws ReadException, ConnectException;
	public Collection<Historico> historicoClieCom(String id) throws ReadException , ConnectException;
	public Collection<Producto> listarProd() throws ReadException, ConnectException;
	public Collection<Comercio> listarVendedor(String id_prod, String id_clie) throws ReadException , ConnectException;
	public Integer listarCant(String id_com, String id_prod) throws ReadException , ConnectException;
	public void crearPedidoClieCom(String id_clie, String id_com, String id_prod, int cant) throws CreateException , ConnectException;
	
}
