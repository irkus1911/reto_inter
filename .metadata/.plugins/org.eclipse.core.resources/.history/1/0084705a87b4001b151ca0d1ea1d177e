package logica;

import java.time.LocalDateTime;
import java.util.Collection;

import logica.exception.ConnectException;
import logica.exception.CreateException;
import logica.exception.ReadException;
import logica.exception.UpdateException;
import modelo.*;

public interface ControladorSum {
	
	public Collection<Stock> stockSum(String id) throws ReadException , ConnectException;
	public void anadirProd(String id_s,String id_p,int cant, String nombre) throws CreateException , ConnectException; 
	public void validarPedidoSum(String id_sum,String id_com,String id_prod,LocalDateTime fecha) throws UpdateException , ConnectException;
	public Collection<Historico> historicoSumCom(String id) throws ReadException , ConnectException;
	public boolean login(String id, String clave) throws ReadException , ConnectException;
	public Collection<Pedido> listarPed(String id) throws ReadException , ConnectException;
	

}
