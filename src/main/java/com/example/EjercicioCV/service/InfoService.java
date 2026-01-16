package com.example.EjercicioCV.service;

import com.example.EjercicioCV.model.Info;
import com.example.EjercicioCV.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Autowired
    private InfoRepository repo;

    public Info getInfo() {
        return repo.findAll().stream().findFirst().orElse(null);
    }

    public Info findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Info save(Info info) {
        return repo.save(info);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}