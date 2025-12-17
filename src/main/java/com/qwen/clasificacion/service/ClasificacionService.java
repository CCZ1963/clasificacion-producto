package com.qwen.clasificacion.service;

import com.qwen.clasificacion.entity.Comentario;
import com.qwen.clasificacion.entity.Usuario;
import com.qwen.clasificacion.entity.Producto;
import com.qwen.clasificacion.repository.ComentarioRepository;
import com.qwen.clasificacion.repository.UsuarioRepository;
import com.qwen.clasificacion.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasificacionService {

    private final UsuarioRepository usuarioRepository;
    private final ComentarioRepository comentarioRepository;
    private final ProductoRepository productoRepository;

    public ClasificacionService(UsuarioRepository usuarioRepository,
                                ComentarioRepository comentarioRepository,
                                ProductoRepository productoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.comentarioRepository = comentarioRepository;
        this.productoRepository = productoRepository;
    }


    // En tu servicio (ClasificacionService.java)
    public Producto obtenerProducto(Long prodId) {
        return productoRepository.findById(prodId)
                .orElseThrow(() -> new RuntimeException("Producto con ID " + prodId + " no encontrado"));
                // Acá debe haber un término de ingreso y volver a entregar datos con 
    }

    public String clasificar(int comentClasif) {
        if (comentClasif == 5) {
            return "excelente";
        } else if (comentClasif == 4) {
            return "buena";
        } else if (comentClasif == 3) {
            return "neutra";
        } else if (comentClasif == 2) {
            return "regular";
        } else {
            return "mala";
        }
    }

    public Comentario analizar(String comentTexto, String userEmail, String userNomb, String prodNomb, int puntuacion) {
        // 1. Obtener o crear usuario
        Usuario usuario = usuarioRepository.findByUserEmail(userEmail);
        if (usuario == null) {
            usuario = new Usuario(userEmail, userNomb);
            usuario = usuarioRepository.save(usuario);  // lo guarda y devuelve con ID asignado
        }

        // 2. Producto
        /* Producto producto = productoRepository.findByProdNomb(prodNomb);
        if (producto == null) {
            producto = new Producto(prodNomb);
            producto = productoRepository.save(producto);
        } */
        // ✅ En ClasificacionService.analizar()

        // 2. Producto
        Optional<Producto> productoOpt = productoRepository.findByProdNomb(prodNomb);
        Producto producto = productoOpt.orElseGet(() -> {
            Producto nuevo = new Producto(prodNomb);
            return productoRepository.save(nuevo);
        });

        // 3. Clasificar
        String clasificacion = clasificar(puntuacion);

        // 4. Crear y guardar comentario con usuario
        Comentario comentario = new Comentario(comentTexto, puntuacion);
        comentario.setUsuario(usuario);
        comentario.setProducto(producto);
        return comentarioRepository.save(comentario);
    }

    // ✅ Método nuevo: listar todos los comentarios
    public List<Comentario> listarTodos() {
        return comentarioRepository.findAll();
    }

}
