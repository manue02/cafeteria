package com.proyecto.cafeteria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.cafeteria.models.mesasPagadasModel;

import java.sql.Time;
import java.time.LocalDate;


@Repository
public interface IMesasPagadasRepository extends JpaRepository<mesasPagadasModel, Integer>{

    List<mesasPagadasModel> findByFechaAndHora (LocalDate fecha, Time hora);

}
