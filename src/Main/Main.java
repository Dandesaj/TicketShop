package Main;
import java.util.ArrayList;
import java.util.Scanner;

import Modelo.Cliente;
import Modelo.Evento;
import Modelo.Vendedor;
import Modelo.Venta;
public class Main {
	public static ArrayList<Evento> eventos;
	public static ArrayList<Vendedor> vendedores;
	public static ArrayList<Cliente> clientes;
	private static String hoy;
	
	public static void main(String[] args) {
		setHoy("02-10-2021");
		
		Scanner sc= new Scanner(System.in);
		
		eventos= new ArrayList<>();	
		vendedores = new ArrayList<>();
		clientes = new ArrayList<>();
		poblarListas();
		Venta gestionador = new Venta();
		
        
		String p = "1";
		
		while(!p.equals("0") ){
			System.out.println("");			

			System.out.println("\n\n**************************");
			System.out.println("       Evento                 ");
			System.out.println("**************************");
			System.out.println("1.- Agregar Evento");
			System.out.println("2.- Vender Entrada");	
			System.out.println("3.- Ver y Modificar Estado de Eventos");
			System.out.println("4.- Mostrar Entradas Vendidas");
			System.out.println("5.- Ingresar a Eventos");
			System.out.println("6.- Estadisticas de Vendedores");
			
			p = sc.nextLine();
			
			
			switch(p) {
			case "1":
				agregar();				
				break;		
				
			case "2":
				
				vender(gestionador);
				break;
				
			case "3": // Ver y Modificar Estado de Eventos
				mostrarEventos();
				modificarEstadoEvento();
				break;
				
			case "4": //Mostrar Entradas Vendidas
				for(Evento temp : eventos ) {
					System.out.println(temp.getNombreEvento());
					temp.regitroDeEntradasVendidas();
				}
				break;	
				
			case "5": //Ingresar a Eventos
				
				ingresarAEvento();
				
				break;
				
			case "6": //Estadisticas de vendedores
				int indiceVendedor = getIndiceVendedor();
				System.out.println("Entradas Vendidas: " +	vendedores.get(indiceVendedor).getNombre() + " ha vendido:\n"+
						vendedores.get(indiceVendedor).getEntradasNormalesVendidas() + " entrada/s normal/es \n"
						+ vendedores.get(indiceVendedor).getEntradasVipVendidas() + " entrada/s VIP");
				
				
				break;
			default:
				System.out.println("Opcion no valida");
				
			}
		}// while	
		
		
	}
	
	public static void poblarListas() {
		Vendedor mrVenta = new Vendedor("mrVenta","19.201.564-6","9-04-1990");
		Vendedor ticketVacilon = new Vendedor("ticketVacilon","9.687.583-3","22-01-1972");
		Vendedor Juan = new Vendedor("Juan","8.125.369-7","15-06-1980");
        vendedores.add(mrVenta);
        vendedores.add(ticketVacilon);
        vendedores.add(Juan);
		
        Cliente fanRock = new Cliente("fanRock","16.341.532-8","06-08-2010",986354215);
        Cliente metalWoman = new Cliente("metalWoman","16.341.532-8","18-11-1999",986354215);
		clientes.add(metalWoman);
		clientes.add(fanRock);
		
		Evento poolParty = new Evento("PoolParty",18,false,10,5,"Flotador");
		Evento cenaConRorri = new Evento("cenaConRorri",8,false,3,1,"Package de codigo");
		agregarEvento(poolParty);
		agregarEvento(cenaConRorri);
	}
	
	public static String getHoy() {
		return hoy;
	}

	public static void setHoy(String hoy) {
		Main.hoy = hoy;
	}

	public static void ingresarAEvento() {		
		int indiceEvento = getIndiceEvento();
		//lista filtrrada
		eventos.get(indiceEvento).revisarEntrada(clientes.get(getIndiceCliente()));
	}
	
	public static int getIndiceCliente() {

		Scanner sc= new Scanner(System.in);
		
		System.out.println("Quien Eres? ");
		mostrarClientes();
		int indiceCliente=sc.nextInt();
		
		return indiceCliente;
	}

