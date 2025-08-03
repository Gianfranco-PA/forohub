package com.gianfranco.forohub.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gianfranco.forohub.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TopicDTO (
        @NotBlank(message = "El título es obligatorio")
        @Size(max = 100, message = "El título no debe exceder 100 caracteres")
        String title,
        @NotBlank(message = "El mensaje es obligatorio")
        String message,
        Status status,
        @NotBlank(message = "El autor es obligatorio")
        @Size(max = 50, message = "El nombre del autor no debe exceder 50 caracteres")
        String author,
        @NotBlank(message = "El curso es obligatorio")
        @Size(max = 50, message = "El nombre del curso no debe exceder 50 caracteres")
        String course
) {
}
