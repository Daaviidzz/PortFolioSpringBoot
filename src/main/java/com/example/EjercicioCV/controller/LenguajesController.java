package com.example.EjercicioCV.controller;

import com.example.EjercicioCV.model.Lenguaje;
import com.example.EjercicioCV.service.LenguajeService;
import com.example.EjercicioCV.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/lenguajes")
public class LenguajesController {

    @Autowired private LenguajeService lenguajeService;
    @Autowired private InfoService infoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("info", infoService.getAll().get(0));
        model.addAttribute("lenguajes", lenguajeService.getAll());
        model.addAttribute("lenguaje", new Lenguaje());
        return "admin/lenguaje-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Lenguaje lenguaje) {
        lenguajeService.save(lenguaje);
        return "redirect:/admin/lenguajes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        lenguajeService.delete(id);
        return "redirect:/admin/lenguajes";
    }
}