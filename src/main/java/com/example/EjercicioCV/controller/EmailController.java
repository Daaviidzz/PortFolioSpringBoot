package com.example.EjercicioCV.controller;

import com.example.EjercicioCV.service.EmailService;
import org.springframework.web.bind.annotation.*;
@RestController // Indica que esta clase manejará solicitudes HTTP
@RequestMapping("/email") // Define la ruta base para las peticiones
public class EmailController {
    private final EmailService emailService;
    public EmailController(final EmailService emailService) {
        this.emailService = emailService;
    }
    @PostMapping("/send") // Define una ruta POST para enviar correos
    public String enviarCorreo(@RequestParam String to,
                               @RequestParam String subject,
                               @RequestParam String body) {
        emailService.enviarCorreo(to, subject, body);
        return "Correo enviado correctamente a " + to;
    }
}

