package foro.alura.model.course;

import jakarta.validation.constraints.NotBlank;

public record DataRegistrationCourse(
        @NotBlank
        String grupo,
        @NotBlank
        String categoria) {
}
