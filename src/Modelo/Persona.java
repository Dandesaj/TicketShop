package Modelo;

public class Persona {
	protected String nombre;
	protected String rut;
	protected String fechaNac;//dd-mm-aaaa
	
	public Persona () {
		
	}
	  
	public Persona(String nombre,String rut,String fechaNac) {
		super();
		this.nombre = nombre;
		this.rut = rut;
		this.fechaNac = fechaNac;
		}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", rut=" + rut + ", fechaNac=" + fechaNac + "]";
	}
	
	
	public int calcularEdad(String hoy) { //dd-mm-aaaa
		
		//int dia = Integer.parseInt(fechaCliente.substring(0,2));
		//int mes = Integer.parseInt(fechaCliente.substring(3,5));
		//int año = Integer.parseInt(fechaCliente.substring(6,10));
		
		int edad = Integer.parseInt(hoy.substring(6,10)) 
							- 
				Integer.parseInt(getFechaNac().substring(6,10));
	
		return edad;
	}
	
}
