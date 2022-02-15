package interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.UtilidadesComunes;
import util.MetodosLogin;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import MovieRatingObjects.MovieRatingClickableLabel;
import MovieRatingObjects.MovieRatingHintTextField;

public class Login_Antiguo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsu;
	private JTextField tfPass;
	private JButton btIniciarSesion;
	private JLabel lbRegistrarUsu;
	private JLabel lbFondo;
	private JLabel lbIniciarSesion;
	private static String password = "";
	private JLabel lbIconUser;
	private JLabel lbIconPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Antiguo frame = new Login_Antiguo();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login_Antiguo() {
		initFrame();
		iniciaLabels();
		iniciaTextFields();
		iniciaBotones();
		estableceTextos();
		creaToolTipsText();
		creaIcono();
	}

	private void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 403);
		setTitle("Movie Rating");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private void iniciaBotones() {
		btIniciarSesion = new JButton();
		btIniciarSesion.setBackground(new Color(0, 153, 255));
		btIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btIniciarSesion.setBounds(120, 202, 118, 30);
		btIniciarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MetodosLogin.puedeIniciarSesion(tfUsu.getText(), password);

			}
		});
		contentPane.add(btIniciarSesion);

		lbFondo = new JLabel();
		lbFondo.setIcon(new ImageIcon(Login_Antiguo.class.getResource("/imagenes/fondoVerdeAzul.jpg")));
		lbFondo.setBounds(-166, -132, 1084, 496);
		contentPane.add(lbFondo);
	}

	private void iniciaLabels() {
		
		lbIconPassword = new JLabel("New label");
		lbIconPassword.setIcon(new ImageIcon(Login_Antiguo.class.getResource("/imagenes/pass_icon.png")));
		lbIconPassword.setBackground(Color.RED);
		lbIconPassword.setBounds(62, 135, 40, 45);
		contentPane.add(lbIconPassword);
		
		lbIconUser = new JLabel("New label");
		lbIconUser.setBackground(Color.RED);
		lbIconUser.setIcon(new ImageIcon(Login_Antiguo.class.getResource("/imagenes/user_icon.png")));
		lbIconUser.setBounds(507, 86, 34, 30);
		contentPane.add(lbIconUser);
		lbIniciarSesion = new JLabel();
		lbIniciarSesion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		lbIniciarSesion.setBounds(254, 21, 295, 50);
		contentPane.add(lbIniciarSesion);

		lbRegistrarUsu = new MovieRatingClickableLabel();
		lbRegistrarUsu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbRegistrarUsu.setForeground(Color.BLUE);
		lbRegistrarUsu.setBounds(371, 214, 158, 19);
		contentPane.add(lbRegistrarUsu);
	}

	private void iniciaTextFields() {
		tfUsu = new JTextField();
		tfUsu.setBounds(120, 82, 429, 38);
		contentPane.add(tfUsu);
		tfUsu.setColumns(10);
		tfUsu.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		tfUsu.setUI(new MovieRatingHintTextField(UtilidadesComunes.getConstante("usuario"), true));
		

		tfPass = new JTextField();
		tfPass.setColumns(10);
		tfPass.setBounds(120, 135, 429, 38);
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
		tfPass.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		tfPass.setUI(new MovieRatingHintTextField(UtilidadesComunes.getConstante("contrasenya"), true));
	}

	private void creaToolTipsText() {
		tfUsu.setToolTipText(UtilidadesComunes.getConstante("introduzca_usuario"));
		tfPass.setToolTipText(UtilidadesComunes.getConstante("introduzca_contrasenya"));
		lbRegistrarUsu.setToolTipText(UtilidadesComunes.getConstante("click_registrar_nuevo_usuario"));
		btIniciarSesion.setToolTipText(UtilidadesComunes.getConstante("accede_con_usuario"));
	}

	private void estableceTextos() {
		btIniciarSesion.setText(UtilidadesComunes.getConstante("iniciar_sesion"));
		lbIniciarSesion.setText(UtilidadesComunes.getConstante("iniciar_sesion"));
		lbRegistrarUsu.setText(UtilidadesComunes.getConstante("registrar_usuario"));
	}
	
	private void creaIcono() {
		Image icono = Toolkit.getDefaultToolkit().getImage("src\\imagenes\\logo.png");  
		setIconImage(icono);
	}
}
