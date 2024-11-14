package com.example.libreiasafronos.repository;

import com.example.libreiasafronos.model.Libreria;
import com.example.libreiasafronos.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    // Métodos CRUD básicos proporcionados por MongoRepository
}
