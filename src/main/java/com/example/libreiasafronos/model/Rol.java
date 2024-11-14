package com.example.libreiasafronos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "roles")
public class Rol {
    @Id
    private String id; // Ej. "ADMINISTRADOR"
    private String nombre;
    private List<String> permisos; // Almacena IDs de permisos

    // Getters y setters
}