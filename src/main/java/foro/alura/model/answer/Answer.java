package foro.alura.model.answer;

import com.fasterxml.jackson.annotation.JsonFormat;

import foro.alura.model.topic.Topic;
import foro.alura.model.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensaje;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topico_id")
	private Topic topico;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaCreacion = LocalDate.now();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private User autor;
	private Boolean solucion = false;

	public Answer(DataRecordResponse datosRegistroRespuesta, Topic topico, User usuario) {
		this.mensaje = datosRegistroRespuesta.mensaje();
		this.topico = topico;
		this.fechaCreacion = datosRegistroRespuesta.fecha_creacion();
		this.autor = usuario;
		this.solucion = false;
	}

	public void actualizarDatosR(DataUpdateResponse datosActualizarRespuesta) {
		if (datosActualizarRespuesta.mensaje() != null) {
			this.mensaje = datosActualizarRespuesta.mensaje();
		}
		if (datosActualizarRespuesta.fecha_creacion() != null) {
			this.fechaCreacion = datosActualizarRespuesta.fecha_creacion();
		}
		if (datosActualizarRespuesta.solucion() != null) {
			this.solucion = datosActualizarRespuesta.solucion();
		}
	}
}

