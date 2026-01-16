package com.example.EjercicioCV.service;

import com.example.EjercicioCV.model.Proyecto;
import com.example.EjercicioCV.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository repo;

    public List<Proyecto> findAll() {
        return repo.findAll();
    }

    public Proyecto findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Proyecto save(Proyecto proyecto) {
        return repo.save(proyecto);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}