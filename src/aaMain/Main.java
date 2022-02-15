package aaMain;
import java.sql.SQLException;

import javax.swing.UnsupportedLookAndFeelException;

import interfaz.PanelPrincipalLogin;

public class Main {

	public static void main(String[] args) throws SQLException {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            PanelPrincipalLogin miVentana = new PanelPrincipalLogin();
    		miVentana.setVisible(true);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelPrincipalLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		
		//Connection con = ConexionMySQL.conectarMySQL();

		// Query
		/*
		 * sSQL =
		 * "INSERT INTO usuarios (nombre, apellidoUno, apellidoDos, fechaNacimiento, contrasenya, tipoUsuario) VALUES ('edgar', 'dada', 'moreno', '2001-12-16', '123456', 'M');"
		 * ; // PreparedStatement PreparedStatement pstm = con.prepareStatement(sSQL);
		 * pstm.execute(); System.out.print("Insertado en SQL");
		 */
	}
}
