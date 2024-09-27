package com.tienda.dispositivos_inteligentes.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Comentario")
    private Long idComentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Producto", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "contenido", length = 1000)
    private String contenido;

    @Column(name = "FechaComentario")
    @Temporal(TemporalType.DATE)
    private Date fechaComentario;

    public Comentario() {
    }

    public Comentario(Producto producto, Usuario usuario, String contenido, Date fechaComentario) {
        this.producto = producto;
        this.usuario = usuario;
        this.contenido = contenido;
        this.fechaComentario = fechaComentario;
    }

    public Long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
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


    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
}

