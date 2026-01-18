package com.example.EjercicioCV.controller;

import com.example.EjercicioCV.model.Experiencia;
import com.example.EjercicioCV.service.ExperienciaService;
import com.example.EjercicioCV.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/experiencia")
public class ExperienciaController {

    @Autowired private ExperienciaService experienciaService;
    @Autowired private InfoService infoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("info", infoService.getAll().get(0));
        model.addAttribute("experiencias", experienciaService.getAll());
        model.addAttribute("experiencia", new Experiencia());
        return "admin/experiencia-form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("info", infoService.getAll().get(0));
        model.addAttribute("experiencia", experienciaService.findById(id));
        model.addAttribute("experiencias", experienciaService.getAll());
        return "admin/experiencia-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Experiencia experiencia) {
        experienciaService.save(experiencia);
        return "redirect:/admin/experiencia";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        experienciaService.delete(id);
        return "redirect:/admin/experiencia";
    }
}