package com.proyecto.cafeteria.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.cafeteria.models.cuentasModel;
import com.proyecto.cafeteria.repositories.ICuentasRepository;

@Service
public class cuentasService {

    private final ICuentasRepository cuentasRepository;

    public cuentasService(ICuentasRepository cuentasRepository) {
        this.cuentasRepository = cuentasRepository;
    }

    public cuentasModel saveCuenta(cuentasModel cuenta) {
        return cuentasRepository.save(cuenta);
    }

    public List<cuentasModel> getAllCuentas() {
        return cuentasRepository.findAll();
    }

}
