package util;

public class MetodosLogin {

	public static String transformarContrase�a(String contrase�a) {
		int tama�oContrasea = contrase�a.length();
		String contrase�aAsteriscos = "";
		for (int i = 0; i < tama�oContrasea; i++) {
			contrase�aAsteriscos += "*";
		}
		return contrase�aAsteriscos;
	}
}
