package com.proyecto.cafeteria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.cafeteria.models.categoriasModel;

@Repository
public interface ICategoriasRepository extends JpaRepository<categoriasModel, Integer>{

}
