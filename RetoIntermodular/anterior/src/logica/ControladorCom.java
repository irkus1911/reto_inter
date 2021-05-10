package logica;

import java.util.Collection;

import modelo.*;

public interface ControladorCom {
	
	public boolean login(String id, String clave) throws ReadException;
	public Collection<Stock> stockCom(String id);
	public Collection<Historico> historicoClieCom(String id) throws ReadException;
	public void validarPedidoCom();
	public void crearPedidoComSum(String id_comp, String id_ven, String id_prod, int cant) throws CreateException;
	public Collection<Historico> historicoComSum(String id);
	
}
