package com.proyecto.cafeteria.services;

import java.util.*;
import org.springframework.stereotype.Service;

import com.proyecto.cafeteria.models.categoriasModel;
import com.proyecto.cafeteria.repositories.ICategoriasRepository;

@Service
public class categoriasService {

    private final ICategoriasRepository categoriasRepository;

    public categoriasService(ICategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    public List<categoriasModel> findAll() {
        return categoriasRepository.findAll();
    }

    public categoriasModel saveCategoria(categoriasModel categoria) {
        return categoriasRepository.save(categoria);
    }

    public Optional<categoriasModel> findById(Integer id) {
        return categoriasRepository.findById(id);
    }

}
