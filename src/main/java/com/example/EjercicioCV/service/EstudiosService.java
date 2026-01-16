package com.example.EjercicioCV.service;

import com.example.EjercicioCV.model.Estudios;
import com.example.EjercicioCV.repository.EstudiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiosService {

    @Autowired
    private EstudiosRepository repo;

    public List<Estudios> getAll() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "fechaInicio"));
    }

    public Estudios findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Estudios save(Estudios est) {
        return repo.save(est);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}