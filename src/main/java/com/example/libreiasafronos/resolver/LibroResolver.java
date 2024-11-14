package com.example.libreiasafronos.resolver;

import com.example.libreiasafronos.model.Libro;
import com.example.libreiasafronos.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
public class LibroResolver {

    @Autowired
    private LibroRepository libroRepository;

    // Consulta para obtener todos los libros
    @QueryMapping
    public List<Libro> obtenerLibros() {
        return libroRepository.findAll();
    }

    // Consulta para obtener un libro por ID
    @QueryMapping
    public Optional<Libro> obtenerLibroPorId(@Argument String id) {
        return libroRepository.findById(id);
    }

    // Mutación para agregar un libro
    @MutationMapping
    public Libro agregarLibro(
            @Argument String titulo,
            @Argument String autor,
            @Argument String editorial,
            @Argument String genero,
            @Argument BigDecimal precioVenta,
            @Argument int stock,
            @Argument String descripcion,
            @Argument String imagen) {

        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libro.setGenero(genero);
        libro.setPrecioVenta(precioVenta);
        libro.setStock(stock);
        libro.setDescripcion(descripcion);
        libro.setImagen(imagen);
        return libroRepository.save(libro);
    }

    // Mutación para actualizar un libro
    @MutationMapping
    public Optional<Libro> actualizarLibro(
            @Argument String id,
            @Argument String titulo,
            @Argument String autor,
            @Argument String editorial,
            @Argument String genero,
            @Argument BigDecimal precioVenta,
            @Argument int stock,
            @Argument String descripcion,
            @Argument String imagen) {

        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setGenero(genero);
            libro.setPrecioVenta(precioVenta);
            libro.setStock(stock);
            libro.setDescripcion(descripcion);
            libro.setImagen(imagen);
            return libroRepository.save(libro);
        });
    }

    // Mutación para eliminar un libro
    @MutationMapping
    public Boolean eliminarLibro(@Argument String id) {
        libroRepository.deleteById(id);
        return true;
    }
}
