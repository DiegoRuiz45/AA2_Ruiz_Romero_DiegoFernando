package com.tienda.dispositivos_inteligentes.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Producto")
    private Long idProducto;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Marca", nullable = false)
    private String marca;

    @Column(name = "TipoDispositivos", nullable = false)
    private String tipoDispositivos;

    @Column(name = "FechaLanzamiento")
    private Date fechaLanzamiento;

    /*
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<DetallesProducto> detallesProducto;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Compra> compras;
    * */

    public Producto() {

    }
    public Producto(String nombre, String marca, String tipoDispositivos, Date fechaLanzamiento) {
        this.nombre = nombre;
        this.marca = marca;
        this.tipoDispositivos = tipoDispositivos;
        this.fechaLanzamiento = fechaLanzamiento;
        //this.detallesProducto = detallesProducto;
        //this.comentarios = comentarios;
    }


    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoDispositivos() {
        return tipoDispositivos;
    }

    public void setTipoDispositivos(String tipoDispositivos) {
        this.tipoDispositivos = tipoDispositivos;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
/*
    public List<DetallesProducto> getDetallesProducto() {
        return detallesProducto;
    }

    public void setDetallesProducto(List<DetallesProducto> detallesProducto) {
        this.detallesProducto = detallesProducto;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
* */
}
