package com.example.libreiasafronos.services;
import com.example.libreiasafronos.model.DetalleVenta;
import com.example.libreiasafronos.model.Venta;
import com.example.libreiasafronos.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class DetalleVentaService {

    @Autowired
    private VentaRepository ventaRepository;

    // Agregar un nuevo DetalleVenta a una venta existente
    public Venta agregarDetalleVenta(String ventaId, DetalleVenta nuevoDetalle) {
        Optional<Venta> ventaOpt = ventaRepository.findById(ventaId);
        if (ventaOpt.isPresent()) {
            Venta venta = ventaOpt.get();
            venta.getDetallesVenta().add(nuevoDetalle);
            actualizarTotalVenta(venta); // Recalcula el total de la venta
            return ventaRepository.save(venta);
        } else {
            throw new RuntimeException("Venta no encontrada con ID: " + ventaId);
        }
    }

    // Actualizar un DetalleVenta específico dentro de una venta
    public Venta actualizarDetalleVenta(String ventaId, int detalleIndex, DetalleVenta detalleActualizado) {
        Optional<Venta> ventaOpt = ventaRepository.findById(ventaId);
        if (ventaOpt.isPresent()) {
            Venta venta = ventaOpt.get();
            if (detalleIndex >= 0 && detalleIndex < venta.getDetallesVenta().size()) {
                venta.getDetallesVenta().set(detalleIndex, detalleActualizado);
                actualizarTotalVenta(venta); // Recalcula el total de la venta
                return ventaRepository.save(venta);
            } else {
                throw new RuntimeException("Índice de DetalleVenta inválido: " + detalleIndex);
            }
        } else {
            throw new RuntimeException("Venta no encontrada con ID: " + ventaId);
        }
    }

    // Eliminar un DetalleVenta específico de una venta
    public Venta eliminarDetalleVenta(String ventaId, int detalleIndex) {
        Optional<Venta> ventaOpt = ventaRepository.findById(ventaId);
        if (ventaOpt.isPresent()) {
            Venta venta = ventaOpt.get();
            if (detalleIndex >= 0 && detalleIndex < venta.getDetallesVenta().size()) {
                venta.getDetallesVenta().remove(detalleIndex);
                actualizarTotalVenta(venta); // Recalcula el total de la venta
                return ventaRepository.save(venta);
            } else {
                throw new RuntimeException("Índice de DetalleVenta inválido: " + detalleIndex);
            }
        } else {
            throw new RuntimeException("Venta no encontrada con ID: " + ventaId);
        }
    }

    // Método privado para recalcular el total de la venta
    private void actualizarTotalVenta(Venta venta) {
        BigDecimal total = venta.getDetallesVenta().stream()
                .map(detalle -> detalle.getPrecioUnitario().multiply(BigDecimal.valueOf(detalle.getCantidad())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        venta.setTotalVenta(total);
    }
}
