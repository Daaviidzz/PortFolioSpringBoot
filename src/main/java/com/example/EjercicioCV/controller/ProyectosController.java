package com.example.EjercicioCV.controller;

import com.example.EjercicioCV.model.Proyecto;
import com.example.EjercicioCV.service.ProyectoService;
import com.example.EjercicioCV.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/proyectos")
public class ProyectosController {

    @Autowired private ProyectoService proyectoService;
    @Autowired private InfoService infoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("info", infoService.getAll().get(0));
        model.addAttribute("proyectos", proyectoService.getAll());
        model.addAttribute("proyecto", new Proyecto());
        return "admin/proyecto-form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("info", infoService.getAll().get(0));
        model.addAttribute("proyecto", proyectoService.findById(id));
        model.addAttribute("proyectos", proyectoService.getAll());
        return "admin/proyecto-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Proyecto proyecto) {
        proyectoService.save(proyecto);
        return "redirect:/admin/proyectos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        proyectoService.delete(id);
        return "redirect:/admin/proyectos";
    }
}