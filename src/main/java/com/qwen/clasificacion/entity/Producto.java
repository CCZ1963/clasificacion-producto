package com.qwen.clasificacion.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", nullable = false)
    private String prodNomb;

    // Constructor vacío
    public Producto() {}

    // Constructor útil
    public Producto(String prodNomb) {
        this.prodNomb = prodNomb;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long prodId) { this.id = id; }

    public String getNombre() { return prodNomb; }
    public void setNombre(String prodNomb) { this.prodNomb = prodNomb; }
}
