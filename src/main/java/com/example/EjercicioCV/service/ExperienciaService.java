package com.example.EjercicioCV.service;

import com.example.EjercicioCV.model.Experiencia;
import com.example.EjercicioCV.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService {

    @Autowired
    private ExperienciaRepository repo;

    public List<Experiencia> getAll() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "fechaInicio"));
    }

    public Experiencia findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Experiencia save(Experiencia exp) {
        return repo.save(exp);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}