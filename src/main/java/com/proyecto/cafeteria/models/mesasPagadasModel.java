package com.proyecto.cafeteria.models;

import java.sql.Time;
import java.time.LocalDate;

import jakarta.persistence.*;


@Entity
@Table(name = "mesasPagadas")
public class mesasPagadasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "importe")
    private float tasa;

    @Column(name = "hora")
    private Time hora;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "activo")
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "numeroMesa", nullable = false)
    private mesasModel numeroMesa;


    public Integer getId() {
        return id;
    }

    public float getTasa() {
        return tasa;
    }

    public Time getHora() {
        return hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Boolean getActivo() {
        return activo;
    }

    public mesasModel getNumeroMesa() {
        return numeroMesa;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setNumeroMesa(mesasModel numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public mesasPagadasModel() {
    }

    public mesasPagadasModel(float tasa, Time hora, LocalDate fecha, Boolean activo, mesasModel numeroMesa) {
        this.tasa = tasa;
        this.hora = hora;
        this.fecha = fecha;
        this.activo = activo;
        this.numeroMesa = numeroMesa;
    }

}
