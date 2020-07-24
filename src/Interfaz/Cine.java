package Interfaz;

import java.util.Scanner;

import Dominio.Espectador;
import Dominio.Funcion;
import Dominio.Sala;

public class Cine {
	static Scanner entrada = new Scanner(System.in);
	private static int CANTIDAD_FUNCIONES_POR_DIA = 10;
	static Funcion funcion;
	static Sala sala;
	static int cantidadFuncionesRealizadas = 0;

	public static void main(String[] args) {

		System.out.println("¡Bienvenidos!");
		Sala sala1 = new Sala("Sala Darin", 50, 10);
		Sala sala2 = new Sala("Sala Oreiro", 30, 10);
		Sala sala3 = new Sala("Sala Jolie", 80, 30);

		Funcion funciones[] = new Funcion[CANTIDAD_FUNCIONES_POR_DIA];

		int opcion = 0;
		do {
			opcion = seleccionarOpcion();
			switch (opcion) {
			case 1:
				ingresarFunciones(funciones, sala1, sala2, sala3);
				break;
			case 2:
				realizarReserva(funciones);
				break;
			case 3:
				ingresarNuevoEspectador(funciones);
				break;
			case 4:
				mantenimientoDeSala(funciones);
				break;
			case 9:
				break;
			default:
				System.out.println("Opción Invalida");
				break;
			}

		} while (opcion != 9);
	}

	private static int seleccionarOpcion() {
		int opcionSeleccionada = 0;

		System.out.println("\n************************");
		System.out.println("Menú:\n");
		System.out.println("1 - Ingresar las funciones del día");
		System.out.println("2 - Realizar reserva ");
		System.out.println("3 - Ingresar nuevo espectador");
		System.out.println("4 - Mantenimiento de sala");
		System.out.println("9 - Salir");
		System.out.println("\n************************");
		System.out.println("Por favor, ingrese una opción:");

		opcionSeleccionada = entrada.nextInt();

		return opcionSeleccionada;
	}

	private static void ingresarFunciones(Funcion funciones[], Sala sala1, Sala sala2, Sala sala3) {
		/*
		 * Interfaz de usuario encargada de definir qué funciones ofrecerá el cine en un
		 * día determinado. Se debe considerar las salas que dispone el cine.
		 */
		String dia, pelicula;
		int aptaParaMayoresDe, hora;
		Sala sala = null;
		System.out.println("Ingrese Película");
		pelicula = entrada.next();
		System.out.println("Ingrese Día");
		dia = entrada.next();
		System.out.println("Ingrese hora");
		hora = entrada.nextInt();
		System.out.println("Es para mayores de: ");
		aptaParaMayoresDe = entrada.nextInt();
		System.out.println("Seleccionar sala: 1-2-3 ");
		int opcion = entrada.nextInt();
		switch (opcion) {
		case 1:
			sala = sala1;
			break;
		case 2:
			sala = sala2;
			break;
		case 3:
			sala = sala3;
			break;
		}
		funcion = new Funcion(dia, hora, pelicula, aptaParaMayoresDe, sala);
		funciones[cantidadFuncionesRealizadas++] = funcion;
		System.out.println("***¡Ha sido creada la función!***");
	}

	private static void realizarReserva(Funcion funciones[]) {
		/*
		 * Interfaz de usuario encargada de realizar una nueva reserva. Se debe
		 * seleccinar la función deseada e ingresar los datos del espectador
		 */
		String nombre, apellido;
		int dni, edad;
		System.out.println("Ingrese nombre: ");
		nombre = entrada.next();
		System.out.println("Ingrese apellido: ");
		apellido = entrada.next();
		System.out.println("Ingrese dni: ");
		dni = entrada.nextInt();
		System.out.println("Ingrese edad: ");
		edad = entrada.nextInt();

		Espectador nuevo = new Espectador(dni, nombre, apellido, edad);
		if (funcion.reservar(nuevo) == true) {
			System.out.println("***¡Reserva realizada!***");
		}
	}

	private static void ingresarNuevoEspectador(Funcion funciones[]) {
		/*
		 * Interfaz de usuario encargada de realizar el ingreso de un nuevo espectador.
		 * Se debe solicitar datos de la funcion y espectador. Sólo se pueden ingresar
		 * espectadores que tengan una reserva previa
		 */
		System.out.println("Ingrese dni para ver reserva:");
		int dni = entrada.nextInt();
		if (funcion.buscarReserva(dni) != null) {
			if (cantidadFuncionesRealizadas > 0) {
				System.out.println("***¡Se ha encontrado la reserva. Puede continuar!***");
				int fila, asiento;
				System.out.println("Ingrese sala: 1-2-3");
				int opcion = entrada.nextInt();
				switch (opcion) {
				case 1:
					System.out.println("Ingrese fila:");
					fila = entrada.nextInt();
					System.out.println("Ingrese columna:");
					asiento = entrada.nextInt();
					System.out.println("***¡Asiento reservado!***");
					break;
				case 2:
					System.out.println("Ingrese fila:");
					fila = entrada.nextInt();
					System.out.println("Ingrese columna:");
					asiento = entrada.nextInt();
					System.out.println("***¡Asiento reservado!***");
					break;
				case 3:
					System.out.println("Ingrese fila:");
					fila = entrada.nextInt();
					System.out.println("Ingrese columna:");
					asiento = entrada.nextInt();
					System.out.println("***¡Asiento reservado!***");
					break;
				default:
					System.out.println("***¡Función inválida!***");
					break;
				}
			}
		} else {
			System.out.println("***¡Debe registrarse!***");
		}
	}

	private static void mantenimientoDeSala(Funcion funciones[]) {
		/*
		 * Al finalizar una función, se solicita el mantenimiento de la sala, lo cual
		 * implica además de las tareas de limpieza, verificar que todos los asientos
		 * queden liberados para recibir una nueva función
		 */
		System.out.println("Ingrese 1 para vaciar la sala");
		int opcion = entrada.nextInt();
		if (opcion == 1) {
			sala.vaciarSala();
			System.out.println("***¡Se ha vaciado la sala!***");
		} else {
			System.out.println("***¡Opción incorrecta!***");
		}
	}
}
