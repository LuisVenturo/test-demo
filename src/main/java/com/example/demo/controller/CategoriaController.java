package com.example.demo.controller;

import com.example.demo.entity.CategoriaEntity;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/categorias")
public class CategoriaController {
    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping()
    public List<CategoriaEntity> getCategorias() {
        /*ArrayList<CategoriaEntity> categorias = new ArrayList<>();
        for (CategoriaEntity categoria : categoriaRepository.findAll()) {
            categorias.add(categoria);
        }
        return categorias;*/
        List<CategoriaEntity> categorias = categoriaRepository.findAll();
        return categorias;
    }
}
