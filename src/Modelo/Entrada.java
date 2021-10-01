package Modelo;
import Modelo.Cliente;
public class Entrada {
	private int precio; 
	private int noAsiento;
	private boolean usado; 
	private Cliente cliente;
	
	
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getNoAsiento() {
		return noAsiento;
	}
	public void setNoAsiento(int noAsiento) {
		this.noAsiento = noAsiento;
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
	
	
	
}
