package CODE.Clases;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

public class EnviarCorreo {

    private static String emailFrom = "codigodeverificaciontutosumb@gmail.com";
    private static String passwordFrom = "dzfmmxpxosqjvsyx";
    private String emailTo;
    private String subject;
    private String content;

    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;

    public EnviarCorreo(String nombre, String emailTo, String content) {
        createEmail(nombre, emailTo, content);
        sendEmail(emailTo, content);

    }

    private void createEmail(String nombre, String correoEnviar, String msgCodigo) {
        mProperties = new Properties();
        emailTo = correoEnviar;
        subject = "Restablecer tu contraseña en TutosUMB.";
        content = "&#x1F44B; Hola, " + nombre + ".<br><br>" +
                "Has recibido este correo electrónico porque has solicitado restablecer tu contraseña en TutosUMB. Para continuar, utiliza el siguiente código de verificación:<br><br>"
                +
                "&#128273; <strong style=\"font-size: 24px;\">" + msgCodigo + "</strong><br><br>" +
                "Por favor, ingresa este código en la página de restablecimiento de contraseña y sigue las instrucciones para crear una nueva contraseña segura.<br><br>"
                +
                "Si no has solicitado el restablecimiento de tu contraseña, por favor ignora este correo electrónico y asegúrate de proteger tu cuenta.<br><br>"
                +
                "Si tienes alguna pregunta o necesitas ayuda, no dudes en contactar a nuestro equipo de soporte. &#128516;<br><br>"
                +
                "¡Que tengas un excelente día! &#128077;<br><br>" +
                "Atentamente,<br>" +
                "El equipo de TutosUMB. &#128170;";
        ;

        // Simple mail transfer protocol
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProperties);

        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setText(content, "ISO-8859-1", "html");

        } catch (AddressException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendEmail(String emailTo, String content) {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();

            JOptionPane.showMessageDialog(null, "EL CÓDIGO HA SIDO ENVIADO A " + emailTo);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
