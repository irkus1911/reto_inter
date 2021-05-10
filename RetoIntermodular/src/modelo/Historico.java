package modelo;

public class Historico extends Compra{

	private String vendedor,comprador;
	private String producto;
	
	// Para facilitar la muestra de datos a los Clientes, se 
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getComprador() {
		return comprador;
	}
	public void setComprador(String comprador) {
		this.comprador = comprador;
	}
}
