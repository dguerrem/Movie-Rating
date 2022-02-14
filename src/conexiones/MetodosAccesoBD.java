package conexiones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import objetos.Usuario;

public class MetodosAccesoBD {
	private static Connection con;
	private static ArrayList<Usuario> usuarios;
	private static Statement stmt;
	private static String query = "";
	private static ResultSet rs;
	private static Usuario usu;

	public static void CreaArrayListClientes() {
		usuarios = new ArrayList<>();
		con = ConexionMySQL.conectarMySQL();

		try {
			stmt = con.createStatement();
			query = "select * from usuarios";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				usu = new Usuario();
				usu.setNombre(rs.getString(2));
				usu.setApellido1(rs.getString(3));
				usu.setApellido2(rs.getString(4));
				usuarios.add(usu);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getUsuarioCompleto());
		}
	}
}
