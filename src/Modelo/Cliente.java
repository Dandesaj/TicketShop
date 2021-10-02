package Modelo;

public class Cliente extends Persona{
  private int telefono;

  public Cliente() {
	  super("","","");
  }
  
  public Cliente(String nombre,String rut,String fechaNac, int telefono) {
	  super(nombre, rut, fechaNac);
	  this.telefono = telefono;
  }

  //GETTER Y SETTER
  public int getTelefono() {
	return telefono;
}
  public void setTelefono(int telefono) {
	this.telefono = telefono;
}

@Override
public String toString() {
	return "Cliente:" + nombre + ", RUT: " + rut ;
}
  
}
