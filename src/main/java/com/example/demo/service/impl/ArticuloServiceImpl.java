package com.example.demo.service.impl;

import com.example.demo.entity.ArticuloEntity;
import com.example.demo.repository.ArticuloRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.ArticuloService;

import java.util.List;

public class ArticuloServiceImpl implements ArticuloService {
    private final ArticuloRepository articuloRepository;
    private final UsuarioRepository usuarioRepository;

    public ArticuloServiceImpl(ArticuloRepository articuloRepository, UsuarioRepository usuarioRepository) {
        this.articuloRepository = articuloRepository;
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public ArticuloEntity create(ArticuloEntity articulo) {
        int idUsuario = articulo.getUsuario().getUsuarioId();
        if(!usuarioRepository.existsById(idUsuario)) {
            return null;
        }
        return articuloRepository.save(articulo);
    }

    @Override
    public List<ArticuloEntity> findAll() {
        return List.of();
    }

    @Override
    public ArticuloEntity findById(Integer id) {
        return null;
    }

    @Override
    public ArticuloEntity update(ArticuloEntity articulo, int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
