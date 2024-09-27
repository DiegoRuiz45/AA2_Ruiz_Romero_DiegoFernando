package com.tienda.dispositivos_inteligentes.repository;

import com.tienda.dispositivos_inteligentes.model.DetallesProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesProductoRepository extends JpaRepository<DetallesProducto, Long> {
}
