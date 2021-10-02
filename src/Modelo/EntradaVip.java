package Modelo;

public class EntradaVip extends Entrada {
	private boolean regalo;
	
	public EntradaVip(int precio, int numAsiento, boolean usado) {
		super(precio, numAsiento, usado);
		
	}	
	
	public boolean isRegalo() {
		return regalo;
	}
	public void setRegalo(boolean regalo) {
		this.regalo = regalo;
	}
	
	
}
