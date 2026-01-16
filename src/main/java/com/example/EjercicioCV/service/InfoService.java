package com.example.EjercicioCV.service;

import com.example.EjercicioCV.model.Info;
import com.example.EjercicioCV.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    private InfoRepository repo;

    public List<Info> getAll() {
        return repo.findAll();
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