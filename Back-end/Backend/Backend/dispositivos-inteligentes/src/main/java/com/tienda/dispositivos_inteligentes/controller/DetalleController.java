package com.tienda.dispositivos_inteligentes.controller;

import com.tienda.dispositivos_inteligentes.model.DetallesProducto;
import com.tienda.dispositivos_inteligentes.model.Producto;
import com.tienda.dispositivos_inteligentes.service.DetalleProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalle")
public class DetalleController {

    @Autowired
    private DetalleProductoService detalleProductoService;

    @GetMapping("/detalles")
    public List<DetallesProducto> obtenerDetalles() {
        return detalleProductoService.obtenerDetalle();
    }

    @GetMapping("/detalles/{id}")
    public Optional<DetallesProducto> obtenerDetallesId(@PathVariable Long id) {
        return detalleProductoService.obtenerDetalleId(id);
    }

    @PostMapping("/detalles/guardar")
    public DetallesProducto guardarDetalle(@RequestBody DetallesProducto detalle) {
        return detalleProductoService.guardarDetalle(detalle);
    }

    @PutMapping("/detalles/actualizar/{id}")
    public ResponseEntity<DetallesProducto> actualizarDetalle(@PathVariable Long id, @RequestBody DetallesProducto detalleActualizado) {
        Optional<DetallesProducto> detalleExistente = detalleProductoService.obtenerDetalleId(id);
        if (detalleExistente.isPresent()) {
            DetallesProducto detalle = detalleExistente.get();

            // Actualizamos los campos
            detalle.setTitulo(detalleActualizado.getTitulo());
            detalle.setCaracteristicas(detalleActualizado.getCaracteristicas());
            detalle.setFoto(detalleActualizado.getFoto());
            detalle.setProducto(detalleActualizado.getProducto());

            // Guardamos los cambios
            DetallesProducto detalleActualizadoResult = detalleProductoService.guardarDetalle(detalle);
            return ResponseEntity.ok(detalleActualizadoResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/detalles/eliminar/{id}")
    public void eliminarDetalle(@PathVariable Long id) {
        detalleProductoService.eliminarDetalle(id);
    }
}
