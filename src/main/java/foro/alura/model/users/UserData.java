package foro.alura.model.users;

public record UserData( Long id, String nombre, String email) {
    public UserData(User usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail());
    }
}
