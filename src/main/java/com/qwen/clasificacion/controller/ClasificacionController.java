package com.qwen.clasificacion.controller;

import com.qwen.clasificacion.entity.Comentario;
import com.qwen.clasificacion.service.ClasificacionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class ClasificacionController {

    private final ClasificacionService clasificacionService;

    public ClasificacionController(ClasificacionService clasificacionService) {
        this.clasificacionService = clasificacionService;
    }

    // ✅ Nuevo: ahora recibe email y nombre del usuario
    @PostMapping("/analizar")
    public Comentario analizar(
            @Valid @RequestBody ClasificacionRequest request  // ← ¡Agrega @Valid!
    ) {
        return clasificacionService.analizar(
                request.getComentTexto(),
                request.getUserEmail(),
                request.getUserNomb(),
                request.getProdNomb(),
                request.getPuntuacion()
        );
    }

    @GetMapping("/comentarios")
    public List<Comentario> listarComentarios() {
        return clasificacionService.listarTodos();  // lo agregaremos en el servicio
    }
}
