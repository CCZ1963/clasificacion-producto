package com.qwen.clasificacion.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentId;

    @Column(name = "Fecha")
    private LocalDateTime comentFecha;

    @Column(name = "Comentario", nullable = false, length = 150)
    private String comentTexto;

    @Column(name="Clasificación", nullable = false)
    private String comentClasif;

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
    public Comentario(String comentTexto, String comentClasif) {
        this.comentTexto = comentTexto;
        this.comentClasif = comentClasif;
        this.comentFecha = LocalDateTime.now();
    }

    // Getters y Setters (incluyendo usuario)
    public Long getComentId() { return comentId; }
    public void setComentId(Long comentId) { this.comentId = this.comentId; }

    public String getComentTexto() { return comentTexto; }
    public void setComentTexto(String comentTexto) { this.comentTexto = this.comentTexto; }

    public String getComentClasif() { return comentClasif; }
    public void setComentClasif(String comentClasif) { this.comentClasif = comentClasif; }

    public LocalDateTime getComentFecha() { return comentFecha; }
    public void setComentFecha(LocalDateTime comentFecha) { this.comentFecha = comentFecha; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
}
