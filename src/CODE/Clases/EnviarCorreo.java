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

    public EnviarCorreo(String correoEnviar, String asunto, String mensaje) {
        createEmail(correoEnviar, asunto, mensaje);
        sendEmail(correoEnviar);
    }

    private void createEmail(String correoEnviar, String asunto, String mensaje) {
        mProperties = new Properties();
        emailTo = correoEnviar;
        subject = asunto;
        content = mensaje;

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

    private void sendEmail(String emailTo) {
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
