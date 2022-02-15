package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import objetos.Usuario;
import util.UtilidadesComunes;

public class Login extends javax.swing.JPanel {
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton btRegistrar;
	private javax.swing.JLabel lbUsuario;
	private javax.swing.JLabel lbTituloLogin;
	private javax.swing.JLabel lbPassword;
	private MovieRatingObjects.MovieRatingBoton btIniciarSesion;
	private MovieRatingObjects.MovieRatingPasswordField tfPassword;
	private MovieRatingObjects.MovieRatingTextField tfUsuario;
	private Usuario nuevoUsuario;

	public Login() {
		iniciaTextFields();
		iniciaLabels();
		iniciaBotones();
		configuraVentana();
		estableceFoco();
		estableceTextos();
	}

	private void estableceTextos() {
		lbUsuario.setText(UtilidadesComunes.getConstante("usuario"));
		lbTituloLogin.setText(UtilidadesComunes.getConstante("iniciar_sesion"));
		lbPassword.setText(UtilidadesComunes.getConstante("contrasenya"));
		btIniciarSesion.setText(UtilidadesComunes.getConstante("iniciar_sesion"));
		btRegistrar.setText(UtilidadesComunes.getConstante("registrar_usuario"));
	}

	private void iniciaBotones() {
		btIniciarSesion = new MovieRatingObjects.MovieRatingBoton();
		btIniciarSesion.setBackground(new java.awt.Color(125, 229, 251));
		btIniciarSesion.setForeground(new java.awt.Color(40, 40, 40));
		btIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btIniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Iniciara Sesion
			}
		});

		btRegistrar = new javax.swing.JButton();
		btRegistrar.setFont(new java.awt.Font("sansserif", 1, 12));
		btRegistrar.setForeground(new java.awt.Color(30, 122, 236));
		btRegistrar.setContentAreaFilled(false);
		btRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	}

	private void iniciaLabels() {
		lbUsuario = new javax.swing.JLabel();
		lbPassword = new javax.swing.JLabel();

		lbTituloLogin = new javax.swing.JLabel();
		lbTituloLogin.setFont(new java.awt.Font("sansserif", 1, 48));
		lbTituloLogin.setForeground(new java.awt.Color(69, 68, 68));
		lbTituloLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	}

	private void iniciaTextFields() {
		tfUsuario = new MovieRatingObjects.MovieRatingTextField();
		tfUsuario.setPrefixIcon(new ImageIcon("src/iconos/usuario.png"));
		
		tfPassword = new MovieRatingObjects.MovieRatingPasswordField();
		tfPassword.setPrefixIcon(new ImageIcon("src/iconos/password.png"));
	}

	private void estableceFoco() {
		tfUsuario.grabFocus();
	}

	public void cambiaPanelRegistro(ActionListener event) {
		btRegistrar.addActionListener(event);
	}

	private void configuraVentana() {
		setBackground(new java.awt.Color(255, 255, 255));
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap(50, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(lbPassword).addComponent(lbUsuario)
								.addComponent(tfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lbTituloLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
								.addComponent(tfPassword, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(50, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap(50, Short.MAX_VALUE)
						.addComponent(lbTituloLogin).addGap(18, 18, 18)
						.addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(30, 30, 30)
						.addComponent(btIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
						.addComponent(btRegistrar).addGap(30, 30, 30)));
	}
	

}
