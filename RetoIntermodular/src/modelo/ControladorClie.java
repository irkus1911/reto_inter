package modelo;

import java.util.Collection;

import excepciones.*;

public interface ControladorClie {
	
	public void crearPedidoClieCom(Pedido ped) throws CreateException;
	public Collection<Historico> historicoClieCom(String id) throws ReadException;
	public boolean login(String id, String clave) throws ReadException;
	public Collection<Producto> listarProd() throws ReadException;
	
}
