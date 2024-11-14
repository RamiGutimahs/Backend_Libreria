package com.example.libreiasafronos.repository;

import com.example.libreiasafronos.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<Persona, String> {
}
