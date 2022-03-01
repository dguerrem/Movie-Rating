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
		mensaje = "<div style='width: 70%;height: 200px;margin:0 auto;background-color: #92e9fb;color:black;font-family: Arial, Helvetica, sans-serif;'>"
				+ "<h1 style='text-align: center;padding-top: 20px;'> Verifica tu Cuenta de Movie Rating</h1>"
				+ "<h4 style='width: 70%; margin:0 auto; text-align: center;padding-left: 30px;padding-right: 30px;'>Bienvenido <u><i>nombreCompleto</i></u>, a continuación puedes visualizar el código de verificación para activar tu cuenta: </h4>"
				+ "<h4 style='background-color:rgba(34, 177, 177, 0.575); width: 70%; margin:20px auto 20px auto; text-align: center;padding:10px 30px 10px 30px;font-style: italic;color:white;letter-spacing: 40px;font-size: 1.5rem;'>XXXXXXX</h4>"
				+ "</div>";
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
			mail.setText(mensaje, "ISO-8859-1", "html");

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