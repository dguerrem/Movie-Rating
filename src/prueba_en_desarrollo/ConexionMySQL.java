package prueba_en_desarrollo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

	// Librería de MySQL
	public static String driver = "com.mysql.jdbc.Driver";

	// Nombre de la base de datos
	public static String database = "movierating";

	// Host
	public static String hostname = "movieratingdev.cg9fgdqtuzqa.us-east-1.rds.amazonaws.com";

	// Puerto
	public static String port = "3306";

	// Ruta de nuestra base de datos (desactivamos el uso de SSL con
	// "?useSSL=false")
	public static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

	// Nombre de usuario
	public static String username = "admin";

	// Clave de usuario
	public static String password = "Sox_1234";

	public static Connection conectarMySQL() {
		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

}