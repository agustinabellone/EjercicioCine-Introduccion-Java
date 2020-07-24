package Dominio;


public class Sala {

	//Datos
	
	private final int CANTIDAD_DE_FILAS;
	private final int CANTIDAD_DE_ASIENTOS_POR_FILA;
	private String nombreDeLaSala;
	private Espectador[][] publico;
	
	//Método Constructor
		
	public Sala(String nombreDeLaSala, int cantidadDeFilas, int cantidadDeAsientosPorFila) {
		this.nombreDeLaSala = nombreDeLaSala;
		this.CANTIDAD_DE_FILAS = cantidadDeFilas;
		this.CANTIDAD_DE_ASIENTOS_POR_FILA = cantidadDeAsientosPorFila;
		publico = new Espectador[cantidadDeFilas][cantidadDeAsientosPorFila];
	}

	public boolean ingresarEspectador(int fila, int asiento, Espectador nuevoEspectador) {
		/*
		 * Realiza el ingreso de un espectador a la sala. Retorna true en caso
		 * de poder hacer la asignación o false en caso contrario (Sólo se puede
		 * ingresar un espectador que tenga una reserva previa).
		 */
		for (int i = 0; i < publico.length; i++) {
			for (int j = 0; j < publico[i].length; j++) {
				if (publico[fila - 1][asiento - 1] == null) {
					publico[fila - 1][asiento - 1] = nuevoEspectador;
					return true;
				}
			}
		}
		return false;
	}

	public String toString() {
		/*
		 * Devuelve un mapa de la sala del cine, de manera que se pueda
		 * seleccionar la ubicación deseada ante un nuevo ingreso. Por cada
		 * asiento debe indicar "L" (si se encuentra libre) y "O" (si se
		 * encuentra ocupado)
		 */
		System.out.println("");
		for (int i = 0; i < publico.length; i++) {
			System.out.println("");
			for (int j = 0; j < publico[i].length; j++) {
				System.out.print("");
				if (publico[i][j] != null) {
					return "x";
				}
			}
		}
		return "-";
	}

	public void vaciarSala() {
		/*
		 * Al finalizar una función se invoca este método para liberar cada
		 * asiento de la sala
		 */
		for (int i = 0; i < publico.length; i++) {
			for (int j = 0; j < publico[i].length; j++) {
				publico[i][j] = null;
				System.out.println("Se ha vaciado la sala.");
			}
		}
	}

	public int calcularCapacidadDeLaSala() {
		/*
		 * Devuelve la cantidad de asientos que tiene la sala
		 */
		int cantidadDeAsientos = this.getCANTIDAD_DE_ASIENTOS_POR_FILA() * this.getCANTIDAD_DE_FILAS();
		return (cantidadDeAsientos);
	}

	//Getters	
	 
	public int getCANTIDAD_DE_FILAS() {
		return CANTIDAD_DE_FILAS;
	}

	public int getCANTIDAD_DE_ASIENTOS_POR_FILA() {
		return CANTIDAD_DE_ASIENTOS_POR_FILA;
	}
}
