package Modelo;

public class Persona {
	protected String nombre;
	protected String rut;
	protected String fechaNac;
	
	  
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
	
	
}
