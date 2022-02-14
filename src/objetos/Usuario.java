package objetos;

import java.sql.Date;

public class Usuario {

	String nombre;
	String apellido1;
	String apellido2;
	Date fechaNacimiento;
	String password;
	String numeroVerificacion;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Usuario(String nombre, String apellido1, String apellido2, Date fechaNacimiento, String password, String numeroVerificacion) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
		this.numeroVerificacion = numeroVerificacion;
	}
	
	
	
}
