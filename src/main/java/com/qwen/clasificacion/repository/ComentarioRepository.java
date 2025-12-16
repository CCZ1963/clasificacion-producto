package com.qwen.clasificacion.repository;

import com.qwen.clasificacion.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    // JpaRepository ya provee: save(), findById(), findAll(), delete(), etc.
}
