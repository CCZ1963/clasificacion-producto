package com.qwen.clasificacion.controller;

import jakarta.validation.constraints.*;

public class ClasificacionRequest {

    @NotBlank(message = "El campo 'comentTexto' es obligatorio")
    @Size(max = 500, message = "El texto no debe exceder los 500 caracteres")
    private String comentTexto;

    @NotBlank(message = "El campo 'userEmail' es obligatorio")
    @Email(message = "El email debe tener un formato válido")
    private String userEmail;

    @NotBlank(message = "El campo 'userNomb' es obligatorio")
    @Size(max = 100, message = "El nombre no debe exceder los 100 caracteres")
    private String userNomb;

    @NotBlank(message = "El campo 'prodNomb' es obligatorio")
    @Size(max = 100, message = "El nombre no debe exceder los 100 caracteres")
    private String prodNomb;

    @Min(value = 1, message = "La puntuación mínima es 1")
    @Max(value = 5, message = "La puntuación máxima es 5")
    private int puntuacion;  // ← ¡Nuevo campo!

    // Constructor vacío (obligatorio)
    public ClasificacionRequest() {}

    // Getters y Setters
    public String getComentTexto() { return comentTexto; }
    public void setComentTexto(String comentTexto) { this.comentTexto = comentTexto; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getUserNomb() { return userNomb; }
    public void setUserNomb(String userNomb) { this.userNomb = userNomb; }

    public String getProdNomb() { return prodNomb; }
    public void setProdNomb(String prodNomb) { this.prodNomb = prodNomb; }

    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }
}
