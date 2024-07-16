package foro.alura.model.users;

public record UserListData(Long id, String nombre, String email, String contrasena) {

    public UserListData(User usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail(), usuario.getContrasena());
    }
}
