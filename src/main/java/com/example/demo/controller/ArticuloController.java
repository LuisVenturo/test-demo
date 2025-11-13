package com.example.demo.controller;

import com.example.demo.entity.ArticuloEntity;
import com.example.demo.repository.ArticuloRepository;
import com.example.demo.service.ArticuloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
@RestController
@RequestMapping("/api/v1/articulos")
public class ArticuloController {
    private final ArticuloRepository articuloRepository;
    private final ArticuloService articuloService;

    public ArticuloController(ArticuloRepository articuloRepository, ArticuloService articuloService) {
        this.articuloRepository = articuloRepository;
        this.articuloService = articuloService;
    }

    @GetMapping()
    public List<ArticuloEntity> listarTodos() {
        return articuloRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticuloEntity> findById(@PathVariable Integer id) {
        return articuloRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // hacer un find para articulo en el cual enviemos los siguientes parametros
    // fechaCreacion
    // fechaActualizacion
    // traer los articulos en los que la fecha de creacion sea mayor a una determinada fecha
    // o que su fecha de actualizacion sea menor a una determinada fecha

    @GetMapping("/find")
    public ResponseEntity<List<ArticuloEntity>> findArticulos(
            @RequestParam Date fecha
    ) {
        return ResponseEntity.ok(articuloRepository.findArticulosByFechas(fecha));
    }

    /*public ResponseEntity<List<ArticuloEntity>> findArticulos(){
        return articuloRepository.findAll();
    }*/

    /// /////////////segunda version
    @PostMapping("/save")
    public ArticuloEntity save(@RequestBody ArticuloEntity articulo) {
        return articuloService.create(articulo);
    }
}
