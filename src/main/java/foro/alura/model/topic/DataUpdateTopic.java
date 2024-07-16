package foro.alura.model.topic;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DataUpdateTopic(@NotNull Long id, String titulo, String mensaje, LocalDate fecha_creacion) {
}
