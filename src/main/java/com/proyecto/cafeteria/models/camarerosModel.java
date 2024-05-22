package com.proyecto.cafeteria.models;

import java.util.Set;

import jakarta.persistence.*;


@Entity
@Table(name = "camareros")
public class camarerosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "activo")
    private Boolean activo;

    @OneToMany(mappedBy = "camareros")
    private Set<mesasModel> mesas;

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public camarerosModel() {
    }

    public camarerosModel(String nombre, Boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }
}
