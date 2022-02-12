package util;


import javax.swing.JOptionPane;


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
		
		if (usuario.isEmpty() || password.isEmpty()) {
			error = "Faltan datos";
		}
		//Hay que mirar que condiciones ponemos para que se puedan logear ej(contraseña inferior a 8 caracteres ...)
		
		
		//Hay que hacer un select a la BBDD y comprobar que el nombre de usuario este si esta hay que comparar si la contraseña es igual
		
		JOptionPane.showMessageDialog(null, error, "Titulo", 0);
	}
	
	
	
	
}
