package foro.alura.model.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String email;
	private String contrasena;

	public User(UserRegistryData datosRegistroUsuario) {
		this.nombre = datosRegistroUsuario.nombre();
		this.email = datosRegistroUsuario.email();
		this.contrasena = datosRegistroUsuario.contrasena();
	}

	public void actualizarDatosUsuario(DataUpdateUser datosActualizarUsuario) {
		if (datosActualizarUsuario.nombre() != null) {
			this.nombre = datosActualizarUsuario.nombre();
		}
		if (datosActualizarUsuario.email() != null) {
			this.nombre = datosActualizarUsuario.email();
		}
	}
}

