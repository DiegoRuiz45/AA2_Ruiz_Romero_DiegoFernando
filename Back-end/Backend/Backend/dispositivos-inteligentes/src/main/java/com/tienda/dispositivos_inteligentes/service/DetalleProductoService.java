package com.tienda.dispositivos_inteligentes.service;

import com.tienda.dispositivos_inteligentes.model.DetallesProducto;
import com.tienda.dispositivos_inteligentes.model.Producto;
import com.tienda.dispositivos_inteligentes.repository.DetallesProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleProductoService {

    @Autowired
    private DetallesProductoRepository detallesProductoRepository;

    public List<DetallesProducto> obtenerDetalle() {
        return detallesProductoRepository.findAll();
    }

    public Optional<DetallesProducto> obtenerDetalleId(Long id) {
        return detallesProductoRepository.findById(id);
    }

    public DetallesProducto guardarDetalle(DetallesProducto producto) {
        return detallesProductoRepository.save(producto);
    }

    public void eliminarDetalle(Long id) {
        detallesProductoRepository.deleteById(id);
    }
}