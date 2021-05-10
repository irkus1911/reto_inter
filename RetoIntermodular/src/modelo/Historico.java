package modelo;

public class Historico extends Compra{

	private String vendedor;
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
}
