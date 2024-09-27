package com.tienda.dispositivos_inteligentes.controller;

import com.tienda.dispositivos_inteligentes.model.Producto;
import com.tienda.dispositivos_inteligentes.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> obtenerTodosLosProductos() {

        return productoService.obtenerTodosLosProductos();
    }

    @GetMapping("/productos/{id}")
    public Optional<Producto> obtenerProductoPorId(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(id);
    }

    @PostMapping("/productos/guardar")
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    @PutMapping("/productos/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        Optional<Producto> productoExistente = productoService.obtenerProductoPorId(id);
        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();

            // Actualizar los campos
            producto.setNombre(productoActualizado.getNombre());
            producto.setMarca(productoActualizado.getMarca());
            producto.setTipoDispositivos(productoActualizado.getTipoDispositivos());
            producto.setFechaLanzamiento(productoActualizado.getFechaLanzamiento());

            // Guardar el producto actualizado
            Producto productoActualizadoResult = productoService.guardarProducto(producto);
            return ResponseEntity.ok(productoActualizadoResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
}
