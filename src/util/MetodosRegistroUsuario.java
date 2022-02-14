package util;

import java.sql.Date;
import javax.swing.JOptionPane;
import objetos.Usuario;

public class MetodosRegistroUsuario {

	// Metodo que tiene que llamarse al pulsar registrar usuario
	public static void comprobarCampos(String nombre, String apellido1, String apellido2, Date fechaNacimiento,
			String correo, String password, String password2) {

		String error = "";

		if (nombre.isEmpty() || nombre.length() < 8) {
			error += "Nombre ";
		}

		if (apellido1.isEmpty() || apellido2.isEmpty()) {
			error += "Apellidos ";
		}

		if (fechaNacimiento.equals(null)) {
			error += "Fecha de nacimiento ";
		}

		if (password.isEmpty() || password.length() < 8) {
			error += "Contraseña ";
		}

		if (password != password2) {
			error = "Las contraseñas no son iguales";
		}

		if (!error.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Faltan datos o datos incorectos en los siguientes campos: " + error,
					"Faltan datos", 0);
		}
		if (revisarCorreo(correo) && error.isEmpty()) {
			String numeroVerificacion = generarNumeroVerificacion();
			Usuario usu = new objetos.Usuario(nombre, apellido1, apellido2, fechaNacimiento, correo, password,
					numeroVerificacion);
			guardarUsuarioBBDD(usu);
			JOptionPane.showMessageDialog(null, "Revise su correo", "Usuario creado correctamente", 0);
		}

	}

	public static String generarNumeroVerificacion() {

		String letras = "abcdfghijklmnpqrstuvwxyz";
		String letrasMayus = letras.toUpperCase();
		String numeros = "0123456789";
		String todos = letras + letrasMayus + numeros;
		String numeroVerificacion = "";

		for (int i = 0; i < 6; i++) {
			int numero = (int) (Math.random() * todos.length() + 1);
			numeroVerificacion += todos.substring(numero - 1, numero);
		}

		return numeroVerificacion;
	}

	public static void guardarUsuarioBBDD(Usuario usu) {
		// Hay que implementar la logica para guardar un objeto en la BBDD, si no se
		// puede hay que crear los metodos get en usuario.

	}

	public static boolean revisarCorreo(String correo) {

		for (int i = 0; i < correo.length(); i++) {
			if (correo.charAt(i) == '@') {
				return true;
			}
		}

		return false;
	}

}
