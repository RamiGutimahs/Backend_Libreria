package com.example.libreiasafronos.services;

import com.example.libreiasafronos.model.Venta;
import com.example.libreiasafronos.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    // Obtener todas las ventas
    public List<Venta> obtenerTodasLasVentas() {
        return ventaRepository.findAll();
    }

    // Obtener venta por ID
    public Optional<Venta> obtenerVentaPorId(String id) {
        return ventaRepository.findById(id);
    }

    // Agregar una nueva venta
    public Venta agregarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    // Actualizar una venta existente
    public Venta actualizarVenta(String id, Venta ventaActualizada) {
        return ventaRepository.findById(id).map(venta -> {
            venta.setCajeroId(ventaActualizada.getCajeroId());
            venta.setFechaVenta(ventaActualizada.getFechaVenta());
            venta.setTotalVenta(ventaActualizada.getTotalVenta());
            venta.setDetallesVenta(ventaActualizada.getDetallesVenta());
            return ventaRepository.save(venta);
        }).orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }

    // Eliminar una venta
    public void eliminarVenta(String id) {
        ventaRepository.deleteById(id);
    }
}
