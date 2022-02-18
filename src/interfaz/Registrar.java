package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import util.MetodosRegistroUsuario;
import util.UtilidadesComunes;
import java.awt.Color;
import java.awt.Font;

public class Registrar extends javax.swing.JPanel {
	private static final long serialVersionUID = 1L;
	private static javax.swing.JButton btVolverInicio;
	private static javax.swing.JLabel lbUsuario;
	private static javax.swing.JLabel lbTituloRegistrar;
	private static javax.swing.JLabel lbPassword;
	private static javax.swing.JLabel lbConfirmarPassword;
	private static javax.swing.JLabel lbCorreo;
	private static javax.swing.JLabel lbFechaNacimiento;
	private static javax.swing.JLabel lbNombreCompleto;
	private static MovieRatingObjects.MovieRatingBoton btRegistrar;
	private static MovieRatingObjects.MovieRatingPasswordField tfPassword;
	private static MovieRatingObjects.MovieRatingPasswordField tfConfirmarPassword;
	private static MovieRatingObjects.MovieRatingTextField tfUsuario;
	private static MovieRatingObjects.MovieRatingTextField tfCorreo;
	private static MovieRatingObjects.MovieRatingTextField tfFechaNacimiento;
	private static MovieRatingObjects.MovieRatingTextField tfNombreCompleto;

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
		btRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetFormato();
				cargaUsuario();
			}
		});

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
						.addComponent(lbNombreCompleto).addComponent(lbFechaNacimiento).addComponent(lbCorreo)
						.addComponent(lbPassword).addComponent(lbUsuario).addComponent(lbConfirmarPassword)
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
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

	private void cargaUsuario() {
		MetodosRegistroUsuario.comprobarCampos(tfUsuario.getText(), tfNombreCompleto.getText(),
				tfFechaNacimiento.getText(), tfCorreo.getText(), tfPassword.getPassword(), tfConfirmarPassword.getPassword());
	}

	public static void cambiaFormato(int numero) {
		switch (numero) {
		case 1: {
			lbUsuario.setForeground(Color.red);
			tfUsuario.formatoErroneo(tfUsuario.getGraphics());
			break;
		}
		case 2: {
			lbPassword.setForeground(Color.red);
			tfPassword.formatoErroneo(tfPassword.getGraphics());
			break;
		}
		case 3: {
			lbConfirmarPassword.setForeground(Color.red);
			tfConfirmarPassword.formatoErroneo(tfConfirmarPassword.getGraphics());
			break;
		}
		case 4: {
			lbCorreo.setForeground(Color.red);
			tfCorreo.formatoErroneo(tfCorreo.getGraphics());
			break;
		}
		case 5: {
			lbFechaNacimiento.setForeground(Color.red);
			tfFechaNacimiento.formatoErroneo(tfFechaNacimiento.getGraphics());
			break;
		}
		case 6: {
			lbNombreCompleto.setForeground(Color.red);
			tfNombreCompleto.formatoErroneo(tfNombreCompleto.getGraphics());
			break;
		}
		case 7: {
			lbUsuario.setForeground(Color.red);
			lbUsuario.setText(UtilidadesComunes.getConstante("usuario_creado"));
			tfUsuario.setText("");
			tfUsuario.grabFocus();
			tfUsuario.formatoErroneo(tfUsuario.getGraphics());
			break;
		}
		}
	}

	private void resetFormato() {
		lbUsuario.setForeground(Color.black);
		lbPassword.setForeground(Color.black);
		lbConfirmarPassword.setForeground(Color.black);
		lbCorreo.setForeground(Color.black);
		lbFechaNacimiento.setForeground(Color.black);
		lbNombreCompleto.setForeground(Color.black);
	}
}
