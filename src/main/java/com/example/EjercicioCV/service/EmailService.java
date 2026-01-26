package com.example.EjercicioCV.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service // Indica que esta clase es un servicio de Spring Boot
public class EmailService {
    private final JavaMailSender mailSender;
    // Inyección de dependencias por constructor
    public EmailService(final JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    public void enviarCorreo(String destinatario, String asunto, String
            cuerpo) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(destinatario); // Configura el destinatario delcorreo
        mensaje.setSubject(asunto); // Configura el asunto del correo
        mensaje.setText(cuerpo); // Configura el contenido del mensaje
        mensaje.setFrom("email@gmail.com"); // Define quién envía el correo
        mailSender.send(mensaje); // Envía el correo
    }
}
