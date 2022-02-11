package util;

public class MetodosLogin {

	public static String transformarContraseña(String contraseña) {
		int tamañoContrasea = contraseña.length();
		String contraseñaAsteriscos = "";
		for (int i = 0; i < tamañoContrasea; i++) {
			contraseñaAsteriscos += "*";
		}
		return contraseñaAsteriscos;
	}
}
