package com.example.EjercicioCV.service;

import com.example.EjercicioCV.model.Lenguaje;
import com.example.EjercicioCV.repository.LenguajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LenguajeService {

    @Autowired
    private LenguajeRepository repo;

    public List<Lenguaje> getAll() {
        return repo.findAll();
    }

    public Lenguaje findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Lenguaje> findAllById(List<Long> ids) {
        return repo.findAllById(ids);
    }

    public Lenguaje save(Lenguaje lenguaje) {
        return repo.save(lenguaje);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}