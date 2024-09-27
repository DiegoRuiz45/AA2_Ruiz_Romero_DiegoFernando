package com.tienda.dispositivos_inteligentes.model;


import jakarta.persistence.*;

@Entity
public class DetallesProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Detalle")
    private Long idDetalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Producto", nullable = false)
    private Producto producto;

    @Column(name = "Titulo", nullable = false)
    private String titulo;

    @Column(name = "Caracteristicas", length = 500)
    private String caracteristicas;

    @Column(name = "Foto")
    private String foto;

    public DetallesProducto() {
    }

    public DetallesProducto(Producto producto, String titulo, String caracteristicas, String foto) {
        this.producto = producto;
        this.titulo = titulo;
        this.caracteristicas = caracteristicas;
        this.foto = foto;
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
