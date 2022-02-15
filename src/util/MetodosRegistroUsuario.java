package util;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexiones.MetodosAccesoBD;
import objetos.Usuario;

public class MetodosRegistroUsuario {
	private static String error;

	public static void comprobarCampos(String nick, String nombreCompleto, String fechaNacimiento, String correo,
			String password, String password2) {

		error = "";
		if (nick.length() < 3) {
			error += "Nick ";
		}

		if (nombreCompleto.isEmpty()) {
			error += "Nombre ";
		}

		if (fechaNacimiento.isEmpty()) {
			error += "Fecha de nacimiento ";
		}

		if (password.isEmpty() || password.length() < 8) {
			error += "Contraseña ";
		}

		if (!password.equals(password2)) {
			error = "Las contraseñas no son iguales";
		}

		if (!error.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Faltan datos o datos incorectos en los siguientes campos: " + error,
					"Faltan datos", 0);
		}

		if (esUnCorreoValido(correo) && error.isEmpty()) {
			String numeroVerificacion = generarNumeroVerificacion();
			Usuario usu = new objetos.Usuario(nick, nombreCompleto, fechaNacimiento, correo, password,
					numeroVerificacion);
			try {
				MetodosAccesoBD.insertUsuario(usu);
			} catch (SQLException e) {
				System.err.print(e);
			}
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

	public static boolean esUnCorreoValido(String correo) {

		for (int i = 0; i < correo.length(); i++) {
			if (correo.charAt(i) == '@') {
				return true;
			}
		}
		return false;
	}

}
