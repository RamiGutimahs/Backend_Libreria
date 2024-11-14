package com.example.libreiasafronos.repository;

import com.example.libreiasafronos.model.Venta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends MongoRepository<Venta, String> {
    // Métodos CRUD básicos proporcionados por MongoRepository
}
