package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

	private static String controlador = "com.mysql.cj.jdbc.Driver";
	private static String nombreBD = "movierating";
	private static String direccion = "movieratingdev.cg9fgdqtuzqa.us-east-1.rds.amazonaws.com";
	private static String puerto = "3306";
	private static String url = "jdbc:mysql://" + direccion + ":" + puerto + "/" + nombreBD;
	private static String usuario = "admin";
	private static String password = "Sox_1234";
	private static Connection conexion = null;

	public static Connection conectarMySQL() {
		try {
			Class.forName(controlador);
			conexion = DriverManager.getConnection(url, usuario, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}

}