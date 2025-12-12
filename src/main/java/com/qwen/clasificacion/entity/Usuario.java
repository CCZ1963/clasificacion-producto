package com.qwen.clasificacion.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

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
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getUserNomb() { return userNomb; }
    public void setUserNomb(String userNomb) { this.userNomb = userNomb; }
}
