package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "comentarios")
public class ComentarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comenatario_id")
    private int comentarioId;
    private String contenido;
    private Date fechaCreacion;
    private Date fechaActualizacion;

    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private ArticuloEntity articulo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

}
