package com.tienda.dispositivos_inteligentes.repository;

import com.tienda.dispositivos_inteligentes.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}