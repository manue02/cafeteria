package com.proyecto.cafeteria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.cafeteria.models.cuentasModel;

@Repository
public interface ICuentasRepository extends JpaRepository<cuentasModel, Integer>{

}
