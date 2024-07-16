package foro.alura.model.answer;

import java.time.LocalDate;

public record DataAnswer(Long id, LocalDate fecha_creacion, Boolean solucion) {
    public DataAnswer(Answer respuesta) {
        this(respuesta.getId(), respuesta.getFechaCreacion(), respuesta.getSolucion());
    }
}