	public static int getIndiceEvento() {

		Scanner sc= new Scanner(System.in);
		
		System.out.println("Seleccione un evento");
		mostrarEventos();
		int indiceEvento=sc.nextInt();
		
		return indiceEvento;
	}
	
	public static int getIndiceVendedor() {

		Scanner sc= new Scanner(System.in);
		
		System.out.println("Seleccione un vendedor");
		mostrarVendedores();
		int indiceVendedor=sc.nextInt();
		
		return indiceVendedor;
	}
	
	public static Cliente crearCliente() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese su nombre");
		String nombre = sc.nextLine();
		System.out.println("Ingrese su RUT");
		String rut = sc.nextLine();
		System.out.println("Ingrese su Fecha Nacimiento");
		String fechaNac = sc.nextLine();
		System.out.println("Ingrese su telefono");
		int telefono = sc.nextInt();
		
		Cliente c = new Cliente(nombre,rut,fechaNac,telefono);
		clientes.add(c);
		return c;
	}
	
	public static void vender(Venta gestionador) {		
		int indiceEvento = getIndiceEvento();
		int indiceVendedor = getIndiceVendedor();
		
		gestionador.vendeEntrada(eventos.get(indiceEvento),vendedores.get(indiceVendedor),crearCliente(),getHoy());
		eventos.get(indiceEvento).registroEntradas();
	}
	
	public static void agregar() {
		Scanner sc= new Scanner(System.in);
		String nombreEvento="";
		String regaloVIP= "";
		int edadMinima=0;
		int entradasNormales=0;
		int entradasVIP=0;
		
		System.out.println("Nombre del evento");
		nombreEvento=sc.nextLine();
		
		System.out.println("Edad minima");
		edadMinima=sc.nextInt();
		
		System.out.println("Cuantas entradas normales?");
		entradasNormales=sc.nextInt();
		
		System.out.println("Cuantas entradas VIP?");
		entradasVIP=sc.nextInt();
		
		if(entradasVIP>0) {
			System.out.println("Cual va ser el regalo VIP?");
			regaloVIP=sc.nextLine();
		}
		
		Evento e= new Evento(nombreEvento, edadMinima, false,entradasNormales,entradasVIP,regaloVIP);
		agregarEvento(e);
		System.out.println("Creando evento " + e.getNombreEvento()+ " (Edad minima: "+e.getEdadMinima()+")");
		
		
	}
	
	public static void mostrarEventos() {
		int i=0;
		while (i<eventos.size()) {
			System.out.println(i + ".- "+ eventos.get(i).toString());
				i++;			
		}		
	}
	
	public static void mostrarClientes() {
		int i=0;
		while (i<clientes.size()) {
			System.out.println(i + ".- "+ clientes.get(i).toString());
				i++;			
		}		
	}
	
	public static void modificarEstadoEvento() {
		System.out.println("Desea modificar el estado de algun evento? (si/no)");
		Scanner sc= new Scanner(System.in);
		String sino = sc.nextLine();
		
		if (sino.equals("si")) {
			System.out.println("Seleccione un evento");
			//mostrarEventos();
			int indiceEvento=sc.nextInt();
			if(eventos.get(indiceEvento).isEnCurso()) {
				eventos.get(indiceEvento).setEnCurso(false);
			}else {
				eventos.get(indiceEvento).setEnCurso(true);
			}	
			
			System.out.println("El evento "+eventos.get(indiceEvento).getNombreEvento()
					+" se ha cambiado: "+ eventos.get(indiceEvento).isEnCurso());
			//mostrarEventos();
		}
	}
	
	public static void mostrarVendedores() {
		int i=0;
		while (i<vendedores.size()) {
			System.out.println(i  + ".- "+  vendedores.get(i).toString());
				i++;			
		}
	}
	
	public static void agregarEvento(Evento nuevoEvento) {
		eventos.add(nuevoEvento);
	}
	
	public boolean buscarEvento(String nombre) {
		boolean encontrado =false;
		int i=0;
		while (encontrado==false && i<eventos.size()) {
			if(eventos.get(i).getNombreEvento().compareToIgnoreCase(nombre)==0) {
				encontrado=true;
			}else{
				i++;
			}
		}
		if(encontrado) {
			//Hace algo si se encontro el estudiante
		}else {
			System.out.println("Evento no existe");
		}
		return encontrado;
	}

}
