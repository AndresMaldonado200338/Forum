package foro.alura.model.topic;


import java.time.LocalDate;

public record DataListTopic(Long id, String titulo, String mensaje, LocalDate fecha_creacion, StatusTopic status_topico, Long usuarioId, Long cursoId) {

    public DataListTopic(Topic topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getStatus_topico(), topico.getAutor().getId(), topico.getCurso().getId());
    }
}