package util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSenderService {

	public void enviarConGMail(String destinatario, String asunto, String cuerpo) {

		final String username = "movierating3@gmail.com";
		final String password = "Sox@1234";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setSubject("asunto");
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("dacormus@gmail.com"));
			message.setText("gracias Chuidiang");
			// Envia el mensaje
			Transport.send(message);
		} catch (Exception e) {
			System.err.print(e);
		}
	}

}