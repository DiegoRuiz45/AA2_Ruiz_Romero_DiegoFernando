package com.tienda.dispositivos_inteligentes.repository;


import com.tienda.dispositivos_inteligentes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}