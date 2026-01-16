package com.example.EjercicioCV.controller;

import com.example.EjercicioCV.model.*;
import com.example.EjercicioCV.service.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private InfoService infoService;
    private EstudiosService estudiosService;
    private ExperienciaService experienciaService;
    private LenguajeService lenguajeService;
    private ProyectoService proyectoService;

    public HomeController(InfoService infoService, EstudiosService estudiosService,ExperienciaService experienciaService, LenguajeService lenguajeService, ProyectoService proyectoService) {
        this.infoService = infoService;
        this.estudiosService = estudiosService;
        this.experienciaService = experienciaService;
        this.lenguajeService = lenguajeService;
        this.proyectoService = proyectoService;
    }

    @GetMapping("/")
    public String index(Model model) {
        //Hacer la petición al servicio
        Info info = infoService.getAll().get(0);
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
}