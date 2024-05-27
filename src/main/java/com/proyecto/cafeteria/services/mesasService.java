package com.proyecto.cafeteria.services;

import org.springframework.stereotype.Service;
import java.util.*;

import com.proyecto.cafeteria.models.mesasModel;
import com.proyecto.cafeteria.repositories.IMesasRepository;

@Service
public class mesasService {

    private final IMesasRepository mesasRepository;

    public mesasService(IMesasRepository mesasRepository) {
        this.mesasRepository = mesasRepository;
    }

    public List<mesasModel> getAllMesas() {
        return mesasRepository.findAll();
    }

    public mesasModel saveMesa(mesasModel mesa) {
        return mesasRepository.save(mesa);
    }

    public Optional<mesasModel> getMesaById(Integer id) {
        return mesasRepository.findById(id);
    }

}
