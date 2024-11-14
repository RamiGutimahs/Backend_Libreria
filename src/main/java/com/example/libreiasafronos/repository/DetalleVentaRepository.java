package com.example.libreiasafronos.repository;

import com.example.libreiasafronos.model.DetalleVenta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends MongoRepository<DetalleVenta, String> {
    // Métodos CRUD básicos proporcionados por MongoRepository
}
