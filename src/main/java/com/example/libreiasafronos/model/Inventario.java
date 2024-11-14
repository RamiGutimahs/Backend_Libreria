package com.example.libreiasafronos.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
public class Inventario {
    @Id
    private String id;
    private List<Libro> libros; // Referencia a la entidad Libro
    private LocalDate fechaMovimiento;
    private int cantidad;
    private String tipoMovimiento; // ENUM: INGRESO, SALIDA
    private String descripcion;

}