package logica;

import java.time.LocalDate;
import java.util.Collection;

import modelo.*;

public interface ControladorSum {
	
	public Collection<Stock> stockSum(String id) throws ReadException;
	public void anadirStock(String id_s,String id_p,int cant);
	public void validarPedidoSum(String id_sum,String id_com,String id_prod,LocalDate fecha);
	public Collection<Historico> historicoComSum(String id) throws ReadException;
	public boolean login(String id, String clave) throws ReadException;
	public Collection<Pedido> listarPed(String id) throws ReadException;
	

}
