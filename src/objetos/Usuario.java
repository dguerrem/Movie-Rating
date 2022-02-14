package objetos;

import java.sql.Date;

public class Usuario {

	String nombre;
	String apellidoUno;
	String apellidoDos;
	Date fechaNacimiento;
	String correo;
	String password;
	String codVerificacion;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombre, String apellido1, String apellido2, Date fechaNacimiento, String correo,
			String password, String numeroVerificacion) {
		this.nombre = nombre;
		this.apellidoUno = apellido1;
		this.apellidoDos = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
		this.password = password;
		this.codVerificacion = numeroVerificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellidoUno;
	}

	public void setApellido1(String apellido1) {
		this.apellidoUno = apellido1;
	}

	public String getApellido2() {
		return apellidoDos;
	}

	public void setApellido2(String apellido2) {
		this.apellidoDos = apellido2;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumeroVerificacion() {
		return codVerificacion;
	}

	public void setNumeroVerificacion(String numeroVerificacion) {
		this.codVerificacion = numeroVerificacion;
	}

}
