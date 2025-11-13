package com.example.demo.repository;

import com.example.demo.entity.ArticuloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ArticuloRepository extends JpaRepository<ArticuloEntity, Integer> {
    @Query(value = "select * from articulos where fecha_creacion > :fecha or fecha_actualizacion < :fecha", nativeQuery = true)
    List<ArticuloEntity> findArticulosByFechas(Date fecha);
}
