package com.example.libreiasafronos.services;

import com.example.libreiasafronos.model.Libreria;
import com.example.libreiasafronos.repository.LibreriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class LibreriaService {

    private final LibreriaRepository libreriaRepository;

    @Autowired
    public LibreriaService(LibreriaRepository libreriaRepository) {
        this.libreriaRepository = libreriaRepository;
    }

    public Libreria saveLibreria(Libreria libreria) {
        return libreriaRepository.save(libreria);
    }

    public List<Libreria> getAllLibrerias() {
        return libreriaRepository.findAll();
    }
}