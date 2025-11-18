package com.example.demo.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ArticuloResponseDto {
    private int articuloId;
    private String titulo;
    private String contenido;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private String urlArticulo;
    private UsuarioResponseArticuloDto usuario;
    private List<CategoriaResponseArticuloDto> categorias;
}
