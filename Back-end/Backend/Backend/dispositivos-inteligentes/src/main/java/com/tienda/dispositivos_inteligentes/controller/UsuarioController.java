package com.tienda.dispositivos_inteligentes.controller;

import com.tienda.dispositivos_inteligentes.model.Comentario;
import com.tienda.dispositivos_inteligentes.model.Usuario;
import com.tienda.dispositivos_inteligentes.service.ComentarioService;
import com.tienda.dispositivos_inteligentes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/usuarios/guardar")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @PutMapping("/usuarios/actualizar/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        Optional<Usuario> usuarioExistente = usuarioService.getUsuarioById(id);
        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();

            // Actualizar los campos
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setApellido(usuarioActualizado.getApellido());
            usuario.setEmail(usuarioActualizado.getEmail());
            usuario.setDireccion(usuarioActualizado.getDireccion());
            usuario.setTelefono(usuarioActualizado.getTelefono());
            usuario.setUsuario(usuarioActualizado.getUsuario());
            usuario.setContrasena(usuarioActualizado.getContrasena());

            // Guardar el usuario actualizado
            Usuario usuarioActualizadoResult = usuarioService.saveUsuario(usuario);
            return ResponseEntity.ok(usuarioActualizadoResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }


}

