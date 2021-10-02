package Modelo;
import Modelo.Cliente;
public class Entrada {
	private int precio; 
	private int numAsiento;
	private boolean usado; 
	private Cliente cliente;
	private Vendedor vendedor;
	private boolean disponible;
	
	public Entrada(int precio,int numAsiento, boolean usado) {
		this.precio = precio;
		this.numAsiento = numAsiento;
		this.usado = usado;
		this.disponible = true;
		this.cliente = new Cliente();
		this.vendedor  =new Vendedor();
		
	}
	public int getNumAsiento() {
		return numAsiento;
	}
	public void setNumAsiento(int numAsiento) {
		this.numAsiento = numAsiento;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public int getPrecio() {
		return precio;
	}
	
	
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getNoAsiento() {
		return numAsiento;
	}
	public void setNoAsiento(int noAsiento) {
		this.numAsiento = noAsiento;
	}
	public boolean isUsado() {
		return usado;
	}
	public void setUsado(boolean usado) {
		this.usado = usado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	@Override
	public String toString() {
		return "Asiento=" + numAsiento + ", usado=" + usado + " " + cliente + 
				" "+ vendedor;
	}
	
	
	
}
