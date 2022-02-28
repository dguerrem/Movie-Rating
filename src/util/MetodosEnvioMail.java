package util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class MetodosEnvioMail {
	Properties propiedades;
	Session sesion;
	String remitente, contrasena, destinatario, asunto, mensaje;
	MimeMessage mail;
	Transport transporte;

	public void enviarConGMail() {
		creaPropiedades();
		creaSesion();
		enviaMensaje();
	}

	private void creaPropiedades() {
		sesion = Session.getDefaultInstance(propiedades);
		remitente = "movierating3@gmail.com";
		contrasena = "Sox@1234";
		destinatario = "dacormo01@hotmail.com";
		asunto = "Asunto mensaje";
		mensaje = "Mensaje";
	}

	private void creaSesion() {
		propiedades = new Properties();
		propiedades.put("mail.smtp.auth", true);
		propiedades.put("mail.smtp.starttls.enable", true);
		propiedades.put("mail.smtp.host", "smtp.gmail.com");
		propiedades.put("mail.smtp.port", "587");
	}

	private void enviaMensaje() {
		mail = new MimeMessage(sesion);
		try {
			mail.setFrom(new InternetAddress(remitente));
			mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			mail.setSubject(asunto);
			mail.setText(mensaje);

			transporte = sesion.getTransport("smtp");
			transporte.connect(remitente, contrasena);
			transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
			transporte.close();

			JOptionPane.showMessageDialog(null, "Correo enviado");
		} catch (MessagingException ex) {
			System.err.print(ex);
		}
	}
}