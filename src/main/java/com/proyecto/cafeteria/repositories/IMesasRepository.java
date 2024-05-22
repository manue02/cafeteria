package com.proyecto.cafeteria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.cafeteria.models.mesasModel;

@Repository
public interface IMesasRepository extends JpaRepository<mesasModel, Integer>{

}
