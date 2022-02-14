import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexiones.ConexionMySQL;
import interfaz.Login;

public class Init {
	private static String sSQL = "";

	public static void main(String[] args) throws SQLException {
		 //Login miVentana = new Login();
		 //miVentana.setVisible(true);

		Connection con = ConexionMySQL.conectarMySQL();

		// Query
		sSQL = "INSERT INTO usuarios (nombre, apellidoUno, apellidoDos, fechaNacimiento, contrasenya, tipoUsuario) VALUES ('edgar', 'dada', 'moreno', '2001-12-16', '123456', 'M');";
		// PreparedStatement
		PreparedStatement pstm = con.prepareStatement(sSQL);
		pstm.execute();
		System.out.print("Insertado en SQL");
	}
}
