package foro.alura.model.course;

public record DataListCourse(Long id, String grupo, String categoria) {

    public DataListCourse(Course curso) {
        this(curso.getId(), curso.getGrupo(), curso.getCategoria());
    }
}
