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
    /* @Min(value = 1, message = "La clasificación mínima es 1")
    @Max(value = 5, message = "La clasificación máxima es 5") No se aplican en la base de datos
    sino en la validación de beans cuando uso @Valid */
    private int comentClasif;

    // Los nombres de columna en SQL no deben tener espacios
    // 🔗 Relación: Muchos comentarios → 1 usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Usuario", nullable = false)
    private Usuario usuario;

    // Los nombres de columna en SQL no deben tener espacios
    // 🔗 Relación: Muchos comentarios → 1 usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Producto", nullable = false)
    private Producto producto;

    // Constructor vacío
    public Comentario() {}

    // Constructor útil (sin usuario aún —lo ajustaremos en el servicio)
    public Comentario(String comentTexto, int puntuacion) {
        this.comentTexto = comentTexto;
        this.comentClasif = puntuacion;
        this.comentFecha = LocalDateTime.now();
    }

    /*
    // En analizar()
    Producto producto = productoRepository.findByProdNomb(prodNomb);
    if (producto == null) {
        producto = new Producto(prodNomb);
        producto = productoRepository.save(producto);
    }
    comentario.setProducto(producto);
    */

    // Getters y Setters (incluyendo usuario)
    public Long getComentId() { return comentId; }
    public void setComentId(Long comentId) { this.comentId = comentId; }

    public String getComentTexto() { return comentTexto; }
    public void setComentTexto(String comentTexto) { this.comentTexto = comentTexto; }

    public int getComentClasif() { return comentClasif; }
    public void setComentClasif(int comentClasif) { this.comentClasif = comentClasif; }

    public LocalDateTime getComentFecha() { return comentFecha; }
    public void setComentFecha(LocalDateTime comentFecha) { this.comentFecha = comentFecha; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

}
