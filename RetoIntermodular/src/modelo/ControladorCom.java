package modelo;

import java.util.Collection;

import excepciones.CreateException;
import excepciones.ReadException;

public interface ControladorCom {
	
	public boolean login(String id, String clave) throws ReadException;
	public Collection<Stock> stockCom(String id);
	public Collection<Historico> historicoClieCom(String id) throws ReadException;
	public void validarPedidoCom();
	//public void crearPedidoComSum();
	//public void crearPedidoClieCom(String id_clie, String id_com, String id_prod, int cant) throws CreateException;
	public void historicoComSum(String id);
	
}
