package conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import objetos.Usuario;

public class MetodosAccesoBD {
	private static Connection conexion;
	private static String query = "";

	public static void insertUsuario(Usuario usu) throws SQLException {
		conexion = ConexionMySQL.conectarMySQL();
		query = "INSERT INTO usuarios (nick, nombreCompleto, fechaNacimiento, contrasenya, codVerificacion, tipoUsuario) "
				+ "VALUES (' " + usu.getNick() + "', '" + usu.getNombreCompleto() + "', '" + usu.getFechaNacimiento()
				+ "', '" + usu.getPassword() + "', '" + usu.getCodVerificacion() + "', '" + usu.getTipo() + "');";

		PreparedStatement pstm = conexion.prepareStatement(query);
		pstm.execute();

		System.out.print("Insertado en SQL");
		JOptionPane.showMessageDialog(null, "Revise su correo", "Usuario creado correctamente", 0,
				new ImageIcon("src/iconos/mensaje.png"));
	}
}
