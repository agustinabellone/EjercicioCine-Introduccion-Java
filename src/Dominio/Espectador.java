package Dominio;

public class Espectador {
	
	//Datos
	
	private int dni;
	private String nombre;
	private String apellido;
	private int edad;
	
	//Método Constructor
	
	public Espectador(int dni, String nombre, String apellido, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	
	//Getters & Setters 
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String toString() {	
		
		//Debe mostrar la información que identifique a un espectador
		
		return "Nombre: " + nombre + " | Apellido: " + apellido;
	}
	
	
}
