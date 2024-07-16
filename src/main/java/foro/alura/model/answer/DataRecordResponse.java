package foro.alura.model.answer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DataRecordResponse(
        @NotBlank
        String mensaje,
        @NotNull
        @Valid
        Long topicoId,
        @NotNull
        @Valid
        LocalDate fecha_creacion,
        @NotNull
        @Valid
        Long usuarioId,
        @NotNull
        @Valid
        Boolean solucion
) {
}
