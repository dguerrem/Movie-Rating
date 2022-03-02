package util;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexiones.ConexionMySQL;
import interfaz.Registrar;
import objetos.Usuario;

public class MetodosRegistroUsuario {

	private static Usuario usu;

	public static void comprobarCampos(String nick, String nombreCompleto, String fechaNacimiento, String correo,
			char[] password, char[] password2) {
		boolean esError = false;
		if (nick.length() < 3) {
			Registrar.cambiaFormato(1);
			esError = true;
		}

		if (password.length < 8) {
			Registrar.cambiaFormato(2);
			esError = true;
		}

		if (password2.length < 8) {
			Registrar.cambiaFormato(3);
			esError = true;
		}

		if (!String.valueOf(password).equals(String.valueOf(password2))) {
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
			usu = new objetos.Usuario(nick, nombreCompleto, fechaNacimiento, correo, String.valueOf(password),
					numeroVerificacion);
			try {
				if (MetodosAccesoBD.sePuedeCrear(usu.getNick())) {
					MetodosAccesoBD.insertUsuario(usu);
					MetodosEnvioMail.enviaMail(usu);
					compruebaCodigoVerificacion();
				} else {
					Registrar.cambiaFormato(7);
				}
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

	private static void compruebaCodigoVerificacion() {
		String usuCodIntroducido = JOptionPane.showInputDialog(null, "Introduzca el código de verificación: ");
		int cont = 3;

		while (!usuCodIntroducido.equals(usu.getCodVerificacion()) && cont > 0) {
			usuCodIntroducido = JOptionPane.showInputDialog(null, "Introduce cod: (" + cont + " intentos)");
			cont--;
		}

		if (cont == 0) {
			bloqueaUsuario();
		} else {
			// Entra a la aplicación
			JOptionPane.showMessageDialog(null, "Se ha verificado correctamente el usuario", "Registro Completo", 3);
		}
	}

	private static void bloqueaUsuario() {
		// Aquí borra todos los campos del formulario y borra el usuario que
		// recientemente ha creado
		// además informa al usuario de que debe rellenar de nuevo el usuario
		JOptionPane.showMessageDialog(null, "El usuario ha sido bloqueado, prueba a crear un nuevo.",
				"Usuario Bloqueado", 0);
	}

}
