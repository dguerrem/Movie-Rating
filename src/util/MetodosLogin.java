package util;

import javax.swing.JOptionPane;

public class MetodosLogin {

	public static String transformPassword(String password) {

		String passAsteriscos = "";
		for (int i = 0; i < password.length(); i++) {
			passAsteriscos += "*";
		}
		return passAsteriscos;
	}

	public static boolean puedeIniciarSesion(String usuario, String password) {
		System.out.println(usuario + "\n" + password);

		if (usuario.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Faltan datos", "Titulo", 0);
			return false;
		}

		return true;
		// Hay que mirar que condiciones ponemos para que se puedan logear ej(contraseña
		// inferior a 8 caracteres ...)

		// Hay que hacer un select a la BBDD y comprobar que el nombre de usuario este
		// si esta hay que comparar si la contraseña es igual
	}

}
