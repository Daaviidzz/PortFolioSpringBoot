package com.example.EjercicioCV.controller;

import com.example.EjercicioCV.model.*;
import com.example.EjercicioCV.service.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private UsuarioService usuarioService;
    private InfoService infoService;
    private EstudiosService estudiosService;
    private ExperienciaService experienciaService;
    private LenguajeService lenguajeService;
    private ProyectoService proyectoService;

    public HomeController(UsuarioService usuarioService, InfoService infoService, EstudiosService estudiosService, ExperienciaService experienciaService, LenguajeService lenguajeService, ProyectoService proyectoService) {
        this.usuarioService = usuarioService;
        this.infoService = infoService;
        this.estudiosService = estudiosService;
        this.experienciaService = experienciaService;
        this.lenguajeService = lenguajeService;
        this.proyectoService = proyectoService;
    }

    @GetMapping("/")
    public String index(Model model) {
        //Hacer la petición al servicio
        List<Info> infoList = infoService.getAll();
        Info info = infoList.isEmpty() ? null : infoList.get(0);
        List<Estudios> estudios = estudiosService.getAll();
        List<Experiencia> experiencias = experienciaService.getAll();
        List<Lenguaje> lenguajes = lenguajeService.getAll();
        List<Proyecto> proyectos = proyectoService.getAll();


        model.addAttribute("info", info);
        model.addAttribute("estudios", estudios);
        model.addAttribute("experiencias", experiencias);
        model.addAttribute("lenguajes", lenguajes);
        model.addAttribute("proyectos", proyectos);

        return "index";
    }

    // Mostrar página de login
    @GetMapping("/login")
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String
                    logout,
            Model model) {
        if (error != null) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
        }
        if (logout != null) {
            model.addAttribute("message", "Has cerrado sesión correctamente");
        }
        return "login";

    }
    // Mostrar página de registro
    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "registro";
    }
    // Procesar el registro
    @PostMapping("/registro")
    public String registrarUsuario(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            Model model) {
        try {
            // Validaciones básicas
            if (username.isEmpty() || password.isEmpty() ||
                    email.isEmpty()) {
                model.addAttribute("error", "Todos los campos son obligatorios");
                return "registro";
            }
            if (password.length() < 6) {
                model.addAttribute("error", "La contraseña debe tener al menos 6 caracteres");
                return "registro";
            }
            // Registrar el usuario
            usuarioService.registrarUsuario(username, password, email);
            // Redirigir al login con mensaje de éxito
            model.addAttribute("message", "Usuario registrado correctamente. Ya puedes iniciar sesión.");
            return "login";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "registro";
        }
    }
}

