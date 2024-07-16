package foro.alura.model.course;

public record DataCourse(Long id, String grupo, String categoria) {
    public DataCourse(Course curso) {
        this(curso.getId(), curso.getGrupo(), curso.getCategoria());
    }
}
