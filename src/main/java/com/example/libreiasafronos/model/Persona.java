package com.example.libreiasafronos.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "personas")
public class Persona {
    @Id
    @Indexed(unique = true)
    private String id;
    private String nombre;
    @Indexed(unique = true)
    private List<String> roles; // Ejemplo: ["PROPIETARIO", "ARRENDATARIO","VIVIENTE","REGENTE","ADMINISTRADOR"]

    private Libro libro; // Departamento donde es viviente

    private List<Libreria> libreria; // Condominios donde es regente
}

