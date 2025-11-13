package com.example.demo.controller;

import com.example.demo.repository.ArticuloRepository;
import com.example.demo.entity.ArticuloEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BasicController {

    private final ArticuloRepository articuloRepository;

    public BasicController(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @GetMapping("/hola")
    public String holaEndPoint() {
        return "hola desde spring";
    }

    @GetMapping("/adios")
    public String adiosEndPoint() {
        return "Adios desde spring";
    }

    // Listar todos
    @GetMapping("/articulos")
    public List<ArticuloEntity> listarTodos() {
        return articuloRepository.findAll();
    }

    // Buscar por ID
    @GetMapping("/articulos/{id}")
    public ResponseEntity<ArticuloEntity> findById(@PathVariable Integer id) {
        return articuloRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
