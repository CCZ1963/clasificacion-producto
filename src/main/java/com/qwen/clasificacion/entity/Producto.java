package com.qwen.clasificacion.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodId;

    @Column(name = "Nombre", nullable = false)
    private String prodNomb;

    // Constructor vacío
    public Producto() {}

    // Constructor útil
    public Producto(String prodNomb) {
        this.prodNomb = prodNomb;
    }

    // Getters y Setters
    public Long getProdId() { return prodId; }
    public void setProdId(Long prodId) { this.prodId = prodId; }

    public String getProdNomb() { return prodNomb; }
    public void setProdNomb(String prodNomb) { this.prodNomb = prodNomb; }
}
