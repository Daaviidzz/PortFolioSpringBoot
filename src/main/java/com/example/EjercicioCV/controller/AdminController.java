package com.example.EjercicioCV.controller;

import com.example.EjercicioCV.model.Info;
import com.example.EjercicioCV.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin") // Todas las rutas aquí empiezan por /admin
public class AdminController {

    private final InfoService infoService;
    private final ProyectoService proyectoService;
    private final ExperienciaService experienciaService;
    private final LenguajeService lenguajeService;
    private final EstudiosService estudiosService;

    public AdminController(InfoService infoService, ProyectoService proyectoService,
                           ExperienciaService experienciaService, LenguajeService lenguajeService, EstudiosService estudiosService) {
        this.infoService = infoService;
        this.proyectoService = proyectoService;
        this.experienciaService = experienciaService;
        this.lenguajeService = lenguajeService;
        this.estudiosService = estudiosService;
    }

    @GetMapping
    public String dashboard(Model model) {
        List<Info> infoList = infoService.getAll();

        if (!infoList.isEmpty()) {
            model.addAttribute("info", infoList.get(0));
        } else {
            model.addAttribute("info", new Info());
        }

        model.addAttribute("totalProyectos", proyectoService.getAll().size());
        model.addAttribute("totalExperiencias", experienciaService.getAll().size());
        model.addAttribute("totalEstudios", estudiosService.getAll().size());
        model.addAttribute("totalLenguajes", lenguajeService.getAll().size());

        return "admin/dashboard";
    }
}