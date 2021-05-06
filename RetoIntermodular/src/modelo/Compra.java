package modelo;

import java.time.LocalDate;

public class Compra {

	private String idComprador;
	private String idVendedor;
	private String idProd;
	private LocalDate fecha;
	private int cant;
	
	
	public String getIdComprador() {
		return idComprador;
	}
	public void setIdComprador(String idComprador) {
		this.idComprador = idComprador;
	}
	public String getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}
	public String getIdProd() {
		return idProd;
	}
	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}

}
