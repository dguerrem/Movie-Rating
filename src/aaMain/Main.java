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
            System.err.print(ex);
        }
	}
}
