package foro.alura.model.answer;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DataUpdateResponse(@NotNull Long id, String mensaje, LocalDate fecha_creacion, Boolean solucion) {
}
