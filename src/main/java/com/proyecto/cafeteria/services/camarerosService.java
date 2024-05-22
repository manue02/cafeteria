package com.proyecto.cafeteria.services;

import java.util.*;
import org.springframework.stereotype.Service;

import com.proyecto.cafeteria.models.camarerosModel;
import com.proyecto.cafeteria.repositories.ICamarerosRepository;

@Service
public class camarerosService {

    private final ICamarerosRepository camarerosRepository;

    public camarerosService(ICamarerosRepository camarerosRepository) {
        this.camarerosRepository = camarerosRepository;
    }

    public List<camarerosModel> getAllCamareros() {
        return camarerosRepository.findAll();
    }

    public camarerosModel saveCamarero(camarerosModel camarero) {
        return camarerosRepository.save(camarero);
    }

    public Optional<camarerosModel> findById(Integer id) {
        return camarerosRepository.findById(id);
    }

}
