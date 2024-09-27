package com.tienda.dispositivos_inteligentes.controller;

import com.tienda.dispositivos_inteligentes.model.Compra;
import com.tienda.dispositivos_inteligentes.service.CompraService;
import com.tienda.dispositivos_inteligentes.service.DetalleProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;


    @GetMapping("/compras")
    public List<Compra> obtenerCompras() {
        return compraService.getAllCompras();
    }

    @GetMapping("/compras/{id}")
    public ResponseEntity<Compra> obtenerCompraPorId(@PathVariable Long id) {
        Optional<Compra> compra = compraService.getCompraById(id);
        return compra.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/compras")
    public Compra guardarCompra(@RequestBody Compra compra) {
        return compraService.saveCompra(compra);
    }


    @PutMapping("/compras/actualizar/{id}")
    public ResponseEntity<Compra> actualizarCompra(@PathVariable Long id, @RequestBody Compra compraActualizada) {
        Optional<Compra> compraExistente = compraService.getCompraById(id);
        if (compraExistente.isPresent()) {
            Compra compra = compraExistente.get();
            // Actualiza los campos
            compra.setCantidad(compraActualizada.getCantidad());
            compra.setFechaCompra(compraActualizada.getFechaCompra());
            compra.setProducto(compraActualizada.getProducto());
            compra.setUsuario(compraActualizada.getUsuario());

            // Guarda la compra actualizada
            Compra compraActualizadaResult = compraService.saveCompra(compra);
            return ResponseEntity.ok(compraActualizadaResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/compras/eliminar/{id}")
    public void eliminarDetalle(@PathVariable Long id) {
        compraService.deleteCompra(id);
    }
}

