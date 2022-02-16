package util;

import java.sql.SQLException;

import conexiones.MetodosAccesoBD;
import interfaz.Registrar;
import objetos.Usuario;

public class MetodosRegistroUsuario {

	public static void comprobarCampos(String nick, String nombreCompleto, String fechaNacimiento, String correo,
			String password, String password2) {
		boolean esError = false;
		if (nick.length() < 3) {
			Registrar.cambiaFormato(1);
			esError = true;
		}

		if (password.isEmpty() || password.length() < 8) {
			Registrar.cambiaFormato(2);
			esError = true;
		}
		if (password2.isEmpty() || password2.length() < 8) {
			Registrar.cambiaFormato(3);
			esError = true;
		}
		
		if (!password.equals(password2)) {
			Registrar.cambiaFormato(3);
			esError = true;
		}

		if (fechaNacimiento.isEmpty()) {
			Registrar.cambiaFormato(5);
			esError = true;
		}

		if (nombreCompleto.isEmpty()) {
			Registrar.cambiaFormato(6);
			esError = true;
		}


		if (esUnCorreoValido(correo) && !esError) {
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
		Registrar.cambiaFormato(4);
		return false;
	}

}
