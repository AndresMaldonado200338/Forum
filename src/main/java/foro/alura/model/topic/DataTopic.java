package foro.alura.model.topic;

public record DataTopic(Long id, String titulo, String mensaje, Long usuarioId, Long cursoId) {
    public DataTopic(Topic topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor().getId(), topico.getCurso().getId());
    }

}
