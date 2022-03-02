package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import conexiones.ConexionMySQL;
import objetos.Usuario;

public class MetodosAccesoBD {
	private static Connection conexion;
	private static String query = "";
	private static Statement s;
	private static ResultSet rs;

	public static void insertUsuario(Usuario usu) throws SQLException {
		conexion = ConexionMySQL.conectarMySQL();
		query = "INSERT INTO usuarios (nick, nombreCompleto, fechaNacimiento, contrasenya, codVerificacion, tipoUsuario, correo) "
				+ "VALUES ('" + usu.getNick() + "', '" + usu.getNombreCompleto() + "', '" + usu.getFechaNacimiento()
				+ "', '" + usu.getPassword() + "', '" + usu.getCodVerificacion() + "', '" + usu.getTipo() + "', '"
				+ usu.getCorreo() + "')";

		PreparedStatement pstm = conexion.prepareStatement(query);
		pstm.execute();

		//Pendiente cambiar el texto este de aqu� por texto en variables para el multiidoma
		JOptionPane.showMessageDialog(null, "Revise su correo", "Usuario creado correctamente", 0,
				new ImageIcon("src/iconos/mensaje.png"));
		conexion.close();
	}

	public static String selectUsuario(String nick) throws SQLException {
		conexion = ConexionMySQL.conectarMySQL();
		query = "SELECT contrasenya FROM usuarios WHERE nick =" + "'" + nick + "';";
		s = conexion.createStatement();
		rs = s.executeQuery(query);
		rs.next();
		conexion.close();
		return rs.getString(1);
	}

	public static boolean sePuedeCrear(String nombreUsuario) throws SQLException {
		conexion = ConexionMySQL.conectarMySQL();
		query = "SELECT COUNT(nick) FROM usuarios WHERE nick =" + "'" + nombreUsuario + "';";
		s = conexion.createStatement();
		rs = s.executeQuery(query);
		rs.next();
		int num = rs.getInt(1);
		conexion.close();

		if (num == 0) {
			return true;
		}
		return false;
	}
}
