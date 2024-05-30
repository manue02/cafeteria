package com.proyecto.cafeteria.services;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.cafeteria.models.mesasPagadasModel;
import com.proyecto.cafeteria.repositories.IMesasPagadasRepository;

@Service
public class mesasPagadasService {

    private final IMesasPagadasRepository mesasPagadasRepository;

    public mesasPagadasService(IMesasPagadasRepository mesasPagadasRepository) {
        this.mesasPagadasRepository = mesasPagadasRepository;
    }

    public List<mesasPagadasModel> getAllMesasPagadas() {
        return mesasPagadasRepository.findAll();
    }

    public mesasPagadasModel saveMesaPagada(mesasPagadasModel mesaPagada) {
        return mesasPagadasRepository.save(mesaPagada);
    }

    public List<mesasPagadasModel> getMesasPagadasByFechaAndHora(LocalDate fecha, Time hora) {
        return mesasPagadasRepository.findByFechaAndHora(fecha, hora);
    }

    public Optional<mesasPagadasModel> getMesasPagadasById(Integer id) {
        return mesasPagadasRepository.findById(id);
    }

}
