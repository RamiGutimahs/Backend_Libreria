package com.example.libreiasafronos.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class Venta {
    @Id
    private String id;
    private String cajeroId; // Referencia al ID del usuario con rol de Cajero
    private LocalDate fechaVenta;
    private BigDecimal totalVenta;
    private List<DetalleVenta> detallesVenta;

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCajeroId() { return cajeroId; }
    public void setCajeroId(String cajeroId) { this.cajeroId = cajeroId; }

    public LocalDate getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(LocalDate fechaVenta) { this.fechaVenta = fechaVenta; }

    public BigDecimal getTotalVenta() { return totalVenta; }
    public void setTotalVenta(BigDecimal totalVenta) { this.totalVenta = totalVenta; }

    public List<DetalleVenta> getDetallesVenta() { return detallesVenta; }
    public void setDetallesVenta(List<DetalleVenta> detallesVenta) { this.detallesVenta = detallesVenta; }
}