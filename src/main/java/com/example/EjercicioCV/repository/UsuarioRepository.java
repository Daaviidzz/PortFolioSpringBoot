package com.example.EjercicioCV.repository;

import com.example.EjercicioCV.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Buscar usuario por nombre de usuario
    Optional<Usuario> findByUsername(String username);
    // Verificar si existe un usuario con ese username
    Boolean existsByUsername(String username);
    // Verificar si existe un usuario con ese email
    Boolean existsByEmail(String email);
}
