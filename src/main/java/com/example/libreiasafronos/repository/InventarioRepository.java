package com.example.libreiasafronos.repository;

import com.example.libreiasafronos.model.Inventario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends MongoRepository<Inventario, String> {
    // Métodos CRUD básicos proporcionados por MongoRepository
}
