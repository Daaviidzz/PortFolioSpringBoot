package com.example.EjercicioCV.service;


import com.example.EjercicioCV.model.Usuario;
import com.example.EjercicioCV.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    public UsuarioService() {
        passwordEncoder = new BCryptPasswordEncoder();
    }
    // Registrar un nuevo usuario
    public Usuario registrarUsuario(String username, String password,
                                    String email) {
        // Verificar si el usuario ya existe
        if (usuarioRepository.existsByUsername(username)) {
            throw new RuntimeException("El nombre de usuario ya existe");
        }
        if (usuarioRepository.existsByEmail(email)) {
            throw new RuntimeException("El email ya está registrado");
        }
        // Crear el usuario
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(passwordEncoder.encode(password)); //Encriptar contraseña
        usuario.setEmail(email);
        usuario.setRole("ROLE_USER");
        usuario.setEnabled(true);
        return usuarioRepository.save(usuario);
    }
    // Buscar usuario por username
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
    // Verificar si existe el username
    public Boolean existsByUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }
    // Verificar si existe el email
    public Boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
}