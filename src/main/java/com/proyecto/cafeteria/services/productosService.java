package com.proyecto.cafeteria.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.cafeteria.models.productosModel;
import com.proyecto.cafeteria.repositories.IProductosRepository;

@Service
public class productosService {

    private final IProductosRepository productosRepository;

    public productosService(IProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    public productosModel saveProducto(productosModel producto) {
        return productosRepository.save(producto);
    }

    public Optional<productosModel> findById(Integer id) {
        return productosRepository.findById(id);
    }

}
