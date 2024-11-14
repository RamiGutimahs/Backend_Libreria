package com.example.libreiasafronos.resolver;
import com.example.libreiasafronos.model.Libreria;
import com.example.libreiasafronos.repository.LibreriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class LibreriaResolver {

    @Autowired
    private LibreriaRepository libreriaRepository;

    // Consulta para obtener todas las librerías
    @QueryMapping
    public List<Libreria> obtenerLibrerias() {
        return libreriaRepository.findAll();
    }

    // Consulta para obtener una librería por ID
    @QueryMapping
    public Optional<Libreria> obtenerLibreriaPorId(@Argument String id) {
        return libreriaRepository.findById(id);
    }

    // Mutación para agregar una librería
    @MutationMapping
    public Libreria agregarLibreria(@Argument String nombre, @Argument String ubicacion) {
        Libreria libreria = new Libreria();
        libreria.setNombre(nombre);
        libreria.setUbicacion(ubicacion);
        return libreriaRepository.save(libreria);
    }

    // Mutación para actualizar una librería
    @MutationMapping
    public Optional<Libreria> actualizarLibreria(@Argument String id, @Argument String nombre, @Argument String ubicacion) {
        return libreriaRepository.findById(id).map(libreria -> {
            libreria.setNombre(nombre);
            libreria.setUbicacion(ubicacion);
            return libreriaRepository.save(libreria);
        });
    }

    // Mutación para eliminar una librería
    @MutationMapping
    public Boolean eliminarLibreria(@Argument String id) {
        libreriaRepository.deleteById(id);
        return true;
    }
}
