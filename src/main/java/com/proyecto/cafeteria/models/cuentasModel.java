package com.proyecto.cafeteria.models;


import jakarta.persistence.*;


@Entity
@Table(name = "cuentas")
public class cuentasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "precioUnidad")
    private float precioUnidad;

    @Column(name = "unidades")
    private Integer unidades;

    @Column(name = "activo")
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "mesa", nullable = false)
    private mesasModel mesa;

    @ManyToOne
    @JoinColumn(name = "producto", nullable = false)
    private productosModel producto;

    public Integer getId() {
        return id;
    }   

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public Boolean getActivo() {
        return activo;
    }

    public mesasModel getMesa() {
        return mesa;
    }

    public productosModel getProducto() {
        return producto;
    }


    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setMesa(mesasModel mesa) {
        this.mesa = mesa;
    }

    public void setProductos(productosModel producto) {
        this.producto = producto;
    }

    public cuentasModel() {
    }

    public cuentasModel(float precioUnidad, Integer unidades, Boolean activo, mesasModel mesa, productosModel producto) {
        this.precioUnidad = precioUnidad;
        this.unidades = unidades;
        this.activo = activo;
        this.mesa = mesa;
        this.producto = producto;
    }

}
