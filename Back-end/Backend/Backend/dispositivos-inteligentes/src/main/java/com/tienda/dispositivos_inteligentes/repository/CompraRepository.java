package com.tienda.dispositivos_inteligentes.repository;

import com.tienda.dispositivos_inteligentes.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
}