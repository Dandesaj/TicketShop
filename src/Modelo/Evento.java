package Modelo;
import Modelo.Cliente;
import java.awt.List;
import java.util.ArrayList;

public class Evento {
	private String nombreEvento;
	private int edadMinima;
	private ArrayList<Entrada> listaEntradasNormales;
	private ArrayList<EntradaVip>  listaEntradasVIP;
	private boolean enCurso;
	private int entradasNormales;
	private int entradasVIP;
	private String regalo;
	
	//CONSTRUCTOR
	public Evento(String nombreEvento, int edadMinima, boolean enCurso, int entradasNormales, int entradasVIP, String regalo ) {
		super();
		this.nombreEvento = nombreEvento;
		this.edadMinima = edadMinima;
		this.enCurso = enCurso;
		this.entradasNormales = entradasNormales;
		this.entradasVIP = entradasVIP;
		this.listaEntradasNormales = new ArrayList<Entrada>();
		this.listaEntradasVIP = new ArrayList<EntradaVip>();
		this.regalo = regalo;
		crearEntradas();	
	}
	
	//GENERA LISTA VACIA DE ENTRADAS 
	private void crearEntradas() {
		for(int i=0; i<entradasNormales;i++) {
			//precio numAsiento usado 
			Entrada e= new Entrada(0, i, false);
			listaEntradasNormales.add(e);
		}
		
		for(int j=0; j<entradasVIP;j++) {
			//precio numAsiento usado 
			EntradaVip v= new EntradaVip(0, j, false);
			listaEntradasVIP.add(v);
		}
		
	}
	
	//REVISA LA ENTRADA AL MOMENTO DE QUERER ENTRAR
	public void revisarEntrada(Cliente cliente) {
		boolean comprado= false;
		if (enCurso) {		
			for(Entrada temp : listaEntradasNormales) {
				if (temp.getCliente().getRut() == cliente.getRut()) {
					comprado = true;
					if(temp.isUsado()) {
						System.out.println("Usando entrada con cliente" + cliente.getNombre()+" ("+cliente.getRut()+")"+
								"para evento "+ getNombreEvento() + "\nEntrada para RUT, "+ cliente.getRut()
								+" ya fue usada, no puede pasar");
					}else {							
						System.out.println("Usando entrada con cliente" + cliente.getNombre()+" ("+cliente.getRut()+")"+
								"para evento "+ getNombreEvento() + "\nEntrada encontrada, "+ cliente.getNombre()+" puede pasar");
						temp.setUsado(true);
						
					}
				}
			}
			for(EntradaVip temp : listaEntradasVIP) {
				if (temp.getCliente().getRut() == cliente.getRut()) {
					comprado = true;
					if(temp.isUsado()) {
						System.out.println("Usando entrada con cliente" + cliente.getNombre()+" ("+cliente.getRut()+")"+
								"para evento "+ getNombreEvento() + "\nEntrada para RUT, "+ cliente.getRut()
								+" ya fue usada, no puede pasar");
					}else {							
						System.out.println("Usando entrada VIP con cliente" + cliente.getNombre()+" ("+cliente.getRut()+")"+
								"para evento "+ getNombreEvento() + "\nEntrada VIP encontrada, "+ cliente.getNombre()+" puede pasar");
						System.out.println("has recibido un  "+regalo);
						temp.setUsado(true);
						temp.setRegalo(true);
						
					}
				}
			}
			if (!comprado) {				
				System.out.println("El cliente no compro entrada para este evento");
			}
		}else {
			System.out.println("Usando entrada con cliente: "+cliente.getNombre()+" ("+cliente.getRut()+") "+
					"para evento "+ getNombreEvento() +"\nNo se puede usar la entrada porque el evento "
					+getNombreEvento()+ " no esta en curso");
		}
	}
	
