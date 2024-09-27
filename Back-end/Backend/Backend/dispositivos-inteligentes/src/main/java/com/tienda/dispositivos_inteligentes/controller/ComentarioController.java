package com.tienda.dispositivos_inteligentes.controller;

import com.tienda.dispositivos_inteligentes.model.Comentario;
import com.tienda.dispositivos_inteligentes.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;


    @GetMapping("/comentarios")
    public List<Comentario> obtenerComentarios() {
        return comentarioService.getAllComentarios();
    }

    @GetMapping("/comentarios/{id}")
    public ResponseEntity<Comentario> obtenerComentarioPorId(@PathVariable Long id) {
        Optional<Comentario> comentario = comentarioService.getComentarioById(id);
        return comentario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/comentarios")
    public Comentario guardarComentario(@RequestBody Comentario comentario) {
        return comentarioService.saveComentario(comentario);
    }

    @PutMapping("/comentarios/actualizar/{id}")
    public ResponseEntity<Comentario> actualizarComentario(@PathVariable Long id, @RequestBody Comentario comentarioActualizado) {
        Optional<Comentario> comentarioExistente = comentarioService.getComentarioById(id);
        if (comentarioExistente.isPresent()) {
            Comentario comentario = comentarioExistente.get();

            // Actualizar los campos
            comentario.setContenido(comentarioActualizado.getContenido());
            comentario.setFechaComentario(comentarioActualizado.getFechaComentario());
            comentario.setProducto(comentarioActualizado.getProducto());
            comentario.setUsuario(comentarioActualizado.getUsuario());

            // Guardar el comentario actualizado
            Comentario comentarioActualizadoResult = comentarioService.saveComentario(comentario);
            return ResponseEntity.ok(comentarioActualizadoResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/comentarios/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        comentarioService.deleteComentario(id);
    }
}
