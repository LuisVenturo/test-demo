package com.example.demo.controller;

import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/{id}")
    public UsuarioEntity getById(@PathVariable int id) {
        Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            UsuarioEntity usuariobd = usuarioOptional.get();
            return usuariobd;
        }
        return null;
    }

    @PostMapping("/save")
    public UsuarioEntity create(@RequestBody UsuarioEntity usuario) {
        usuarioRepository.save(usuario);
        return usuario;
    }

    @GetMapping("/find")
    public ArrayList<UsuarioEntity> findUsuario(
            @RequestParam(required = false) Date fechaNacimiento,
            @RequestParam(required = false) String sexo
    ) {
        return usuarioRepository.finByFechaNacimientoAndSexo(fechaNacimiento, sexo);
    }

}