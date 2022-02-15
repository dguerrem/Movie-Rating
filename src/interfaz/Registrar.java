package interfaz;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import util.UtilidadesComunes;
import java.awt.Font;

public class Registrar extends javax.swing.JPanel {
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton btVolverInicio;
	private javax.swing.JLabel lbUsuario;
	private javax.swing.JLabel lbTituloRegistrar;
	private javax.swing.JLabel lbPassword;
	private javax.swing.JLabel lbConfirmarPassword;
	private javax.swing.JLabel lbCorreo;
	private javax.swing.JLabel lbFechaNacimiento;
	private javax.swing.JLabel lbNombreCompleto;
	private MovieRatingObjects.MovieRatingBoton btRegistrar;
	private MovieRatingObjects.MovieRatingPasswordField tfPassword;
	private MovieRatingObjects.MovieRatingPasswordField tfConfirmarPassword;
	private MovieRatingObjects.MovieRatingTextField tfUsuario;
	private MovieRatingObjects.MovieRatingTextField tfCorreo;
	private MovieRatingObjects.MovieRatingTextField tfFechaNacimiento;
	private MovieRatingObjects.MovieRatingTextField tfNombreCompleto;

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
		tfUsuario.setPrefixIcon(new ImageIcon("src/iconos/usuario.png"));

		tfPassword = new MovieRatingObjects.MovieRatingPasswordField();
		tfPassword.setPrefixIcon(new ImageIcon("src/iconos/password.png"));

		tfConfirmarPassword = new MovieRatingObjects.MovieRatingPasswordField();
		tfConfirmarPassword.setPrefixIcon(new ImageIcon("src/iconos/password.png"));

		tfCorreo = new MovieRatingObjects.MovieRatingTextField();
		tfCorreo.setPrefixIcon(new ImageIcon("src/iconos/mail.png"));

		tfFechaNacimiento = new MovieRatingObjects.MovieRatingTextField();
		tfFechaNacimiento.setPrefixIcon(new ImageIcon("src/iconos/calendar.png"));
		
		tfNombreCompleto = new MovieRatingObjects.MovieRatingTextField();
		tfNombreCompleto.setPrefixIcon(new ImageIcon("src/iconos/nombre.png"));
	}

	private void iniciaBotones() {
		btRegistrar = new MovieRatingObjects.MovieRatingBoton();
		btRegistrar.setBackground(new java.awt.Color(125, 229, 251));
		btRegistrar.setForeground(new java.awt.Color(40, 40, 40));
		btRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		btVolverInicio = new javax.swing.JButton();
		btVolverInicio.setFont(new java.awt.Font("sansserif", 1, 12));
		btVolverInicio.setForeground(new java.awt.Color(30, 122, 236));
		btVolverInicio.setContentAreaFilled(false);
		btVolverInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	}

	private void iniciaLabels() {
		lbUsuario = new javax.swing.JLabel();
		lbPassword = new javax.swing.JLabel();
		lbConfirmarPassword = new javax.swing.JLabel();
		lbCorreo = new javax.swing.JLabel();
		lbFechaNacimiento = new javax.swing.JLabel();
		lbNombreCompleto = new javax.swing.JLabel();

		lbTituloRegistrar = new javax.swing.JLabel();
		lbTituloRegistrar.setFont(new Font("SansSerif", Font.BOLD, 40));
		lbTituloRegistrar.setForeground(new java.awt.Color(69, 68, 68));
		lbTituloRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	}

	private void configuraVentana() {
		setBackground(new java.awt.Color(255, 255, 255));
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap(50, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(lbNombreCompleto).addComponent(lbFechaNacimiento).addComponent(lbCorreo).addComponent(lbPassword)
						.addComponent(lbUsuario).addComponent(lbConfirmarPassword)
						.addComponent(tfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lbTituloRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
						.addComponent(tfPassword, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btVolverInicio, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tfConfirmarPassword, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tfCorreo, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tfFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tfNombreCompleto, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						)
				.addContainerGap(50, Short.MAX_VALUE)));
		
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap(50, Short.MAX_VALUE)
						.addComponent(lbTituloRegistrar).addGap(8, 8, 8)
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
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)					
						.addComponent(lbFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(tfFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lbNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(tfNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
						.addComponent(btVolverInicio).addGap(30, 30, 30)));
	}

	private void estableceTextos() {
		lbTituloRegistrar.setText(UtilidadesComunes.getConstante("registro"));
		lbUsuario.setText(UtilidadesComunes.getConstante("usuario"));
		lbPassword.setText(UtilidadesComunes.getConstante("contrasenya"));
		lbConfirmarPassword.setText(UtilidadesComunes.getConstante("confirmar_contrasenya"));
		lbCorreo.setText(UtilidadesComunes.getConstante("correo"));
		lbFechaNacimiento.setText(UtilidadesComunes.getConstante("fecha_nacimiento"));
		lbNombreCompleto.setText(UtilidadesComunes.getConstante("nombre_completo"));
		btRegistrar.setText(UtilidadesComunes.getConstante("registrar"));
		btVolverInicio.setText(UtilidadesComunes.getConstante("volver_login"));
	}

	public void addEventBackLogin(ActionListener event) {
		btVolverInicio.addActionListener(event);
	}

	public void estableceFoco() {
		tfUsuario.grabFocus();
	}
}
