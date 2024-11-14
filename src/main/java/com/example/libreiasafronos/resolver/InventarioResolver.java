package com.example.libreiasafronos.resolver;
import com.example.libreiasafronos.model.Inventario;
import com.example.libreiasafronos.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class InventarioResolver {

    @Autowired
    private InventarioService inventarioService;

    @QueryMapping
    public List<Inventario> obtenerTodosLosMovimientos() {
        return inventarioService.obtenerTodosLosMovimientos();
    }

    @QueryMapping
    public Optional<Inventario> obtenerMovimientoPorId(@Argument String id) {
        return inventarioService.obtenerMovimientoPorId(id);
    }

   /* @MutationMapping
    public Inventario crearMovimiento(@Argument InventarioInput input) {
        Inventario movimiento = new Inventario();
        movimiento.setLibros(mapToLibroList(input.getLibros()));  // Convierte los inputs de libro
        movimiento.setFechaMovimiento(LocalDate.parse(input.getFechaMovimiento()));
        movimiento.setCantidad(input.getCantidad());
        movimiento.setTipoMovimiento(input.getTipoMovimiento());
        movimiento.setDescripcion(input.getDescripcion());

        return inventarioService.crearMovimiento(movimiento);
    }

    @MutationMapping
    public Inventario actualizarMovimiento(@Argument String id, @Argument InventarioInput input) {
        Inventario movimientoActualizado = new Inventario();
        movimientoActualizado.setLibros(mapToLibroList(input.getLibros()));
        movimientoActualizado.setFechaMovimiento(LocalDate.parse(input.getFechaMovimiento()));
        movimientoActualizado.setCantidad(input.getCantidad());
        movimientoActualizado.setTipoMovimiento(input.getTipoMovimiento());
        movimientoActualizado.setDescripcion(input.getDescripcion());

        return inventarioService.actualizarMovimiento(id, movimientoActualizado);
    }

    @MutationMapping
    public Boolean eliminarMovimiento(@Argument String id) {
        inventarioService.eliminarMovimiento(id);
        return true;
    }

    // Método para convertir una lista de LibroInput a una lista de Libro
    private List<Libro> mapToLibroList(List<LibroInput> libroInputs) {
        return libroInputs.stream().map(libroInput -> {
            Libro libro = new Libro();
            libro.setId(libroInput.getId());
            libro.setTitulo(libroInput.getTitulo());
            libro.setAutor(libroInput.getAutor());
            libro.setEditorial(libroInput.getEditorial());
            libro.setGenero(libroInput.getGenero());
            libro.setPrecioVenta(libroInput.getPrecioVenta());
            libro.setStock(libroInput.getStock());
            libro.setDescripcion(libroInput.getDescripcion());
            libro.setImagen(libroInput.getImagen());
            return libro;
        }).collect(Collectors.toList());
    }*/
}
