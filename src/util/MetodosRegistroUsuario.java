package util;

import java.sql.Date;
import javax.swing.JOptionPane;
import objetos.Usuario;

public class MetodosRegistroUsuario {
	
	
	//Metodo que tiene que llamarse al pulsar registrar usuario
	public static void comprobarCampos (String nombre, String apellido1, String apellido2, Date fechaNacimiento, String password) {
		
		String error = "";
		
		if(nombre.isEmpty() || nombre.length()<8) {
			error += "Nombre ";
		}
		
		if(apellido1.isEmpty() || apellido2.isEmpty()) {
			error += "Apellidos ";
		}
		
		if (fechaNacimiento.equals(null)) {
			error += "Fecha de nacimiento ";
		}
		
		if (password.isEmpty() || password.length()<8) {
			error += "Contraseña ";
		}
		
		if (error.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Faltan datos o datos incorectos en los siguientes campos: " + error, "Faltan datos", 0);
		}else {
			String numeroVerificacion = generarNumeroVerificacion();
			Usuario usu = new objetos.Usuario(nombre, apellido1, apellido2, fechaNacimiento, password, numeroVerificacion);
			
		}
			
	}
	
	
	public static String generarNumeroVerificacion() {
		
		String letras = "abcdfghijklmnpqrstuvwxyz";
		String letrasMayus = letras.toUpperCase();
		String numeros = "0123456789";
		String todos = letras+letrasMayus+numeros;
		String numeroVerificacion="";
		
		for (int i = 0; i < 6; i++) {
			int numero = (int)(Math.random()*todos.length()+1);
			numeroVerificacion += todos.substring(numero -1,numero);
		}
		
		return numeroVerificacion; 
	}
	
	public void guardarUsuarioBBDD (Usuario usu) {
		//Hay que implementar la logica para guardar un objeto en la BBDD, si no se puede hay que crear los metodos get en usuario.
		
	}

}
