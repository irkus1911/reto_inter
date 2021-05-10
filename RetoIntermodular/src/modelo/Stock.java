package modelo;

public class Stock extends Producto {
	
	 private String id_usu,id_prod;
	 private int cantidad;
	 
	public String getId_usu() {
		return id_usu;
	}
	public void setId_usu(String id_usu) {
		this.id_usu = id_usu;
	}
	public String getId_prod() {
		return id_prod;
	}
	public void setId_prod(String id_prod) {
		this.id_prod = id_prod;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
