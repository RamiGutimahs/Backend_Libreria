package com.example.libreiasafronos.services;

import com.example.libreiasafronos.model.Libro;
import com.example.libreiasafronos.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    // Obtener todos los libros
    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    // Obtener libro por ID
    public Optional<Libro> obtenerLibroPorId(String id) {
        return libroRepository.findById(id);
    }

    // Agregar un nuevo libro
    public Libro agregarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // Actualizar un libro existente
    public Libro actualizarLibro(String id, Libro libroActualizado) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(libroActualizado.getTitulo());
            libro.setAutor(libroActualizado.getAutor());
            libro.setEditorial(libroActualizado.getEditorial());
            libro.setGenero(libroActualizado.getGenero());
            libro.setPrecioVenta(libroActualizado.getPrecioVenta());
            libro.setStock(libroActualizado.getStock());
            libro.setDescripcion(libroActualizado.getDescripcion());
            libro.setImagen(libroActualizado.getImagen());
            return libroRepository.save(libro);
        }).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    // Eliminar un libro
    public void eliminarLibro(String id) {
        libroRepository.deleteById(id);
    }
}

