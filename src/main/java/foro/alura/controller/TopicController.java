package foro.alura.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import foro.alura.model.course.Course;
import foro.alura.model.course.CourseRepository;
import foro.alura.model.topic.*;
import foro.alura.model.users.User;
import foro.alura.model.users.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @Autowired
    private TopicRepository topicoRepository;

    @Autowired
    private UserRepository usuarioRepository;

    @Autowired
    private CourseRepository cursoRepository;

    @PostMapping
    @Transactional
    public List<DataTopic> registrarTopico(@RequestBody @Valid DataRecordTopic datosRegistroTopico) {

        User usuario = usuarioRepository.getReferenceById(datosRegistroTopico.usuarioId());
        Course curso = cursoRepository.getReferenceById(datosRegistroTopico.cursoId());
        Topic topico = new Topic(datosRegistroTopico, usuario, curso);
        topicoRepository.save(topico);
        return topicoRepository.findAll().stream().map(DataTopic::new).toList();
    }

    @GetMapping
    public List<DataListTopic> listadoTopicos() {
        return topicoRepository.findAll().stream().map(DataListTopic::new).toList();
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DataUpdateTopic datosActualizarTopico) {
        Topic topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id) {
        Topic topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }

}
