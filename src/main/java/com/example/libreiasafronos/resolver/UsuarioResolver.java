package com.example.libreiasafronos.resolver;

import com.example.libreiasafronos.model.Usuario;
import com.example.libreiasafronos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UsuarioResolver {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Consulta para obtener todos los usuarios
    @QueryMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    // Consulta para obtener un usuario por ID
    @QueryMapping
    public Optional<Usuario> obtenerUsuarioPorId(@Argument String id) {
        return usuarioRepository.findById(id);
    }

    // Mutación para agregar un usuario
    @MutationMapping
    public Usuario agregarUsuario(
            @Argument String nombreCompleto,
            @Argument String correoElectronico,
            @Argument String contrasena,
            @Argument String rol) {

        Usuario usuario = new Usuario();
        usuario.setNombreCompleto(nombreCompleto);
        usuario.setCorreoElectronico(correoElectronico);
        usuario.setContrasena(contrasena);
        usuario.setRol(rol);
        return usuarioRepository.save(usuario);
    }

    // Mutación para actualizar un usuario
    @MutationMapping
    public Optional<Usuario> actualizarUsuario(
            @Argument String id,
            @Argument String nombreCompleto,
            @Argument String correoElectronico,
            @Argument String contrasena,
            @Argument String rol) {

        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombreCompleto(nombreCompleto);
            usuario.setCorreoElectronico(correoElectronico);
            usuario.setContrasena(contrasena);
            usuario.setRol(rol);
            return usuarioRepository.save(usuario);
        });
    }

    // Mutación para eliminar un usuario
    @MutationMapping
    public Boolean eliminarUsuario(@Argument String id) {
        usuarioRepository.deleteById(id);
        return true;
    }
}
