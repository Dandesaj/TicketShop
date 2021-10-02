package Modelo;
import java.util.Scanner;

import Modelo.Evento;
public class Venta {
	
	//CONSTRUCTOR
	public Venta() {
		
	}
		
	//DEVUELVE TRUE SI HAY ENTRADAS DISPONIBLES
	private boolean revisarVentaNormal(Evento e) {
		return e.entradaNormalDisponible();
	}
	private boolean revisarVentaVIP(Evento e) {
		return e.entradaVIPipDisponible();
	}
	
	//REVISA LA EDAD Y DEPENDIENDO DEL TIPO PROCESSA LA ENTRADA
	public void vendeEntrada(Evento e,Vendedor vendedor, Cliente cliente, String hoy) {
		System.out.println("Que tipo de entrada desea comprar?");
		boolean normal = revisarVentaNormal(e);
		boolean vip = revisarVentaVIP(e);
		
		if(normal) {
			System.out.println("1- Normal");
			
		}
		if(vip) {
			System.out.println("2- VIP");
		}
		Scanner sc = new Scanner(System.in);
		int tipo = sc.nextInt();
				
		
		switch(tipo) {
		case 1:
			if(normal) {
				if(cliente.calcularEdad(hoy)>=e.getEdadMinima()) {
					
					int indice = e.indiceEntradaNormalDisponible();	
					
					e.modificarEntradaNormal(indice,vendedor, cliente);
					
					vendedor.setEntradasNormalesVendidas(vendedor.getEntradasNormalesVendidas()+1);
					
					System.out.println("Vendiendo entrada para cliente " + cliente.getNombre() + " ("+
								cliente.getRut()+") Para Evento: " + e.getNombreEvento());
				}else {
					System.out.println("No se pudo concretar la venta, el cliente es menor a la edad minima del evento");
				}
			}else {
				System.out.println("Que no hay!"); 
			}
			
		break;
		
		case 2:
			if (vip) {
				if(cliente.calcularEdad(hoy)>=e.getEdadMinima()) {
					int indice = e.indiceEntradaVIPDisponible();
					
					e.modificarEntradaVIP(indice,vendedor, cliente);
					
					vendedor.setEntradasVipVendidas(vendedor.getEntradasVipVendidas()+1);
					
					System.out.println("Vendiendo entrada VIP para cliente " + cliente.getNombre() + " ("+
								cliente.getRut()+") Para Evento: " + e.getNombreEvento());
				}else {
					System.out.println("No se pudo concretar la venta, el cliente es menor a la edad minima del evento");
				}
			}else {
				System.out.println("Que no hay!"); 
			}
			break;
		default: 
			System.out.println("Opcion no valida");
		}
	}
	
		
}
