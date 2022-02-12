package util;

import java.awt.Dialog;

import javax.swing.JOptionPane;

import interfaz.Login;

public class MetodosLogin {

	public static String transformarContraseña(String password) {
		
		String passAsteriscos = "";
		for (int i = 0; i < password.length(); i++) {
			passAsteriscos += "*";
		}
		return passAsteriscos;
	}
	
	public static void iniciarSesion(String usuario, String password) {
		String error = "";
		System.out.println(usuario + "\n" + password);
		if (usuario.isEmpty()) {
			error = "Faltan datos";
		}
		
		
		
		JOptionPane.showMessageDialog(null, error, "Titulo", 0);
	}
}
