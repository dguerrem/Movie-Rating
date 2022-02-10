package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import util.HintTextFieldUI;
import util.MetodosLogin;
import util.RoundedBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Login extends JFrame {

	private JPanel contentPane;
	private static JTextField tfUsu;
	private JTextField tfPass;
	private JLabel lblNewLabel;
	private static String contraseña="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					tfUsu.transferFocusUpCycle();
					
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbIniciarSesion = new JLabel("Iniciar Sesi\u00F3n");
		lbIniciarSesion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		lbIniciarSesion.setBounds(220, 21, 202, 50);
		contentPane.add(lbIniciarSesion);
		
		
		tfUsu = new JTextField();
		tfUsu.setToolTipText("Introduza el usuario");
		tfUsu.setBounds(86, 83, 429, 38);
		contentPane.add(tfUsu);
		tfUsu.setColumns(10);
		tfUsu.setUI(new HintTextFieldUI("Usuario", true));
		
		tfPass = new JTextField();
		tfPass.setToolTipText("Introduzca la contrase\u00F1a");
		tfPass.setColumns(10);
		tfPass.setBounds(86, 136, 429, 38);
		tfPass.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode()!=8) { //esto es para poder borrar para que al detectar el codigo 8 no haga nada
					contraseña += e.getKeyChar()+"";
					tfPass.setText(MetodosLogin.transformarContraseña(contraseña));
				}
			
				
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			
				
			}
		});
		contentPane.add(tfPass);
		tfPass.setUI(new HintTextFieldUI("Password", true));
		
		JButton btnNewButton = new JButton("Iniciar Sesi\u00F3n");
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(86, 203, 118, 30);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Registrar Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(100, 149, 237));
		lblNewLabel.setBounds(371, 214, 158, 19);
		contentPane.add(lblNewLabel);
		
		
	}
}
