package logica;

import java.util.Collection;

import modelo.*;

public interface ControladorClie {
	
	public boolean login(String id, String clave) throws ReadException;
	public Collection<Historico> historicoClieCom(String id) throws ReadException;
	public Collection<Producto> listarProd() throws ReadException;
	public Collection<Comercio> listarVendedor(String id_prod, String id_clie) throws ReadException;
	public Integer listarCant(String id_com, String id_prod) throws ReadException;
	public void crearPedidoClieCom(String id_clie, String id_com, String id_prod, int cant) throws CreateException;
	
}
