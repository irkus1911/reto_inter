package logica;

import java.time.LocalDateTime;
import java.util.Collection;

import modelo.*;

public interface ControladorSum {
	
	public Collection<Stock> stockSum(String id) throws ReadException;
	public void anadirProd(String id_s,String id_p,int cant, String nombre) throws CreateException; 
	public void validarPedidoSum(String id_sum,String id_com,String id_prod,LocalDateTime fecha) throws UpdateException;
	public Collection<Historico> historicoSumCom(String id) throws ReadException;
	public boolean login(String id, String clave) throws ReadException;
	public Collection<Pedido> listarPed(String id) throws ReadException;
	

}
