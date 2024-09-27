package com.tienda.dispositivos_inteligentes.repository;

import com.tienda.dispositivos_inteligentes.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
