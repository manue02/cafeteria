package com.proyecto.cafeteria.models;

import java.util.Set;

import jakarta.persistence.*;


@Entity
@Table(name = "mesas")
public class mesasModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numeroMesa")
    private Integer numeroMesa;

    @Column(name = "activo")
    private Boolean activo;

    @OneToMany(mappedBy = "mesa")
    private Set<cuentasModel> cuentas;

    @ManyToOne
    @JoinColumn(name = "camarero", nullable = false)
    private camarerosModel camareros;

    @OneToMany(mappedBy = "numeroMesa")
    private Set<mesasPagadasModel> mesasPagadas;


    public Integer getId() {
        return id;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public Boolean getActivo() {
        return activo;
    }

    public camarerosModel getCamareros() {
        return camareros;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setCamareros(camarerosModel camareros) {
        this.camareros = camareros;
    }

    public mesasModel() {
    }

    public mesasModel(Integer numeroMesa, Boolean activo, camarerosModel camareros) {
        this.numeroMesa = numeroMesa;
        this.activo = activo;
        this.camareros = camareros;
    }


}
