package interfaz;

import java.awt.event.ActionListener;

public class Registrar extends javax.swing.JPanel {
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton btVolverInicio;
	private javax.swing.JLabel lbUsuario;
	private javax.swing.JLabel lbTituloRegistrar;
	private javax.swing.JLabel lbPassword;
	private javax.swing.JLabel lbConfirmarPassword;
	private javax.swing.JLabel lbCorreo;
	private MovieRatingObjects.MovieRatingBoton btRegistrar;
	private MovieRatingObjects.MovieRatingPasswordField tfPassword;
	private MovieRatingObjects.MovieRatingPasswordField tfConfirmarPassword;
	private MovieRatingObjects.MovieRatingTextField tfUsuario;
	private MovieRatingObjects.MovieRatingTextField tfCorreo;

	public Registrar() {
		iniciaTextFields();
		iniciaLabels();
		iniciaBotones();
		configuraVentana();
		estableceFoco();
		estableceTextos();
	}

	private void iniciaTextFields() {
		tfUsuario = new MovieRatingObjects.MovieRatingTextField();
		tfPassword = new MovieRatingObjects.MovieRatingPasswordField();
		tfConfirmarPassword = new MovieRatingObjects.MovieRatingPasswordField();
		tfCorreo = new MovieRatingObjects.MovieRatingTextField();
	}

	private void iniciaBotones() {
		btRegistrar = new MovieRatingObjects.MovieRatingBoton();
		btRegistrar.setBackground(new java.awt.Color(125, 229, 251));
		btRegistrar.setForeground(new java.awt.Color(40, 40, 40));

		btVolverInicio = new javax.swing.JButton();
		btVolverInicio.setFont(new java.awt.Font("sansserif", 1, 12));
		btVolverInicio.setForeground(new java.awt.Color(30, 122, 236));
		btVolverInicio.setContentAreaFilled(false);
		btVolverInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	}

	private void iniciaLabels() {
		lbUsuario = new javax.swing.JLabel();
		lbTituloRegistrar = new javax.swing.JLabel();
		lbTituloRegistrar.setFont(new java.awt.Font("sansserif", 1, 48));
		lbTituloRegistrar.setForeground(new java.awt.Color(69, 68, 68));
		lbTituloRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		lbPassword = new javax.swing.JLabel();
		lbConfirmarPassword = new javax.swing.JLabel();
		lbCorreo = new javax.swing.JLabel();
	}

	private void configuraVentana() {
		setBackground(new java.awt.Color(255, 255, 255));
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap(50, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(lbCorreo).addComponent(lbPassword).addComponent(lbUsuario)
						.addComponent(tfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lbTituloRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
						.addComponent(tfPassword, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btVolverInicio, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lbConfirmarPassword)
						.addComponent(tfConfirmarPassword, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tfCorreo, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap(50, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap(50, Short.MAX_VALUE)
						.addComponent(lbTituloRegistrar).addGap(18, 18, 18)
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
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lbConfirmarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(tfConfirmarPassword, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lbCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(30, 30, 30)
						.addComponent(btRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
						.addComponent(btVolverInicio).addGap(30, 30, 30)));
	}

	private void estableceTextos() {
		lbUsuario.setText("User Name");
		lbTituloRegistrar.setText("Register");
		lbPassword.setText("Password");
		btRegistrar.setText("Register");
		lbConfirmarPassword.setText("Confirm Password");
		btVolverInicio.setText("Back to Login");
		lbCorreo.setText("Email");
	}

	public void addEventBackLogin(ActionListener event) {
		btVolverInicio.addActionListener(event);
	}

	public void estableceFoco() {
		tfUsuario.grabFocus();
	}
}
