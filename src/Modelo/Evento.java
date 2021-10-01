package Modelo;

import java.awt.List;

public class Evento {
	private String NombreEvento;
	private int EdadMinima;
	private List ListaEntradas;
	private boolean EnCurso;
	
	
	
	public String getNombreEvento() {
		return NombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		NombreEvento = nombreEvento;
	}
	public int getEdadMinima() {
		return EdadMinima;
	}
	public void setEdadMinima(int edadMinima) {
		EdadMinima = edadMinima;
	}
	public List getListaEntradas() {
		return ListaEntradas;
	}
	public void setListaEntradas(List listaEntradas) {
		ListaEntradas = listaEntradas;
	}
	public boolean isEnCurso() {
		return EnCurso;
	}
	public void setEnCurso(boolean enCurso) {
		EnCurso = enCurso;
	}
	@Override
	public String toString() {
		return "Evento [NombreEvento=" + NombreEvento + ", EdadMinima=" + EdadMinima + ", ListaEntradas="
				+ ListaEntradas + ", EnCurso=" + EnCurso + "]";
	}
	
	
	
	
	
}
