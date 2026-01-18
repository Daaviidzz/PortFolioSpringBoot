package com.example.EjercicioCV.controller;

import com.example.EjercicioCV.model.Estudios;
import com.example.EjercicioCV.service.EstudiosService;
import com.example.EjercicioCV.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/estudios")
public class EstudiosController {

    @Autowired private EstudiosService estudiosService;
    @Autowired private InfoService infoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("info", infoService.getAll().get(0));
        model.addAttribute("estudios", estudiosService.getAll());
        model.addAttribute("estudio", new Estudios()); // Para el formulario de "nuevo"
        return "admin/estudios-form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("info", infoService.getAll().get(0));
        model.addAttribute("estudio", estudiosService.findById(id));
        model.addAttribute("estudios", estudiosService.getAll());
        return "admin/estudios-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Estudios estudio) {
        estudiosService.save(estudio);
        return "redirect:/admin/estudios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        estudiosService.delete(id);
        return "redirect:/admin/estudios";
    }
}