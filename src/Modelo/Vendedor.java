package Modelo;

public class Vendedor extends Persona {

	private int entradasNormalesVendidas;
	private int entradasVipVendidas;
	
	//Constructor con 
	public Vendedor() {
		super("","","");
	}
	
	public Vendedor(String nombre,String rut,String fechaNac) {
		super(nombre, rut, fechaNac);
		this.entradasNormalesVendidas =0;
		this.entradasVipVendidas =0;
	}

	
	//GETTER Y SETTER NORMALES
	public int getEntradasNormalesVendidas() {
		return entradasNormalesVendidas;
	}
	public void setEntradasNormalesVendidas(int entradasNormalesVendidas) {
		this.entradasNormalesVendidas = entradasNormalesVendidas;
	}

	//GETTER Y SETTER VIP
	public int getEntradasVipVendidas() {
		return entradasVipVendidas;
	}
	public void setEntradasVipVendidas(int entradasVipVendidas) {
		this.entradasVipVendidas = entradasVipVendidas;
	}

	@Override
	public String toString() {
		return "Vendedor: "+this.nombre;
	}
	
}
	
	



