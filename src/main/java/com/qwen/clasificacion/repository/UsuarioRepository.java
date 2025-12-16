package com.qwen.clasificacion.repository;

import com.qwen.clasificacion.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String userEmail);  // Spring genera la consulta automáticamente
}
