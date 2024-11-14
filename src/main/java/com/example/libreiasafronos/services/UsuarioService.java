package com.example.libreiasafronos.services;

import com.example.libreiasafronos.model.Usuario;
import com.example.libreiasafronos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener usuario por ID
    public Optional<Usuario> obtenerUsuarioPorId(String id) {
        return usuarioRepository.findById(id);
    }

    // Agregar un nuevo usuario
    public Usuario agregarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Actualizar un usuario existente
    public Usuario actualizarUsuario(String id, Usuario usuarioActualizado) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombreCompleto(usuarioActualizado.getNombreCompleto());
            usuario.setCorreoElectronico(usuarioActualizado.getCorreoElectronico());
            usuario.setContrasena(usuarioActualizado.getContrasena());
            usuario.setRol(usuarioActualizado.getRol());
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // Eliminar un usuario
    public void eliminarUsuario(String id) {
        usuarioRepository.deleteById(id);
    }
}

