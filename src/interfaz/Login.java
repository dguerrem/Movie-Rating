package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.HintTextFieldUI;
import util.UtilidadesComunes;
import util.MetodosLogin;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.ImageIcon;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsu;
	private JTextField tfPass;
	private JButton btIniciarSesion;
	private JLabel lbRegistrarUsu;
	private JLabel lbFondo;
	private JLabel lbIniciarSesion;
	private static String password = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		initFrame();
		iniciaLabels();
		iniciaTextFields();
		iniciaBotones();
		creaToolTipsText();
	}

	private void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private void iniciaBotones() {
		btIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btIniciarSesion.setBackground(new Color(0, 153, 255));
		btIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btIniciarSesion.setBounds(86, 203, 118, 30);
		btIniciarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodosLogin.puedeIniciarSesion(tfUsu.getText(), password);
				
			}
		});
		contentPane.add(btIniciarSesion);

		lbFondo = new JLabel("New label");
		lbFondo.setIcon(new ImageIcon(Login.class.getResource("/imagenes/fondoVerdeAzul.jpg")));
		lbFondo.setBounds(-128, 0, 1084, 364);
		contentPane.add(lbFondo);
	}

	private void iniciaLabels() {
		lbIniciarSesion = new JLabel("Iniciar Sesi\u00F3n");
		lbIniciarSesion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		lbIniciarSesion.setBounds(220, 21, 202, 50);
		contentPane.add(lbIniciarSesion);

		lbRegistrarUsu = new JLabel("Registrar Usuario");
		lbRegistrarUsu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbRegistrarUsu.setForeground(Color.BLUE);
		lbRegistrarUsu.setBounds(371, 214, 158, 19);
		contentPane.add(lbRegistrarUsu);
	}

	private void iniciaTextFields() {
		tfUsu = new JTextField();
		tfUsu.setBounds(86, 83, 429, 38);
		contentPane.add(tfUsu);
		tfUsu.setColumns(10);
		tfUsu.setUI(new HintTextFieldUI("  Usuario", true));

		tfPass = new JTextField();
		tfPass.setColumns(10);
		tfPass.setBounds(86, 136, 429, 38);
		tfPass.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == 10) { // Al darle a intro se tiene que ejecutar el mismo metodo que al pulsar
											// "Iniciar sesion"
					if (MetodosLogin.puedeIniciarSesion(tfUsu.getText(), password)) {
						// ENTRAR� A LA APLICACI�N
					} else {
						dispose();
					}

				}

				if (e.getKeyCode() != 8) { // esto es para poder borrar para que al detectar el codigo 8 no haga nada
					password += e.getKeyChar() + "";
					tfPass.setText(MetodosLogin.transformPassword(password));
					return;
				}

				password = password.substring(0, password.length() - 1);

			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		contentPane.add(tfPass);
		tfPass.setUI(new HintTextFieldUI("   Contrasenya", true));
	}

	private void creaToolTipsText() {
		tfUsu.setToolTipText(UtilidadesComunes.getConstante("introduzca_usuario"));
		tfPass.setToolTipText("Introduzca la contrasenya");
		lbRegistrarUsu.setToolTipText("Click para registrar un nuevo usuario");
		btIniciarSesion.setToolTipText("Accede con tu usuario");
	}
}
