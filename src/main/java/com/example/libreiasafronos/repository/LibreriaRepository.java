package com.example.libreiasafronos.repository;

import com.example.libreiasafronos.model.Libreria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibreriaRepository extends MongoRepository<Libreria, String> {
    // Métodos CRUD básicos proporcionados por MongoRepository
}
