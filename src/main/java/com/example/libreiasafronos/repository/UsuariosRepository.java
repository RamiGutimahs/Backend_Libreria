package com.example.libreiasafronos.repository;

import com.example.libreiasafronos.model.Usuarios;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuariosRepository extends MongoRepository<Usuarios, String> {
    Optional<Usuarios> findByUsername(String username);
}
