package foro.alura.model.answer;

import java.time.LocalDate;

public record DataListAnswer(Long id, String mensaje, Long topicoId, LocalDate fecha_creacion, Long usuarioId, Boolean solucion) {
    public DataListAnswer(Answer respuesta) {
        this(respuesta.getId(), respuesta.getMensaje(), respuesta.getTopico().getId(), respuesta.getFechaCreacion(),respuesta.getAutor().getId(), respuesta.getSolucion());
    }
}
