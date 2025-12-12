package com.qwen.clasificacion.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Fecha")
    private LocalDateTime fechaAnalisis;

    @Column(name = "Comentario", nullable = false, length = 150)
    private String texto;

    @Column(name="Clasificación", nullable = false)
    private String clasificacion;

    // 🔗 Relación: Muchos comentarios → 1 usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id Usuario", nullable = false)
    private Usuario usuario;

    // 🔗 Relación: Muchos comentarios → 1 usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id Producto", nullable = false)
    private Producto producto;

    // Constructor vacío
    public Comentario() {}

    // Constructor útil (sin usuario aún —lo ajustaremos en el servicio)
    public Comentario(String texto, String clasificacion) {
        this.texto = texto;
        this.clasificacion = clasificacion;
        this.fechaAnalisis = LocalDateTime.now();
    }

    // Getters y Setters (incluyendo usuario)
    public Long getId() { return id; }
    public void setId(Long comentId) { this.id = id; }

    public String getTexto() { return texto; }
    public void setTexto(String comentTexto) { this.texto = texto; }

    public String getSentimiento() { return clasificacion; }
    public void setSentimiento(String sentimiento) { this.clasificacion = clasificacion; }

    public LocalDateTime getFechaAnalisis() { return fechaAnalisis; }
    public void setFechaAnalisis(LocalDateTime fechaAnalisis) { this.fechaAnalisis = fechaAnalisis; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
}
