package com.service.cursos_service.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="titulo",length = 120, nullable = false, unique = true)
    private String titulo;

    @Column(name ="descripcion",length = 120, nullable = false, unique = true)
    private String descripcion;

    @Column(name ="precio",length = 120, nullable = false, unique = true)
    private Double precio;

    @Column(name ="EstadoCurso",length = 120, nullable = false, unique = true)
    Boolean EstadoCurso;

    @Column(name ="fechaDePublicacion",length = 120, nullable = false, unique = true)
    private LocalDateTime fechaDePublicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria",  nullable = false)
    private Categoria categoria;


}
