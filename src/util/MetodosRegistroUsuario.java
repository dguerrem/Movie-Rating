package util;

import java.sql.SQLException;
import javax.swing.JOptionPane;
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

	private static void compruebaCodigoVerificacion() throws SQLException {
		String usuCodIntroducido = JOptionPane.showInputDialog(null,
				UtilidadesComunes.getConstante("introduzca_codigo"));
		int cont = 3;

		while (!usuCodIntroducido.equals(usu.getCodVerificacion()) && cont > 0) {
			usuCodIntroducido = JOptionPane.showInputDialog(null, UtilidadesComunes.getConstante("introduce_cod") + cont
					+ UtilidadesComunes.getConstante("intentos"));
			cont--;
		}

		if (cont == 0) {
			bloqueaUsuario();
		} else {
			JOptionPane.showMessageDialog(null, UtilidadesComunes.getConstante("verificado_correctamente"),
					UtilidadesComunes.getConstante("registro_completo"), 3);
		}
	}

	private static void bloqueaUsuario() throws SQLException {
		MetodosAccesoBD.deleteUsuario(usu);
		JOptionPane.showMessageDialog(null, UtilidadesComunes.getConstante("usuario_bloqueado"),
				UtilidadesComunes.getConstante("usu_bloq"), 0);
	}
}