	//IMPRIME LISTADO DE ENTRADAS VENDIDAS DEL EVENTO, VIP Y NORMAL
	public void regitroDeEntradasVendidas() {
		System.out.println("\nEntradas Normales");
		for(Entrada temp : listaEntradasNormales) {
			if (!temp.isDisponible()) {
				System.out.println(nombreEvento +" " +  temp.toString());
			}
		}
		System.out.println("\nEntradas VIP");
		for(EntradaVip temp : listaEntradasVIP) {
			if (!temp.isDisponible()) {
				System.out.println(nombreEvento +" " +  temp.toString());
			}
		}
		
		
	}
	//IMPRIME LISTA COMPLETA DE ENTRADAS DEL EVENTO (INC NO VENDIDAS)
	public void registroEntradas() {
		for(Entrada temp : listaEntradasNormales) {
			System.out.println(temp.toString());
		}
		for(EntradaVip temp : listaEntradasVIP) {
			System.out.println(temp.toString());
		}
	}
	

	//REVISA SI HAY ENTRADAS DISPONIBLES
	public boolean entradaNormalDisponible() {
		int disp=0;
		boolean hay=false;
		for(Entrada temp : listaEntradasNormales) {
			if (temp.isDisponible()) {
				disp++;
			}
		}
		if(disp>0) {
			System.out.println("Hay "+ disp  +" Normales disponibles");
			hay = true;
		}
		return hay;
	}
	public boolean entradaVIPipDisponible() {
		int disp=0;
		boolean hay=false;
		for(Entrada temp : listaEntradasNormales) {
			if (temp.isDisponible()) {
				disp++;
			}
		}
		if(disp>0) {
			System.out.println("Hay "+ disp  +" VIP disponibles");
			hay = true;
		}
		return hay;
	}

	//DEVUELVE EL INDICE DEL PROXIMO ASIENTO LIBRE
	public int indiceEntradaNormalDisponible() {
		int disp=-1;
		int count=0;
		for(Entrada temp : listaEntradasNormales) {
			if (temp.isDisponible()) {
				disp =count;
				break;
			}
			count++;
		}
		
		return disp;
	}
	public int indiceEntradaVIPDisponible() {
		int disp=-1;
		int count=0;
		for(EntradaVip temp : listaEntradasVIP) {
			if (temp.isDisponible()) {
				disp =count;
				break;
			}
			count++;
		}
		
		return disp;
	}

	
	//MODIFICA ENTRADA EN BLANCO CON DATOS DE LA VENTA
	public void modificarEntradaNormal(int indice, Vendedor vendedor, Cliente cliente) {
		Entrada temp = listaEntradasNormales.get(indice);
		temp.setCliente(cliente);
		temp.setVendedor(vendedor);
		temp.setDisponible(false);
		listaEntradasNormales.set(indice, temp);
	}
	public void modificarEntradaVIP(int indice, Vendedor vendedor, Cliente cliente) {
		
			EntradaVip temp = listaEntradasVIP.get(indice);
			temp.setCliente(cliente);
			temp.setVendedor(vendedor);
			temp.setDisponible(false);
			listaEntradasVIP.set(indice, temp);
		
	}
	
	
	//GETTER Y SETTER
	public ArrayList getListaEntradasNormales() {
		return listaEntradasNormales;
	}
	public void setListaEntradasNormales(ArrayList listaEntradasNormales) {
		this.listaEntradasNormales = listaEntradasNormales;
	}
	
	public void setListaEntradasVIP(ArrayList listaEntradasVIP) {
		this.listaEntradasVIP = listaEntradasVIP;
	}
	public ArrayList getListaEntradasVIP() {
		return listaEntradasVIP;
	}
	
	public int getEntradasNormales() {
		return entradasNormales;
	}
	public void setEntradasNormales(int entradasNormales) {
		this.entradasNormales = entradasNormales;
	}

	public int getEntradasVIP() {
		return entradasVIP;
	}
	public void setEntradasVIP(int entradasVIP) {
		this.entradasVIP = entradasVIP;
	}

	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	
	public int getEdadMinima() {
		return edadMinima;
	}
	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}
	
	public boolean isEnCurso() {
		return enCurso;
	}
	public void setEnCurso(boolean enCurso) {
		this.enCurso = enCurso;
	}


	//OVERRIDE DE TOSTRING
	@Override
	public String toString() {
		return "Event: " + nombreEvento + "\nedadMinima=" + edadMinima + " enCurso=" + enCurso
				+ ", entradasNormales=" + entradasNormales + ", entradasVIP=" + entradasVIP +"\n";
	}

	
		
		
		
		
}
