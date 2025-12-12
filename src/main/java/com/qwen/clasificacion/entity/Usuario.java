package com.qwen.clasificacion.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", nullable = false)
    private String userNomb;

    @Column(name = "Email", nullable = false, unique = true)
    private String userEmail;

    // Constructor vacío
    public Usuario() {}

    // Constructor útil
    public Usuario(String userNomb, String userEmail) {
        this.userNomb = userNomb;
        this.userEmail = userEmail;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long userId) { this.id = id; }

    public String getEmail() { return userEmail; }
    public void setEmail(String userEmail) { this.userEmail = userEmail; }

    public String getNombre() { return userNomb; }
    public void setNombre(String userNomb) { this.userNomb = userNomb; }
}
