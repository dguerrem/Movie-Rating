package conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import objetos.Usuario;

public class MetodosAccesoBD {
	private static Connection conexion;
	private static String query = "";

	public static void insertUsuario(Usuario usu) throws SQLException {
		conexion = ConexionMySQL.conectarMySQL();
		query = "INSERT INTO usuarios (nick, nombreCompleto, fechaNacimiento, contrasenya, codVerificacion, tipoUsuario) "
				+ "VALUES ('" + usu.getNick() + "', '" + usu.getNombreCompleto() + "', '" + usu.getFechaNacimiento()
				+ "', '" + usu.getPassword() + "', '" + usu.getCodVerificacion() + "', '" + usu.getTipo() + "');";

		PreparedStatement pstm = conexion.prepareStatement(query);
		pstm.execute();

		System.out.print("Insertado en SQL");
		JOptionPane.showMessageDialog(null, "Revise su correo", "Usuario creado correctamente", 0,
				new ImageIcon("src/iconos/mensaje.png"));
	}

	public static String selectUsuario(String nick) throws SQLException {
		conexion = ConexionMySQL.conectarMySQL();
		query = "Select contrasenya from usuarios where nick =" + "'" + nick + "';";
		Statement s = conexion.createStatement();
		ResultSet rs = s.executeQuery(query);
		rs.next();
		return rs.getString(1);
	}

	public static boolean sePuedeCrear(String nombreUsuario) throws SQLException {
		conexion = ConexionMySQL.conectarMySQL();
		query = "select count(nick) from usuarios where nick =" + "'" + nombreUsuario + "';";
		Statement s = conexion.createStatement();
		ResultSet rs = s.executeQuery(query);
		rs.next();
		int num = rs.getInt(1);

		if (num == 0) {
			return true;
		}
		return false;
	}
}
