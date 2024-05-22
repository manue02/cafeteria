package com.proyecto.cafeteria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.cafeteria.models.productosModel;

@Repository
public interface IProductosRepository extends JpaRepository<productosModel, Integer>{

}
