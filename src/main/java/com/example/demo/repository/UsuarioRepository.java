package com.example.demo.repository;

import com.example.demo.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Integer> {
    /*@Query(value = "select * from usuarios where fecha_nacimiento > :fechaNacimiento and sexo = :sexo",  nativeQuery = true)
    ArrayList<UsuarioEntity> finByFechaNacimientoAndSexo(Date fechaNacimiento, String sexo);*/

    @Query(value = """
                SELECT * FROM usuarios
                WHERE fecha_nacimiento > COALESCE(CAST(:fechaNacimiento AS date), DATE '0001-01-01')
                    AND sexo = COALESCE(CAST(:sexo AS varchar), sexo)
            """, nativeQuery = true)
    ArrayList<UsuarioEntity> finByFechaNacimientoAndSexo(
            @Param("fechaNacimiento") Date fechaNacimiento,
            @Param("sexo") String sexo);


}
