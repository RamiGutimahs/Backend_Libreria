package com.example.libreiasafronos.repository;

import com.example.libreiasafronos.model.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends MongoRepository<Libro, String> {
    // Métodos CRUD básicos proporcionados por MongoRepository
}

