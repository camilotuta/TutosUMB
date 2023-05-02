/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CODE.Clases;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class EnviarCorreo {
    public EnviarCorreo(String mensajeCodigo) {

        // Configuración de las propiedades del correo
        Properties propiedades = new Properties();
        propiedades.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedades.setProperty("mail.smtp.starttls.enable", "true");
        propiedades.setProperty("mail.smtp.auth", "true");
        propiedades.setProperty("mail.smtp.port", "587");

        // Creación de la sesión de correo
        Session sesion = Session.getDefaultInstance(propiedades);

        final String username = "codigodeverificaciontutosumb@gmail.com"; // Remitente
        final String password = "TutosbProyecto1234";
        final String destino = "cauntertut2004@gmail.com"; // Destinatario

        String asunto = "CÓDIGO DE CONFIRMACIÓN.";
        String mensaje = mensajeCodigo;

        Message mail = new MimeMessage(sesion);

        try {
            // Creación del mail
            mail.setFrom(new InternetAddress(username));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            mail.setSubject(asunto);
            mail.setText(mensaje);

            Transport transporte = sesion.getTransport("smtp");
            // Envío del correo
            transporte.connect(username, password);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();

            System.out.println("El correo ha sido enviado correctamente.");
        } catch (MessagingException e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new EnviarCorreo("Hola");
    }
}