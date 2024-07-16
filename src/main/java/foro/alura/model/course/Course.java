package foro.alura.model.course;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cursos")
@Entity(name = "Curso")
@EqualsAndHashCode(of = "id")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String grupo;
	private String categoria;

	public Course(DataRegistrationCourse datosRegistroCurso) {
		this.grupo = datosRegistroCurso.grupo();
		this.categoria = datosRegistroCurso.categoria();
	}
	public void actualizarDatosCurso(DataUpdateCourse datosActualizarCurso) {
		if (datosActualizarCurso.grupo() != null) {
			this.grupo = datosActualizarCurso.grupo();
		}
		if (datosActualizarCurso.categoria() != null) {
			this.categoria = datosActualizarCurso.categoria();
		}
	}
}
