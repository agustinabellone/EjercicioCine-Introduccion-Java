package Dominio;

import Interfaz.Cine;

public class Funcion {
	
	//Datos
	
	private String dia;
	private int hora;
	private String pelicula;
	private int aptaParaMayoresDe;
	private Sala sala;
	private Espectador[] reservas = new Espectador[100];
	private Cine cine;
	private int cantidadReservasRealizadas = 0;
	
	//Método Constructor
	
	public Funcion(String dia, int hora, String pelicula, int aptaParaMayoresDe, Sala sala) {
		this.dia = dia;
		this.hora = hora;
		this.pelicula = pelicula;
		this.aptaParaMayoresDe = aptaParaMayoresDe;
		this.sala = sala;
	}

	public boolean reservar(Espectador nuevo) {
		/*
		 * Realiza una reserva para la función (siempre que el espectador esté
		 * habilitado por su edad)
		 * 
		 */
		if (cantidadReservasRealizadas < reservas.length) {
			for (int i = 0; i < reservas.length; i++) {
				if (reservas[i] == null) {
					reservas[i] = nuevo;
					cantidadReservasRealizadas++;
					return true;
				}
			}
		}
		return false;

	}

	public Espectador buscarReserva(int dni) {
		/*
		 * A partir de un DNI busca un espectador en 
		 * la lista de reservas de la función
		 */
		if (cantidadReservasRealizadas > 0) {
			for (int i = 0; i < reservas.length; i++) {
				if (reservas[i] != null && reservas[i].getDni() == dni) {
					return reservas[i];
				}
			}
		}
		return null;
	}

	public Espectador[] getReservas() {
		return reservas;
	}
}
