package foro.alura.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import foro.alura.model.answer.*;
import foro.alura.model.topic.Topic;
import foro.alura.model.topic.TopicRepository;
import foro.alura.model.users.User;
import foro.alura.model.users.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class AnswerController {

    @Autowired
    private AnswerRepository respuestaRepository;

    @Autowired
    private TopicRepository topicoRepository;

    @Autowired
    private UserRepository usuarioRepository;

    @PostMapping
    @Transactional
    public List<DataAnswer> registrarRespuesta(@RequestBody @Valid DataRecordResponse datosRegistroRespuesta) {
        Topic topico = topicoRepository.getReferenceById(datosRegistroRespuesta.topicoId());
        User usuario = usuarioRepository.getReferenceById(datosRegistroRespuesta.usuarioId());
        Answer respuesta = new Answer(datosRegistroRespuesta, topico, usuario);
        respuestaRepository.save(respuesta);
        return respuestaRepository.findAll().stream().map(DataAnswer::new).toList();
    }

    @GetMapping
    public List<DataListAnswer> listadoRespuestas() {
        return respuestaRepository.findAll().stream().map(DataListAnswer::new).toList();
    }

    @PutMapping
    @Transactional
    public void actualizarRespuesta(@RequestBody @Valid DataUpdateResponse datosActualizarRespuesta) {
        Answer respuesta = respuestaRepository.getReferenceById(datosActualizarRespuesta.id());
        respuesta.actualizarDatosR(datosActualizarRespuesta);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarRespuesta(@PathVariable Long id) {
        Answer respuesta = respuestaRepository.getReferenceById(id);
        respuestaRepository.delete(respuesta);
    }
}
