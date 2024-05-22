package com.proyecto.cafeteria.models;

import java.util.Set;

import jakarta.persistence.*;


@Entity
@Table(name = "productos")
public class productosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private float precio;

    @Column(name = "activo")
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "categoria", nullable = false)
    private categoriasModel categoria;

    @OneToMany(mappedBy = "producto")
    private Set<cuentasModel> cuentas;

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public Boolean getActivo() {
        return activo;
    }

    public categoriasModel getCategoria() {
        return categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setCategoria(categoriasModel categoria) {
        this.categoria = categoria;
    }

    public productosModel() {
    }

    public productosModel(String nombre, float precio, Boolean activo, categoriasModel categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.activo = activo;
        this.categoria = categoria;
    }

}
