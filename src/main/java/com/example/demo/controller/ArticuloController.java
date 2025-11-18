package com.example.demo.controller;

import com.example.demo.dto.request.ArticuloCreateDto;
import com.example.demo.dto.response.ArticuloResponseDto;
import com.example.demo.entity.ArticuloEntity;
import com.example.demo.repository.ArticuloRepository;
import com.example.demo.service.ArticuloService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/articulos")
public class ArticuloController {
    private final ArticuloRepository articuloRepository;
    private final ArticuloService articuloService;

    public ArticuloController(ArticuloRepository articuloRepository, ArticuloService articuloService) {
        this.articuloRepository = articuloRepository;
        this.articuloService = articuloService;
    }

    @PostMapping("/save")
    public ArticuloEntity save(@RequestBody ArticuloCreateDto articulo) {
        return articuloService.create(articulo);
    }

    @PostMapping("/categoria")
    public ArticuloEntity agregarCategorias(
            @RequestParam int articuloId,
            @RequestParam ArrayList<Integer> idCategorias){
        return articuloService.agregarCategoria(articuloId, idCategorias);
    }
    @GetMapping("/{id}")
    public ArticuloResponseDto findById(@PathVariable int id) {
        return articuloService.findById(id);
    }
}
