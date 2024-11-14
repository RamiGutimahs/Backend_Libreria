package com.example.libreiasafronos.resolver;
import com.example.libreiasafronos.model.DetalleVenta;
import com.example.libreiasafronos.model.Venta;
import com.example.libreiasafronos.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class VentaResolver {

    @Autowired
    private VentaService ventaService;

    @QueryMapping
    public List<Venta> obtenerVentas() {
        return ventaService.obtenerTodasLasVentas();
    }

    @QueryMapping
    public Optional<Venta> obtenerVentaPorId(@Argument String id) {
        return ventaService.obtenerVentaPorId(id);
    }

    @MutationMapping
    public Venta agregarVenta(
            @Argument String cajeroId,
            @Argument String fechaVenta,
            @Argument Float totalVenta,
            @Argument List<DetalleVenta> detallesVenta
    ) {
        Venta venta = new Venta();
        venta.setCajeroId(cajeroId);
        venta.setFechaVenta(LocalDate.parse(fechaVenta));
        venta.setTotalVenta(BigDecimal.valueOf(totalVenta));
        venta.setDetallesVenta(detallesVenta.stream().map(det -> {
            DetalleVenta detalle = new DetalleVenta();
            detalle.setLibroId(det.getLibroId());
            detalle.setCantidad(det.getCantidad());
            detalle.setPrecioUnitario(det.getPrecioUnitario());
            return detalle;
        }).collect(Collectors.toList()));
        return ventaService.agregarVenta(venta);
    }

    @MutationMapping
    public Venta actualizarVenta(
            @Argument String id,
            @Argument String cajeroId,
            @Argument String fechaVenta,
            @Argument Float totalVenta,
            @Argument List<DetalleVenta> detallesVenta
    ) {
        Venta ventaActualizada = new Venta();
        ventaActualizada.setCajeroId(cajeroId);
        ventaActualizada.setFechaVenta(LocalDate.parse(fechaVenta));
        ventaActualizada.setTotalVenta(BigDecimal.valueOf(totalVenta));
        ventaActualizada.setDetallesVenta(detallesVenta.stream().map(det -> {
            DetalleVenta detalle = new DetalleVenta();
            detalle.setLibroId(det.getLibroId());
            detalle.setCantidad(det.getCantidad());
            detalle.setPrecioUnitario(det.getPrecioUnitario());
            return detalle;
        }).collect(Collectors.toList()));
        return ventaService.actualizarVenta(id, ventaActualizada);
    }

    @MutationMapping
    public Boolean eliminarVenta(@Argument String id) {
        ventaService.eliminarVenta(id);
        return true;
    }
}
