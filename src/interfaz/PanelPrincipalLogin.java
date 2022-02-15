package interfaz;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrincipalLogin extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private MovieRatingObjects.MovieRatingBorderPanel paPrincipalBordeado;
	private MovieRatingObjects.MovieRatingGradientPanel paPrincipal;
	private MovieRatingObjects.MovieRatingSlidePanel slDeslizador;
	private Login login;
	private Registrar registro;

	public PanelPrincipalLogin() {
		configuraVentana();
		configuraAnimacionDeslizar();
	}

	private void configuraVentana() {
		paPrincipal = new MovieRatingObjects.MovieRatingGradientPanel();
		paPrincipalBordeado = new MovieRatingObjects.MovieRatingBorderPanel();
		slDeslizador = new MovieRatingObjects.MovieRatingSlidePanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		paPrincipal.setColorPrimario(new java.awt.Color(146, 233, 251));
		paPrincipal.setColorSecundario(new java.awt.Color(12, 137, 163));

		paPrincipalBordeado.setBackground(new java.awt.Color(255, 255, 255));

		slDeslizador.setBackground(new java.awt.Color(255, 255, 255));

		javax.swing.GroupLayout gl_slDeslizador = new javax.swing.GroupLayout(slDeslizador);
		slDeslizador.setLayout(gl_slDeslizador);
		gl_slDeslizador.setHorizontalGroup(gl_slDeslizador
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 373, Short.MAX_VALUE));
		gl_slDeslizador.setVerticalGroup(gl_slDeslizador.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 508, Short.MAX_VALUE));

		paPrincipalBordeado.setLayer(slDeslizador, javax.swing.JLayeredPane.DEFAULT_LAYER);

		javax.swing.GroupLayout gl_paPrincipalBordeado = new javax.swing.GroupLayout(paPrincipalBordeado);
		paPrincipalBordeado.setLayout(gl_paPrincipalBordeado);
		gl_paPrincipalBordeado.setHorizontalGroup(gl_paPrincipalBordeado
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_paPrincipalBordeado.createSequentialGroup().addContainerGap().addComponent(slDeslizador,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		gl_paPrincipalBordeado.setVerticalGroup(gl_paPrincipalBordeado
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_paPrincipalBordeado.createSequentialGroup().addContainerGap().addComponent(slDeslizador,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		paPrincipal.setLayer(paPrincipalBordeado, javax.swing.JLayeredPane.DEFAULT_LAYER);

		javax.swing.GroupLayout gl_paPrincipal = new javax.swing.GroupLayout(paPrincipal);
		paPrincipal.setLayout(gl_paPrincipal);
		gl_paPrincipal.setHorizontalGroup(gl_paPrincipal.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						gl_paPrincipal.createSequentialGroup().addContainerGap(100, Short.MAX_VALUE)
								.addComponent(paPrincipalBordeado, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(100, Short.MAX_VALUE)));
		gl_paPrincipal.setVerticalGroup(gl_paPrincipal.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						gl_paPrincipal.createSequentialGroup().addContainerGap(100, Short.MAX_VALUE)
								.addComponent(paPrincipalBordeado, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(100, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(paPrincipal,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(paPrincipal,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setLocationRelativeTo(this);
		setTitle("Movie Rating");
		Image icono = Toolkit.getDefaultToolkit().getImage("src\\imagenes\\logo.png");
		setIconImage(icono);
	}

	private void configuraAnimacionDeslizar() {
		login = new Login();
		registro = new Registrar();

		slDeslizador.setAnimate(5);
		slDeslizador.init(login, registro);

		login.cambiaPanelRegistro(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				slDeslizador.show(1);
				registro.estableceFoco();
			}
		});

		registro.addEventBackLogin(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				slDeslizador.show(0);
			}
		});
	}
}
