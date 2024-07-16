package foro.alura.model.users;

import jakarta.validation.constraints.NotNull;

public record DataUpdateUser(@NotNull Long id, String nombre, String email) {
}
