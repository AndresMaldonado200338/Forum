package foro.alura.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import foro.alura.model.course.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CourseRepository cursoRepository;

    @PostMapping
    @Transactional
    public List<DataCourse> registrarCurso(@RequestBody @Valid DataRegistrationCourse datosRegistroCurso) {
        cursoRepository.save(new Course(datosRegistroCurso));
        return cursoRepository.findAll().stream().map(DataCourse::new).toList();
    }
    @GetMapping
    public List<DataListCourse> listadoCurso() {
        return cursoRepository.findAll().stream().map(DataListCourse::new).toList();
    }
    @PutMapping
    @Transactional
    public void actualizarCurso(@RequestBody @Valid DataUpdateCourse datosActualizarCurso) {
        Course curso = cursoRepository.getReferenceById(datosActualizarCurso.id());
        curso.actualizarDatosCurso(datosActualizarCurso);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarCurso(@PathVariable Long id) {
        Course curso = cursoRepository.getReferenceById(id);
        cursoRepository.delete(curso);
    }
}
