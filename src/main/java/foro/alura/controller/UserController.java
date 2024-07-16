package foro.alura.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import foro.alura.model.users.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserRepository usuarioRepository;

    @PostMapping
    @Transactional
    public List<UserData> registrarUsuario(@RequestBody @Valid UserRegistryData datosRegistroUsuario) {
        usuarioRepository.save(new User(datosRegistroUsuario));
        return usuarioRepository.findAll().stream().map(UserData::new).toList();
    }

    @GetMapping
    public List<UserListData> listadoUsuarios() {
        return usuarioRepository.findAll().stream().map(UserListData::new).toList();
    }

    @PutMapping
    @Transactional
    public void actualizarUsuario(@RequestBody @Valid DataUpdateUser datosActualizarUsuario) {
        User usuario = usuarioRepository.getReferenceById(datosActualizarUsuario.id());
        usuario.actualizarDatosUsuario(datosActualizarUsuario);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarUsuario(@PathVariable Long id) {
        User usuario = usuarioRepository.getReferenceById(id);
        usuarioRepository.delete(usuario);
    }
}
