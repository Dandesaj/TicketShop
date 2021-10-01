package Modelo;

public class Vendedor extends Persona {

	private int entradasVendidas;
	
		
	public Vendedor(String nombre,String rut,String fechaNac) {
		super(nombre, rut, fechaNac);
		this.entradasVendidas =0;
	}

	public int getEntradasVendidas() {
		return entradasVendidas;
	}

	public void setEntradasVendidas(int entradasVendidas) {
		this.entradasVendidas = entradasVendidas;
	}

	@Override
	public String toString() {
		return "Vendedor [entradasVendidas=" + entradasVendidas + "]";
	}
	
	public void vendeEntrada() {
	}
	
	
	public void actualizarLista() {
	}
	}





