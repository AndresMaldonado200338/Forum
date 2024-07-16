package foro.alura.model.course;

import jakarta.validation.constraints.NotNull;

public record DataUpdateCourse(@NotNull Long id, String grupo, String categoria) {
}
