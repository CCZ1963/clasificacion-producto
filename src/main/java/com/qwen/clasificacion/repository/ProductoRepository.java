package com.qwen.clasificacion.repository;

import com.qwen.clasificacion.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Producto findByProdNomb(String prodNomb);
    Optional<Producto> findByProdNomb(String prodNomb);
}
