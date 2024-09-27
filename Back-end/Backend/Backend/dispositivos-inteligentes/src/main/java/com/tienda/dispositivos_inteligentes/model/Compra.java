package com.tienda.dispositivos_inteligentes.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_compra;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;

    private int cantidad;

    public Compra() {
    }

    public Compra(Usuario usuario, Producto producto, Date fechaCompra, int cantidad) {
        this.usuario = usuario;
        this.producto = producto;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
    }

    public Long getId_compra() {
        return id_compra;
    }

    public void setId_compra(Long id_compra) {
        this.id_compra = id_compra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

