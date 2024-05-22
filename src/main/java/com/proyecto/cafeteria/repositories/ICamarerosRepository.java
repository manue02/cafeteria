package com.proyecto.cafeteria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.cafeteria.models.camarerosModel;

@Repository
public interface ICamarerosRepository extends JpaRepository<camarerosModel, Integer> {

}
