package com.example.EjercicioCV.model;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(columnDefinition = "github_url")
    private String githubUrl;
    @Column(columnDefinition = "imagen_url")
    private String imagenUrl;
    private LocalDate fecha;

    @ManyToMany
    @JoinTable(
            name = "proyecto_lenguaje",
            joinColumns = @JoinColumn(name = "proyecto_id"),
            inverseJoinColumns = @JoinColumn(name = "lenguaje_id")
    )
    private Set<Lenguaje> lenguajes = new HashSet<>();
}

