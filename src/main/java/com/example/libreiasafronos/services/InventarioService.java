package com.example.libreiasafronos.services;
import com.example.libreiasafronos.model.Inventario;
import com.example.libreiasafronos.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    // Obtener todos los movimientos de inventario
    public List<Inventario> obtenerTodosLosMovimientos() {
        return inventarioRepository.findAll();
    }

    // Obtener un movimiento de inventario por ID
    public Optional<Inventario> obtenerMovimientoPorId(String id) {
        return inventarioRepository.findById(id);
    }

    // Crear un nuevo movimiento de inventario
    public Inventario crearMovimiento(Inventario movimiento) {
        return inventarioRepository.save(movimiento);
    }

    // Actualizar un movimiento de inventario existente
    public Inventario actualizarMovimiento(String id, Inventario movimientoActualizado) {
        return inventarioRepository.findById(id).map(movimiento -> {
            movimiento.setLibros(movimientoActualizado.getLibros());
            movimiento.setFechaMovimiento(movimientoActualizado.getFechaMovimiento());
            movimiento.setCantidad(movimientoActualizado.getCantidad());
            movimiento.setTipoMovimiento(movimientoActualizado.getTipoMovimiento());
            movimiento.setDescripcion(movimientoActualizado.getDescripcion());
            return inventarioRepository.save(movimiento);
        }).orElseThrow(() -> new RuntimeException("Movimiento de inventario no encontrado con ID: " + id));
    }

    // Eliminar un movimiento de inventario
    public void eliminarMovimiento(String id) {
        inventarioRepository.deleteById(id);
    }
}
