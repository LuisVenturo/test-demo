package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "articulos")
public class ArticuloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "articulo_id")
    private Integer articuloId;

    private String titulo;

    private String contenido;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;

    @Column(name = "url")
    private String urlArticulo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<CategoriaEntity> categorias;

}
